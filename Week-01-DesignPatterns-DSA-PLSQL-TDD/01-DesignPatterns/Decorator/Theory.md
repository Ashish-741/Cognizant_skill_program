# Decorator Design Pattern

## What is Decorator?
The **Decorator Pattern** is a structural design pattern that lets you attach new behaviors and functionalities to objects dynamically by placing these objects inside special wrapper objects that contain the behaviors.

---

## Advantages
- **Extending Behavior Without Subclassing:** You can add or remove responsibilities from an object at runtime without creating a massive explosion of static subclasses (like `EmailAndSmsAndSlackNotifier`).
- **Single Responsibility Principle (SRP):** You can divide a monolithic feature that implements many variants of behavior into several smaller, focused decorator classes.
- **Runtime Flexibility:** Clients can stack decorators in any combination or order dynamically based on user preferences.

---

## Disadvantages
- **Hard to Remove Wrappers:** It is difficult to remove a specific decorator from the middle of a decorated wrapper stack once instantiated.
- **Small Class Proliferation:** Results in many tiny wrapper classes that can look confusing to developers unfamiliar with the pattern.

---

## Real World Example
- **Multi-Channel Notifications:** When an enterprise system triggers an alert, standard users receive just an email. Premium or on-call SRE engineers can dynamically check boxes in their settings to receive SMS or Slack alerts as well. Instead of coding every permutation, decorators wrap the base `EmailNotifier` dynamically.
- **Java I/O Streams:** `new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")))` is the canonical example of the Decorator pattern in standard Java libraries.

---

## Interview Questions

### Q1: What is the difference between Decorator and Proxy patterns?
**Answer:**
- Both share an identical structural wrapper design. However, **Decorator** focuses on *adding or enriching functionality* dynamically without changing the object's interface.
- **Proxy** focuses on *controlling access* to an object (e.g., lazy loading, security checking, caching, or network remote proxying) without necessarily enhancing its primary behavior.

### Q2: Why is inheritance considered static while Decorator is dynamic?
**Answer:** In Java, subclass inheritance is fixed at compile time (`class A extends B`). An object created as type `A` can never change its parent behaviors while running. The **Decorator pattern** uses object composition; you can wrap or unwrap objects inside different decorators at runtime based on user clicks or conditional logic!
