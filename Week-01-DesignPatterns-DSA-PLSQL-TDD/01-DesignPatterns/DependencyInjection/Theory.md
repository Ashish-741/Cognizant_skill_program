# Dependency Injection (DI) Pattern

## What is Dependency Injection?
**Dependency Injection (DI)** is a fundamental software design pattern and technique that implements **Inversion of Control (IoC)** for resolving dependencies. Instead of a class creating its own dependencies internally using the `new` keyword (`new CustomerRepositoryImpl()`), external code (or an IoC container like Spring) injects the required dependencies into the class.

---

## Advantages
- **Decoupling & Loose Coupling:** Classes depend on abstractions (interfaces) rather than concrete implementations.
- **Enhanced Testability:** In unit testing (using JUnit and Mockito), you can easily inject mock or stub implementations of the repository into the service without touching database connections.
- **Code Reusability & Maintainability:** If you switch from an Oracle database repository to an AWS DynamoDB repository, you only change the injected configuration without altering a single line inside `CustomerService`.

---

## Disadvantages
- **Learning Curve:** Can make the initial code architecture feel more abstract and difficult to trace for junior developers.
- **Framework Overhead:** When used with heavy IoC frameworks (like Spring or Google Guice), startup time and memory footprint increase.

---

## Real World Example
- **Spring Framework / Spring Boot:** In enterprise Spring Boot microservices, `@Autowired` or **Constructor Injection** is used everywhere. When `CustomerController` needs `CustomerService`, Spring's IoC ApplicationContext creates a singleton bean of the service and injects it automatically into the controller's constructor at startup.

---

## Interview Questions

### Q1: Why is Constructor Injection preferred over Field Injection (`@Autowired` on fields)?
**Answer:**
1. **Immutability:** Constructor injection allows you to declare dependency fields as `final`, ensuring they cannot be reassigned or mutated after object initialization.
2. **Null Safety:** Prevents `NullPointerException`. An object cannot be instantiated without its mandatory dependencies being passed to the constructor.
3. **Framework Independence:** You can instantiate and unit test the class using plain Java (`new CustomerService(mockRepo)`) without starting the heavy Spring IoC container.

### Q2: What are the 3 main types of Dependency Injection?
**Answer:**
1. **Constructor Injection:** Dependencies are provided through a class constructor (Best Practice for mandatory dependencies).
2. **Setter Injection:** Dependencies are provided through public setter methods (Useful for optional or configurable dependencies).
3. **Interface Injection:** The dependency provides an injector method that will inject the dependency into any client passing itself to the injector.
