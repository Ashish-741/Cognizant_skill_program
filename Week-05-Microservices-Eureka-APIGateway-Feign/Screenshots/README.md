# Week 5 Execution Verification & Proofs

This directory houses visual evidence and terminal output logs verifying the successful execution of Week 5 Microservices architecture implementations.

## Proof Checklist

- `01_eureka_dashboard.png` — Screenshot of the Eureka Server Dashboard (`localhost:8761`) showing active registered microservices.
- `02_api_gateway_routing.png` — Postman/Browser screenshot showing successful routing through the API Gateway on port `8080`.
- `03_feign_client_response.png` — Console logs showing `EmployeeService` successfully calling `DepartmentService` via OpenFeign.
- `04_feign_fallback.png` — Verification of Circuit Breaker fallback response when the target service is intentionally stopped.
