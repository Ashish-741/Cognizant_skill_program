# Microservices Architecture & Service Discovery

## 1. Monolithic vs. Microservices Architecture
- **Monolithic Architecture:** A single unified codebase containing all business logic (UI, services, database access) deployed as a single artifact (e.g., one large `.war` or `.jar` file). Scaling requires duplicating the entire application, which is resource-inefficient.
- **Microservices Architecture:** The application is divided into small, loosely coupled, independently deployable services organized around business capabilities (e.g., `OrderService`, `PaymentService`, `InventoryService`). They communicate over a network via lightweight protocols (HTTP/REST or message brokers like Kafka).

## 2. The Service Discovery Problem
In a microservices ecosystem, service instances have dynamically assigned IP addresses and ports that change frequently due to autoscaling, container restarts, or failures. Hardcoding IP addresses (e.g., `http://192.168.1.15:8080/api/users`) in client code is impossible to maintain.

## 3. Netflix Eureka (Service Registry) Solution
**Spring Cloud Netflix Eureka** acts as a telephone directory for microservices.
- **Eureka Server:** The central registry server (`@EnableEurekaServer`).
- **Eureka Client:** Every microservice registers itself with the Eureka server upon startup, providing its App Name (`spring.application.name`), IP, and port.
- When `Service A` needs to call `Service B`, it asks Eureka for the IP of `Service B` rather than hardcoding it.

---

## 4. Top GenC Next Interview Questions

### Q1: Why do we set `register-with-eureka: false` and `fetch-registry: false` in the Eureka Server's `application.yml`?
**Answer:**
By default, every Spring Cloud Eureka application tries to act as a client and register itself with a registry. Since the Eureka Server *is* the registry itself, it does not need to register with itself. Setting these properties to `false` prevents infinite loops and unnecessary network overhead on the server node.

### Q2: How does Eureka handle service failures (Heartbeats)?
**Answer:**
Eureka clients send periodic "heartbeat" signals (typically every 30 seconds) to the Eureka Server. If the server does not receive a heartbeat from a specific instance for a configured duration (usually 90 seconds), it assumes the instance is dead and removes it from the registry, ensuring downstream clients don't route traffic to a failing node.
