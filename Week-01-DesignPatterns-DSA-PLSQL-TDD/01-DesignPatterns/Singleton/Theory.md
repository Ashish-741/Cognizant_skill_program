# Singleton Design Pattern

## What is Singleton?
The **Singleton Pattern** is a creational design pattern that guarantees a class has only one instance throughout the entire application lifecycle and provides a global point of access to that instance.

---

## Advantages
- **Controlled Access to Single Instance:** Prevents conflicting requests or memory bloat when managing shared resources (e.g., database connections, logging pools, application config).
- **Reduced Memory Footprint:** Instantiated only once and reused across all threads.
- **Lazy Initialization:** Can be constructed only when first requested, saving startup time and system resources.

---

## Disadvantages
- **Hidden Dependencies:** Can introduce global state into an application, making tight coupling harder to track.
- **Testing Challenges:** Difficult to mock or isolate during unit testing without dependency injection frameworks.
- **Multi-Threading Complexity:** Poorly written singletons can suffer from race conditions or require expensive synchronization overhead.

---

## Real World Example
- **Database Connection Pool:** In enterprise Java applications, initializing a database connection is expensive. A `DatabaseConnectionManager` singleton ensures that all application components reuse a centralized, thread-safe connection pool instead of creating new connections per user request.
- **Spring Beans:** By default, all beans managed by the Spring IoC container are Singletons.

---

## Interview Questions

### Q1: How do you make a Singleton thread-safe without sacrificing performance?
**Answer:** Use **Double-Checked Locking** with the `volatile` keyword. The `volatile` keyword prevents JVM instruction reordering, while checking `if (instance == null)` twice (once outside synchronization and once inside) ensures thread safety without locking threads after initial instantiation.

### Q2: Can a Singleton be broken? How do you prevent it?
**Answer:** Yes, it can be broken via:
1. **Reflection:** Can access private constructors using `setAccessible(true)`. *Fix:* Throw a `RuntimeException` inside the constructor if `instance != null`.
2. **Serialization:** Deserializing an object creates a new instance. *Fix:* Implement `readResolve()` method to return the existing instance.
3. **Cloning:** Calling `clone()`. *Fix:* Override `clone()` and throw `CloneNotSupportedException`.
*(Note: Using a Java `enum` natively prevents reflection and serialization issues).*
