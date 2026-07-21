# API Gateway & Client-Side Load Balancing

## 1. What is an API Gateway?
An **API Gateway** acts as a reverse proxy and the single entry point for all client (Frontend/Mobile) requests. Instead of the frontend needing to know the IP addresses of 20 different microservices, it sends all requests to `http://localhost:8080/api/employees` and the Gateway routes the request to the correct internal microservice.

### Benefits of an API Gateway:
- **Centralized Routing:** Masks internal microservice IPs.
- **Cross-Cutting Concerns:** Handles global tasks like Authentication/Authorization (JWT validation), CORS, Rate Limiting, and Logging in one place rather than duplicating logic across 20 services.

## 2. Server-Side vs. Client-Side Load Balancing
- **Server-Side Load Balancing (Traditional):** A hardware appliance or software (like NGINX/HAProxy) sits between the client and the servers. The client sends a request to NGINX, and NGINX picks an instance.
- **Client-Side Load Balancing (Spring Cloud):** The "client" (in this case, the API Gateway or another microservice) caches the list of available IP addresses from the Eureka Registry. When a request needs to be made, the client itself applies a Round-Robin algorithm to pick an IP address and sends the request directly. This avoids a central bottleneck.

---

## 3. Top GenC Next Interview Questions

### Q1: Why does Spring Cloud Gateway use Spring WebFlux instead of Spring Web MVC?
**Answer:**
Spring Cloud Gateway is built on **Project Reactor** (Spring WebFlux) and uses the **Netty** server instead of Tomcat. Because a gateway handles *every single request* coming into the system, it must be highly concurrent. WebFlux is non-blocking and asynchronous, allowing a small number of threads to handle thousands of concurrent routing requests without blocking/waiting for backend services to respond. Therefore, you cannot include `spring-boot-starter-web` (Tomcat) in a Gateway project.

### Q2: What does the `lb://` protocol mean in the Gateway routes configuration?
**Answer:**
The `lb://` prefix (e.g., `uri: lb://EMPLOYEE-SERVICE`) instructs the Gateway's internal LoadBalancer implementation to intercept the routing request. Instead of treating `EMPLOYEE-SERVICE` as a DNS hostname, it queries the Eureka registry for all IP addresses associated with that service ID, picks one using an algorithm (like Round Robin), and forwards the request to that specific IP.
