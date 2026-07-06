# Proxy Design Pattern

## What is Proxy?
The **Proxy Pattern** is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. A proxy intercepts all requests to the real subject, allowing you to perform actions (such as lazy initialization, security authentication, logging, or caching) either before or after forwarding the request.

---

## Advantages
- **Lazy Initialization (Performance):** If an object is extremely heavy to load into memory (like a 50MB image or remote database socket), a proxy defers instantiation until the exact moment a client calls a method on it.
- **Security & Authorization:** Can act as a protective proxy, verifying whether the logged-in user has permission to invoke methods on the real subject.
- **Caching & Network Resilience:** Can cache network results locally, returning cached responses when backend servers are slow or unreachable.

---

## Disadvantages
- **Increased Latency on Cache Miss:** The initial request might take slightly longer due to the proxy routing overhead and lazy loading delay.
- **Code Verbosity:** Introduces additional proxy wrapper classes for every real subject interface.

---

## Real World Example
- **Hibernate / JPA Lazy Loading:** When you load an `Employee` entity that has a `@OneToMany` relationship with `List<Transaction>`, Hibernate injects a **proxy collection**. The thousands of database transactions are NOT loaded from Oracle DB until you explicitly call `employee.getTransactions().size()`.
- **Spring `@Transactional` & `@Async`:** Spring uses CGLIB and JDK dynamic proxies to wrap bean classes, intercepting method calls to open and close database transactions automatically.

---

## Interview Questions

### Q1: What are the different types of Proxies in software architecture?
**Answer:**
1. **Virtual Proxy:** Defers creation of expensive or resource-heavy objects until needed (e.g., our `ProxyImage` example).
2. **Protection / Security Proxy:** Controls access based on user access rights or authentication roles.
3. **Remote Proxy:** Represents an object residing in a different address space or remote JVM (e.g., Java RMI or gRPC client stubs).
4. **Caching Proxy:** Temporarily stores results of expensive database queries or API calculations.
