# Factory Method Design Pattern

## What is Factory Method?
The **Factory Method Pattern** is a creational design pattern that provides an interface or method for creating objects in a superclass, but allows subclasses or factory classes to alter the type of objects that will be created.

---

## Advantages
- **Loose Coupling:** Separates object creation logic from the client code that uses the objects. Clients only interact with the common interface (`Notification`).
- **Single Responsibility Principle (SRP):** Centralizes object creation code in one dedicated location (`NotificationFactory`).
- **Open/Closed Principle (OCP):** You can introduce new product types (e.g., `PushNotification`, `WhatsAppNotification`) without modifying existing client code.

---

## Disadvantages
- **Increased Code Complexity:** Requires creating multiple interfaces and subclass implementations even for simple object creation.
- **Class Proliferation:** Can lead to a large number of small classes in the codebase.

---

## Real World Example
- **Notification Channels:** An e-commerce platform needs to send order confirmations via Email, SMS, or WhatsApp depending on user preferences. A `NotificationFactory` inspects the user's choice and returns the corresponding `Notification` object dynamically at runtime.
- **JDBC Driver DriverManager:** `DriverManager.getConnection()` acts as a factory returning different database connection objects (Oracle, MySQL, PostgreSQL) based on the JDBC URL string.

---

## Interview Questions

### Q1: What is the difference between Simple Factory and Factory Method?
**Answer:** A **Simple Factory** uses a single class with a conditional statement (`if-else` or `switch`) to instantiate classes based on input parameters. The **Factory Method** defines an abstract method in a creator superclass and lets subclass implementations decide which concrete product to instantiate, fully adhering to the Open/Closed Principle.

### Q2: Why shouldn't we just use the `new` keyword everywhere instead of a Factory?
**Answer:** Hardcoding object creation with `new` tightly couples the client code to concrete implementations. If the construction logic changes (e.g., adding mandatory constructor arguments), you would have to find and modify every `new` statement across the entire codebase. A factory centralizes this change in one spot.
