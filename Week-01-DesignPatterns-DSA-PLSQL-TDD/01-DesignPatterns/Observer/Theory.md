# Observer Design Pattern

## What is Observer?
The **Observer Pattern** is a behavioral design pattern that defines a one-to-many dependency between objects so that when one object (the **Subject** / Observable) changes state, all its dependents (**Observers**) are notified and updated automatically.

---

## Advantages
- **Loose Coupling:** The subject only knows that observers implement a common interface (`Investor`). It doesn't need to know concrete observer classes or their internal logic.
- **Dynamic Subscription:** Observers can register or unregister at runtime without modifying or restarting the subject.
- **Event-Driven Architecture:** Ideal for broadcasting live events across distributed components.

---

## Disadvantages
- **Memory Leaks (Lapsed Listener Problem):** If observers forget to unregister from a long-lived subject, garbage collection cannot reclaim them, causing memory leaks.
- **Unordered Notifications:** Observers are notified in arbitrary order, which can cause subtle bugs if observers depend on a specific execution sequence.

---

## Real World Example
- **Stock Market Ticker:** A `StockMarket` subject tracks share prices (e.g., TCS, Infosys). Thousands of retail investors, mutual fund algorithms, and mobile apps subscribe as observers. Whenever the price changes, the ticker automatically broadcasts notifications to all active subscribers.
- **Social Media Follows:** When you follow a creator on YouTube or Twitter, your notification feed acts as an observer subscribed to their video upload events.

---

## Interview Questions

### Q1: What is the difference between Push and Pull communication models in Observer?
**Answer:** In the **Push model**, the subject sends the detailed state data directly inside the update notification argument (`investor.update("TCS", 3850.00)`). In the **Pull model**, the subject just sends a minimal notification (`investor.update()`), and the observer must query getter methods on the subject reference to pull whatever data it needs.

### Q2: How does Observer relate to the Publish-Subscribe (Pub/Sub) pattern?
**Answer:** While similar, in **Observer**, the subject and observer are aware of each other and communicate directly in the same address space. In **Pub/Sub** (used in message brokers like Kafka or RabbitMQ), publishers and subscribers are completely decoupled by an intermediate **Message Broker / Topic**, allowing asynchronous cross-network communication.
