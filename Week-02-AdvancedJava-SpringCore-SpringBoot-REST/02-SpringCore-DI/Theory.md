# Spring Framework Fundamentals: IoC & Dependency Injection

## What is Inversion of Control (IoC) & Dependency Injection (DI)?
- **Inversion of Control (IoC):** A software architecture principle where the control of creating, managing, and binding objects is inverted from the application code to an external container (the **Spring IoC Container** / `ApplicationContext`).
- **Dependency Injection (DI):** The mechanism used by the IoC container to fulfill dependencies. Instead of an object constructing its own dependencies (`new EmailService()`), the container injects the required dependencies into the object at runtime via constructors, setters, or fields.

---

## Advantages
- **Decoupled Components:** Classes depend on interfaces (`MessageService`) rather than concrete implementations (`EmailService`), adhering strictly to the **Dependency Inversion Principle (DIP)**.
- **Effortless Unit Testing:** During unit testing with JUnit and Mockito, you can easily swap out real database services for mock implementations without modifying production constructor signatures.
- **Centralized Lifecycle Management:** Spring automatically handles initialization (`@PostConstruct`), destruction (`@PreDestroy`), and memory scopes (Singleton vs Prototype) across thousands of beans.

---

## Disadvantages
- **Runtime Errors vs Compile Errors:** If a required bean is missing `@Component` or has ambiguous `@Qualifier` bindings, the application builds successfully but crashes at runtime during startup with `NoSuchBeanDefinitionException` or `NoUniqueBeanDefinitionException`.
- **Memory Consumption:** An IoC container holds references to all singleton beans throughout the entire application lifecycle, increasing baseline Heap memory footprint.
- **Black-Box Magic:** Autowiring and component scanning can make code hard to trace for junior developers who cannot see explicit object instantiation.

---

## Real World Example
- **Enterprise Notification Service:** A `NotificationController` requires a way to send alerts. In a traditional approach, hardcoding `new EmailService()` prevents switching to SMS alerts during network outages. With Spring DI, the container inspects `@Qualifier("emailService")` and injects the active channel dynamically at startup.

---

## Interview Questions

### Q1: What is the difference between Constructor Injection and Setter / Field Injection? Which does Spring recommend?
**Answer:**
- **Constructor Injection:** Dependencies are passed through the class constructor. *Recommended by Spring* because:
  1. It ensures the bean cannot be instantiated in an invalid/incomplete state without its mandatory dependencies.
  2. It allows fields to be marked as `final`, guaranteeing immutability and thread safety.
  3. It makes testing easier without starting the Spring container (you can instantiate via standard `new Controller(mockService)`).
- **Setter Injection:** Dependencies are injected via setter methods. Recommended only for *optional* dependencies that can be changed or reconfigured dynamically after startup.
- **Field Injection (`@Autowired` directly on private fields):** *Discouraged* because it uses reflection, prevents fields from being `final`, and hides class dependencies from outside observers.

### Q2: What are the different Spring Bean Scopes?
**Answer:**
1. **`singleton` (Default):** Exactly one instance per Spring IoC container. Shared across all requests and threads.
2. **`prototype`:** A brand new bean instance is created *every single time* the bean is requested from the container (`getBean()` or autowired).
3. **`request` (Web only):** A new bean instance per HTTP request.
4. **`session` (Web only):** A new bean instance per HTTP user session.
5. **`application` (Web only):** Shared across the entire `ServletContext`.
