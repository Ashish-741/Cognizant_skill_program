# Module 01: Architecture & Design Patterns (11 Comprehensive Exercises)

This directory contains full implementations, test classes, and theoretical documentation (`Theory.md`) for **11 software design patterns and architectural concepts** as prescribed in the Cognizant DNS 5.0 curriculum and instructor exercise sheets.

---

## 🛠️ Pattern Implementations & Exercises

### 1. Singleton Pattern (`Singleton/`)
- **Exercise 1 Match:** Implements `Logger.java` with private constructor, static volatile instance, and Double-Checked Locking. Verified via `LoggerDemo.java`.
- **Bonus:** Also includes enterprise `DatabaseConnectionManager.java` implementation.

### 2. Factory Method Pattern (`Factory/`)
- **Exercise 2 Match:** Implements `DocumentFactory.java` producing `WordDocument`, `PdfDocument`, and `ExcelDocument`. Verified via `DocumentFactoryDemo.java`.
- **Bonus:** Also includes multi-channel `NotificationFactory.java`.

### 3. Builder Pattern (`Builder/`)
- **Exercise 3 Match:** Implements `Computer.java` featuring a static nested `Builder` class managing optional hardware specifications (CPU, RAM, HDD, GraphicsCard). Verified via `BuilderDemo.java`.

### 4. Adapter Pattern (`Adapter/`)
- **Exercise 4 Match:** Implements `PaymentProcessor.java` target interface with `StripeAdapter` and `PayPalAdapter` translating calls to incompatible third-party payment SDKs (`StripeGateway`, `PayPalGateway`). Verified via `AdapterDemo.java`.

### 5. Decorator Pattern (`Decorator/`)
- **Exercise 5 Match:** Implements dynamic notification channel stacking (`EmailNotifier`, wrapped by `SMSNotifierDecorator` and `SlackNotifierDecorator`). Verified via `DecoratorDemo.java`.

### 6. Proxy Pattern (`Proxy/`)
- **Exercise 6 Match:** Implements `ProxyImage.java` acting as a surrogate for `RealImage.java`, providing **lazy initialization** and **in-memory caching** to avoid redundant remote server downloads. Verified via `ProxyDemo.java`.

### 7. Observer Pattern (`Observer/`)
- **Exercise 7 Match:** Implements stock market broadcast monitoring where `StockMarket` subject notifies registered observers (`MobileApp`, `WebApp`, `Investor`) whenever live share prices fluctuate. Verified via `ObserverDemo.java`.

### 8. Strategy Pattern (`Strategy/`)
- **Exercise 8 Match:** Implements `PaymentContext.java` allowing runtime selection and switching between interchangeable billing strategies (`CreditCardPayment`, `PayPalPayment`). Verified via `StrategyPatternDemo.java`.

### 9. Command Pattern (`Command/`)
- **Exercise 9 Match:** Implements a home automation `RemoteControl` invoker executing encapsulated `LightOnCommand` and `LightOffCommand` objects against physical `Light` hardware receivers. Verified via `CommandDemo.java`.

### 10. Model-View-Controller (MVC) Pattern (`MVC/`)
- **Exercise 10 Match:** Implements clean architectural separation of student records into `Student` (Model), `StudentView` (UI console display), and `StudentController` (mediator handling data binding). Verified via `MVCDemo.java`.

### 11. Dependency Injection (DI) Pattern (`DependencyInjection/`)
- **Exercise 11 Match:** Implements **Constructor Injection** where `CustomerService` depends strictly on the `CustomerRepository` abstraction rather than tightly coupling to `CustomerRepositoryImpl`. Verified via `DependencyInjectionDemo.java`.

---

## 📑 Documentation
Every subfolder contains a dedicated **`Theory.md`** file outlining:
- Definition & Architectural Category (Creational, Structural, Behavioral)
- Advantages & Disadvantages
- Real World Enterprise Use Cases (Spring Boot, Hibernate, AWS)
- Frequently Asked Interview Questions for GenC Next / GenC Pro technical rounds.
