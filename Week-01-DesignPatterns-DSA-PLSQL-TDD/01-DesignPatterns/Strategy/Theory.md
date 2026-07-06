# Strategy Design Pattern

## What is Strategy?
The **Strategy Pattern** is a behavioral design pattern that enables selecting an algorithm at runtime. Instead of implementing a single algorithm directly, code receives runtime instructions specifying which family of algorithms to use.

---

## Advantages
- **Runtime Flexibility:** Algorithms (e.g., payment options, compression methods, sorting routines) can be swapped dynamically while the program is running.
- **Eliminates Conditional Sprawl:** Replaces lengthy `if-else if-else` or `switch` statements in business logic with clean polymorphic method calls.
- **Open/Closed Principle (OCP):** You can add new strategies (e.g., adding `NetBankingPayment` or `CryptoPayment`) without altering existing checkout context code.

---

## Disadvantages
- **Client Awareness:** Clients must understand the differences between strategies to select the appropriate one.
- **Increased Object Count:** Each strategy requires creating a separate concrete class implementing the interface.

---

## Real World Example
- **E-Commerce Checkout (`ShoppingCart`):** When customers check out, they can choose to pay via Credit Card, UPI, or Net Banking. The shopping cart doesn't care how the banking transaction works; it delegates the payment execution to whichever `PaymentStrategy` object was passed to `checkout(...)`.
- **Java `Comparator` Interface:** `Collections.sort(list, comparator)` uses the Strategy pattern. You pass different `Comparator` lambda strategies to sort employees by name, salary, or department dynamically.

---

## Interview Questions

### Q1: What is the difference between Strategy and State design patterns?
**Answer:** Both share the identical UML class diagram (Context delegating to an Interface). However, in the **Strategy pattern**, the client explicitly chooses the strategy, and strategies are generally independent of each other. In the **State pattern**, the internal state transitions automatically based on method invocations, and state classes are aware of next/previous states (e.g., Vending Machine states: `Idle` -> `CoinInserted` -> `Dispensing`).

### Q2: How does Java 8 Lambda simplify the Strategy pattern?
**Answer:** Since `PaymentStrategy` is a functional interface (single abstract method `pay(amount)`), you no longer need to write verbose concrete classes for simple strategies. You can pass lambda expressions directly:
`cart.checkout(amount -> System.out.println("Paid via Apple Pay: ₹" + amount));`
