# Architecture Notes & Study Guide

This section contains conceptual study notes on software engineering principles, clean code practices, and system design fundamentals learned during Cognizant DNS 5.0.

---

## 1. SOLID Design Principles Explained Simply

| Principle | Meaning | Real-World Analogy |
| :--- | :--- | :--- |
| **S - Single Responsibility Principle (SRP)** | A class should have one, and only one, reason to change. | A chef should cook food, not repair the restaurant's electrical wiring. Separate `OrderProcessor` from `EmailNotifier`. |
| **O - Open/Closed Principle (OCP)** | Software entities should be open for extension, but closed for modification. | Plug-and-play USB ports: You can attach new devices without soldering wires inside the motherboard. Use Interfaces/Strategies. |
| **L - Liskov Substitution Principle (LSP)** | Child classes must be substitutable for their parent classes without breaking application behavior. | If a function expects a `Bird`, passing a `Penguin` shouldn't cause an unsupported exception when `fly()` is called. Separate `FlyingBird` from `FlightlessBird`. |
| **I - Interface Segregation Principle (ISP)** | Clients should not be forced to implement interfaces they do not use. | Don't create a giant `MultiFunctionDevice` interface with `print()`, `fax()`, `scan()`, and `staple()`. Split into smaller, focused interfaces. |
| **D - Dependency Inversion Principle (DIP)** | High-level modules should not depend on low-level modules. Both should depend on abstractions. | A laptop charger plugs into a standard AC wall socket interface, not directly wired into the power grid's generator. |

---

## 2. Choosing the Right Design Pattern

```text
Need a single shared resource across the application?
   └──> Use SINGLETON (e.g., Database Connection Pool, App Configuration)

Need to hide complex object creation logic based on input parameters?
   └──> Use FACTORY METHOD (e.g., creating Email vs. SMS Notification channels)

Need to construct complex objects with numerous optional configurations?
   └──> Use BUILDER (e.g., PC Customizer, HTTP Request Builder)

Need to notify multiple independent subscribers when state changes?
   └──> Use OBSERVER (e.g., Stock Market Ticker, Event Listeners)

Need to switch algorithms or business logic dynamically at runtime?
   └──> Use STRATEGY (e.g., Credit Card vs. UPI Payment checkout)
```

---

## 3. Why Logging Matters in Enterprise Applications

Using `System.out.println()` in production Java applications is considered an **antipattern** because:
1. **No Log Levels:** Cannot differentiate between routine debugging info and fatal application crashes.
2. **Performance Degradation:** `System.out.println()` is synchronized and blocks I/O threads.
3. **No File Rotation:** Logs cannot be directed to rolling log files, centralized log aggregators (ELK stack), or external monitoring services.
4. **No Formatting:** Lacks standardized timestamps, thread IDs, and execution context.

Always use an abstraction facade like **SLF4J** paired with an efficient backend engine like **Logback** or **Log4j2**.
