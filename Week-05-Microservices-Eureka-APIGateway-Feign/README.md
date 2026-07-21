# Week 5: Microservices Architecture, Service Discovery & API Gateway

## Topics Covered

- Microservices Architecture vs. Monolithic Architecture
- Service Registry & Discovery using Spring Cloud Netflix Eureka
- API Gateway Pattern using Spring Cloud Gateway
- Client-Side Load Balancing (Spring Cloud LoadBalancer / Ribbon concepts)
- Synchronous Inter-service Communication using declarative OpenFeign Clients
- Fallback mechanisms and REST Template configurations

---

## Folder Structure

```text
01-ServiceDiscovery-EurekaServer
02-APIGateway-LoadBalancing
03-InterServiceCommunication-Feign
Assignments
Screenshots
```

---

## Learning Outcomes

- Understood the trade-offs of breaking down monolithic applications into independent, loosely coupled microservices.
- Deployed a highly available Netflix Eureka Service Registry where microservices can dynamically register and discover each other.
- Built an API Gateway to act as a single entry point for clients, routing HTTP requests to the appropriate downstream microservice instances.
- Implemented declarative HTTP clients using `@FeignClient` to simplify synchronous communication between microservices without boilerplate REST Template code.
- Grasped the concepts of centralized configuration, distributed tracing, and fault tolerance within a distributed systems environment.

---

## Status

🟢 In Progress
