# DevOps & Cloud Concepts (GenC Next Cheat Sheet)

This document aligns with the final module of the Java FSE track, focusing on containerization, automation, and cloud basics required for the Capstone project and technical interviews.

---

## 1. Docker Containerization

### What is Docker?
Docker is an open-source platform that automates the deployment, scaling, and management of applications inside isolated environments called **Containers**. It solves the "It works on my machine" problem.

### Container vs. Virtual Machine (VM)
- **Virtual Machine**: Emulates an entire hardware system, requiring a full Guest Operating System (e.g., Windows/Linux) on top of the host. Very heavy, slow to start, consumes GBs of RAM.
- **Container**: Shares the Host OS kernel. Only packages the application and its direct dependencies (libraries/binaries). Very lightweight, starts in milliseconds, consumes MBs of RAM.

### Docker Core Components
1. **Dockerfile**: A text document containing all commands a user could call on the command line to assemble an image.
2. **Docker Image**: A read-only, immutable template with instructions for creating a Docker container. Built from a Dockerfile.
3. **Docker Container**: A runnable instance of a Docker image.
4. **Docker Hub**: A cloud-based registry service for sharing Docker images.

### Important Docker Commands
```bash
docker build -t my-app:1.0 .    # Builds an image from the current directory Dockerfile
docker run -p 8080:8080 my-app  # Runs the container and maps host port to container port
docker ps                       # Lists running containers
docker stop <container_id>      # Stops a running container
```

### Docker Compose
A tool for defining and running multi-container Docker applications using a `docker-compose.yml` file. E.g., Starting a Spring Boot app and a MySQL database simultaneously and networking them together automatically.

---

## 2. CI/CD (Continuous Integration / Continuous Deployment)

### Continuous Integration (CI)
The practice of merging all developers' working copies to a shared mainline several times a day.
- **Goal**: Detect integration errors quickly.
- **Workflow**: Developer pushes code -> CI Server (GitHub Actions/Jenkins) pulls code -> Runs automated build (`mvn clean compile`) -> Runs automated tests (JUnit/Mockito) -> Reports success/failure.

### Continuous Delivery (CD)
The automation step where verified code is automatically released to a repository or staging environment. The final deployment to production requires manual approval.

### Continuous Deployment (CD)
Every change that passes all stages of the production pipeline is released to the end-users automatically, with no human intervention.

---

## 3. Cloud Fundamentals (AWS / Azure Basics)

### Service Models
- **IaaS (Infrastructure as a Service)**: Vendor provides raw hardware (VMs, storage, network). You manage OS, runtime, and app. *Example: AWS EC2, Azure Virtual Machines.*
- **PaaS (Platform as a Service)**: Vendor provides OS and runtime. You just manage your application code. *Example: AWS Elastic Beanstalk, Heroku.*
- **SaaS (Software as a Service)**: Fully managed software accessible via web browser. *Example: Gmail, Salesforce.*

### Key AWS Services for Java FSE
| Concept | AWS Service | Azure Equivalent | Purpose |
|---------|-------------|------------------|---------|
| **Compute / VM** | EC2 (Elastic Compute Cloud) | Azure VM | Hosting your Spring Boot / React apps on raw servers. |
| **Object Storage** | S3 (Simple Storage Service) | Azure Blob Storage | Storing static files, images, frontend React builds. |
| **Relational DB** | RDS (Relational Database Service)| Azure SQL Database | Managed MySQL/PostgreSQL databases. No need to install DBs manually. |
| **Containers** | ECS / EKS | AKS (Azure Kubernetes)| Running and orchestrating Docker containers at scale. |

---

## 4. Top GenC Next Interview Questions

### Q1: What is a Multi-Stage Docker Build?
**Answer**: It uses multiple `FROM` statements in a single Dockerfile. The first stage uses a heavy image (like Maven with JDK) to compile the source code into a `.jar` file. The second stage uses a lightweight image (like JRE Alpine) and only copies the compiled `.jar` from the first stage. This drastically reduces the final Docker image size and improves security by excluding source code and build tools from the production container.

### Q2: How do containers communicate in Docker Compose?
**Answer**: Docker Compose automatically sets up a single default network for your app. Each container joins the network and is both reachable by other containers on that network, and discoverable by them at a hostname identical to the container name (e.g., in Spring Boot, the DB url becomes `jdbc:mysql://mysql-db:3306/db`).

### Q3: What happens if a Docker container crashes, what happens to its data?
**Answer**: By default, data inside a container is ephemeral (temporary). If the container is deleted or crashes, the data is lost. To persist data (like a database storage), you must mount a **Docker Volume** to the host machine.
