# REST API Exception Handling & Jakarta Validation

## Why Centralize Exception Handling?
In production REST architectures, scattering `try-catch` blocks across individual controller endpoints leads to bloated, unreadable code and inconsistent HTTP status responses.
- **`@RestControllerAdvice`:** A specialization of `@ControllerAdvice` combined with `@ResponseBody`. It acts as a cross-cutting AOP interceptor that intercepts unhandled exceptions thrown anywhere in the DispatcherServlet request pipeline and converts them into structured JSON error payloads (`ErrorResponseDTO`).

---

## Jakarta Validation Workflow
1. Client sends a JSON payload to `POST /api/v1/employees`.
2. Spring MVC binds the JSON to `EmployeeRequestDTO` and evaluates annotations prefixed with `@Valid`.
3. If any field violates constraints (`@NotBlank`, `@Email`, `@Min`), Spring throws `MethodArgumentNotValidException`.
4. Our `@ExceptionHandler(MethodArgumentNotValidException.class)` inside `GlobalExceptionHandler` intercepts the error and returns **HTTP 400 Bad Request** with explicit field-level error messages.

---

## Advantages
- **Strict Separation of Concerns:** Controllers focus purely on HTTP routing and happy paths; exception handlers manage all failure states.
- **Uniform API Contracts:** Consumers (React, Angular, Mobile clients) always receive identical JSON schemas for errors (`timestamp`, `status`, `error`, `message`, `path`).

---

## Top Interview Questions

### Q1: What is the difference between `@ControllerAdvice` and `@RestControllerAdvice`?
**Answer:**
`@RestControllerAdvice` is simply `@ControllerAdvice + @ResponseBody`. When using `@ControllerAdvice` alone, methods returning objects must be explicitly annotated with `@ResponseBody` to serialize them into JSON/XML. `@RestControllerAdvice` automatically applies `@ResponseBody` to all handler methods.

### Q2: How do you return custom HTTP status codes from an `@ExceptionHandler` method?
**Answer:**
Return a `ResponseEntity<T>` wrapping the custom DTO and specify the exact status code (`HttpStatus.NOT_FOUND`, `HttpStatus.CONFLICT`, `HttpStatus.BAD_REQUEST`), or annotate the exception handler method directly with `@ResponseStatus(HttpStatus.NOT_FOUND)`.
