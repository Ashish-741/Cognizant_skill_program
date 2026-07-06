# Command Design Pattern

## What is Command?
The **Command Pattern** is a behavioral design pattern that turns a request or action into a standalone object that contains all information about the request. This transformation lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.

---

## Advantages
- **Single Responsibility Principle (SRP):** Decouples classes that invoke operations (`RemoteControl` / Invoker) from classes that perform these operations (`Light` / Receiver).
- **Open/Closed Principle (OCP):** You can introduce new commands into the application without breaking existing client code or invokers.
- **Undo / Redo Support:** By adding an `undo()` method to the `Command` interface and storing executed commands in a stack history, you can reverse actions cleanly.
- **Asynchronous Execution & Queuing:** Command objects can be serialized, placed in message brokers (like RabbitMQ or ActiveMQ), and executed asynchronously by background worker threads.

---

## Disadvantages
- **Code Verbosity:** Requires creating a separate concrete command class for every individual user action or button press, leading to an explosion of small classes.

---

## Real World Example
- **GUI Buttons & Menu Items:** In desktop or web applications (like IDEs or text editors), clicking "Save", pressing `Ctrl+S`, or selecting `File -> Save` from the top toolbar all execute the exact same underlying `SaveCommand` object. The GUI buttons act as invokers and do not need to know how file I/O works.
- **Database Transaction Logs & Rollbacks:** Relational databases log every INSERT, UPDATE, and DELETE statement as command objects. If a crash occurs during a transaction, the database reads the command log backwards and executes `.undo()` to restore schema consistency.

---

## Interview Questions

### Q1: What are the 4 core actors in the Command pattern?
**Answer:**
1. **Command Interface:** Declares the execution method (`execute()`).
2. **Concrete Command:** Binds a receiver object with an action (`LightOnCommand`).
3. **Receiver:** Knows how to perform the actual business logic or physical work (`Light`).
4. **Invoker:** Asks the command to carry out the request (`RemoteControl`).

### Q2: How does the Command pattern differ from the Strategy pattern?
**Answer:** Both encapsulate algorithms into objects. However:
- **Strategy** encapsulates *different algorithms for doing the exact same task* (e.g., sorting by name vs. sorting by date, or paying via Card vs. PayPal). The goal is interchangeability.
- **Command** encapsulates *completely different actions or operational workflows* into objects (e.g., Turning on a Light vs. Opening a Garage Door vs. Sending an Email). The goal is decoupling sender from receiver and enabling queuing/undo.
