# Week 5 Assignments & Mini-Project Evaluation

## Hands-on Tasks

1. **Service Discovery Implementation:**
   - Create a Spring Boot application acting as a Eureka Server.
   - Configure two separate Spring Boot microservices (`OrderService` and `InventoryService`) to register as Eureka Clients.
   - Verify their registration on the Eureka Dashboard at `http://localhost:8761`.

2. **API Gateway & Routing:**
   - Build a Spring Cloud Gateway application.
   - Configure dynamic routing so that requests to `/api/orders/**` are routed to `OrderService` and `/api/inventory/**` to `InventoryService`.
   - Implement a global Pre-filter in the Gateway to log the incoming request timestamp and HTTP method.

3. **Inter-service Communication:**
   - Use OpenFeign in the `OrderService` to synchronously fetch stock availability from the `InventoryService` before confirming an order.
   - Implement a Fallback class (Circuit Breaker) for the Feign Client to return a default "Out of Stock" message if `InventoryService` is down, preventing cascading failures.
