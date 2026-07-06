# Adapter Design Pattern

## What is Adapter?
The **Adapter Pattern** is a structural design pattern that allows objects with incompatible interfaces to collaborate. It acts as a wrapper between two objects: it catches calls for one object and transforms them to format and interface recognizable by the second object.

---

## Advantages
- **Single Responsibility Principle (SRP):** You separate data or interface conversion code from the primary business logic of the client program.
- **Open/Closed Principle (OCP):** You can introduce new types of adapters into the application without breaking existing client code, as long as they work with the adapters through the common interface (`PaymentProcessor`).
- **Reusability of Legacy / Third-Party APIs:** Allows integrating third-party SDKs (like Stripe or PayPal JARs) whose code cannot be modified directly.

---

## Disadvantages
- **Increased Code Complexity:** The overall complexity of the code increases because you need to introduce a set of new interfaces and adapter classes. Sometimes it is simpler to just change the service class so that it matches the rest of your code.

---

## Real World Example
- **Payment Gateway Aggregators:** An e-commerce checkout app defines a standard `processPayment(amount)` method. Third-party banking SDKs (HDFC, PayPal, Stripe) all have different method signatures (`chargeCard`, `sendFunds`, `transfer`). Adapters translate standard checkout calls into vendor-specific API invocations.
- **Java IO Streams:** `InputStreamReader` acts as an adapter, adapting raw byte streams (`InputStream`) into character streams (`Reader`).

---

## Interview Questions

### Q1: What is the difference between Object Adapter and Class Adapter?
**Answer:**
- **Object Adapter:** Employs object composition. The adapter implements the target interface and holds a private instance reference to the adaptee object. *Supported natively in Java.*
- **Class Adapter:** Employs multiple inheritance to inherit interfaces from both the target and adaptee simultaneously. *Not supported natively in Java* because Java does not allow multiple class inheritance.

### Q2: How does Adapter pattern differ from Facade pattern?
**Answer:**
- **Adapter** wraps a *single* existing object to change its interface to match what the client expects.
- **Facade** defines a brand new simplified, unified interface to coordinate an entire *subsystem* of multiple complex classes (e.g., orchestrating Inventory, Billing, and Shipping subsystems in one `OrderFacade.placeOrder()` call).
