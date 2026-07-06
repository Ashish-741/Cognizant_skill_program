# Spring Boot Auto-configuration & RESTful APIs

## What is Spring Boot?
**Spring Boot** is an opinionated framework built on top of the traditional Spring Framework designed to simplify bootstraping and development of production-ready Java applications. It eliminates XML configuration boilerplate by providing **Auto-Configuration** (`@EnableAutoConfiguration`) and **Starter Dependencies** (`spring-boot-starter-web`).

## What is a RESTful API?
**REST (Representational State Transfer)** is an architectural style for designing networked web services. It uses standard HTTP methods (`GET`, `POST`, `PUT`, `DELETE`, `PATCH`) to perform CRUD operations on resources identified by URIs (`/api/v1/employees`).

---

## Advantages of Spring Boot
- **Zero XML Configuration:** Employs Convention over Configuration using Java annotations (`@SpringBootApplication`, `@RestController`).
- **Embedded Web Servers:** Bundles Apache Tomcat directly inside the executable JAR, eliminating the need to deploy WAR files to external web server instances.
- **Production Readiness:** Includes Spring Boot Actuator for out-of-the-box health checks, metrics, and monitoring endpoints.

---

## Disadvantages
- **High Memory Consumption:** Embedded Tomcat, Auto-Configuration scanners, and countless default beans increase baseline memory requirements (minimum ~200MB+ RAM per container).
- **Binary Size:** Fat executable JARs containing all nested dependency JARs can easily exceed 50MB–80MB.

---

## Real World Example
- **Cognizant Microservices Gateway:** In enterprise client projects, Spring Boot powers backend microservices exposing JSON REST endpoints. When a React frontend queries `GET /api/v1/employees/101`, the Spring Boot `@RestController` intercepts the HTTP request, queries the business `@Service`, serializes the `Employee` DTO to JSON using Jackson, and returns an HTTP `200 OK` response.

---

## Interview Questions

### Q1: What is the difference between `@Controller` and `@RestController`?
**Answer:**
- `@Controller`: Standard MVC annotation where controller methods return a **String representing a View template name** (like a Thymeleaf or JSP HTML page).
- `@RestController`: A specialized composite annotation combining `@Controller` and `@ResponseBody`. Every method inside a `@RestController` automatically serializes its return object into JSON/XML and writes it directly to the HTTP response body.

### Q2: What is the difference between `@RequestParam` and `@PathVariable`?
**Answer:**
- `@PathVariable`: Extracts values embedded directly in the URI path hierarchy (e.g., `/api/v1/employees/{id}`). Used to identify a specific unique resource.
- `@RequestParam`: Extracts values passed as query parameters after the `?` symbol (e.g., `/api/v1/employees?department=IT&sort=asc`). Used for filtering, pagination, and sorting.

### Q3: Why should you return `ResponseEntity<T>` instead of raw objects from REST controllers?
**Answer:** Returning raw objects (`public Employee getEmp()`) forces Spring to always return HTTP Status `200 OK`, even if an error occurs or a resource is created. **`ResponseEntity<T>`** gives you full programmatic control over the HTTP response:
1. **Status Codes:** Returning `HttpStatus.CREATED` (201) on `POST`, `HttpStatus.NO_CONTENT` (204) on `DELETE`, or `HttpStatus.NOT_FOUND` (404) when an ID does not exist.
2. **Custom HTTP Headers:** Injecting location headers or authentication tokens into the response.
