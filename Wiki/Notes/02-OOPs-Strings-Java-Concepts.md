# Core Java: OOPs & String Concepts (GenC Next Cheat Sheet)

This document aligns with the foundational Java requirements for Cognizant technical interviews, heavily focusing on Object-Oriented Principles and String manipulation required for DSA rounds.

---

## 1. Object-Oriented Programming (OOPs) Core Pillars

### 1.1 Encapsulation
- **Definition:** Wrapping data (variables) and code (methods) together as a single unit. Data is hidden from other classes (`private`) and can be accessed only through `public` getter/setter methods.
- **Why?** Protects object integrity and prevents unauthorized data modification.
- **Interview Question:** *How is Data Hiding achieved?* Using access modifiers (`private`, `protected`).

### 1.2 Abstraction
- **Definition:** Hiding internal implementation details and showing only functionality to the user. 
- **Implementation:** Achieved using `abstract` classes (0 to 100% abstraction) or `interface` (100% abstraction prior to Java 8 default methods).
- **Interview Question:** *Difference between Abstract Class and Interface?* An abstract class can have instance variables and constructors. An interface cannot have constructors and only allows `public static final` variables.

### 1.3 Inheritance
- **Definition:** Mechanism where one class acquires the properties (methods and fields) of another.
- **Types:** Single, Multilevel, Hierarchical. **Note:** Java *does not* support Multiple Inheritance through classes to avoid the "Diamond Problem" (ambiguity), but supports it through interfaces.
- **Keyword:** `extends`, `implements`.

### 1.4 Polymorphism
- **Definition:** Ability to take many forms. Allows performing a single action in different ways.
- **Compile-time (Static):** Method Overloading (same method name, different parameters).
- **Run-time (Dynamic):** Method Overriding (subclass provides a specific implementation of a method declared in the parent class using `@Override`).

---

## 2. String Mastery in Java

Strings are heavily tested in GenC Next coding assessments. 

### 2.1 String Immutability
- **Concept:** `String` objects are immutable. Once created, their value cannot be changed. Any modification (like `.concat()`) creates a brand new `String` object in the String Constant Pool (SCP) or Heap.
- **Why Immutable?** Security, Synchronization (Thread-safety), and Memory efficiency (Caching in SCP).

### 2.2 `String` vs `StringBuilder` vs `StringBuffer`
| Feature | `String` | `StringBuilder` | `StringBuffer` |
|---------|----------|-----------------|----------------|
| **Mutability** | Immutable | Mutable | Mutable |
| **Thread-Safety** | Yes (because immutable) | No (not synchronized) | Yes (methods are `synchronized`) |
| **Performance** | Slow (due to object creation) | Fast | Slower than Builder, faster than String |

### 2.3 Must-Know String Methods for DSA
```java
String s = "Cognizant GenC";
int len = s.length();                 // 14
char c = s.charAt(0);                 // 'C'
String sub = s.substring(10, 14);     // "GenC"
boolean contains = s.contains("Gen"); // true
String[] arr = s.split(" ");          // ["Cognizant", "GenC"]
char[] chars = s.toCharArray();       // ['C','o',...]
String replaced = s.replace("C", "K");// "Kognizant GenK"
```

---

## 3. Top Java Tricky Interview Questions

### Q1: Can we override a `static` method?
**Answer:** No. Static methods are bound to the class, not the object (Compile-time binding). If a subclass defines a static method with the same signature, it *hides* the superclass method, which is known as **Method Hiding**, not overriding.

### Q2: What happens if a `String` is created using the `new` keyword?
**Answer:** `String s = new String("Java");` creates *two* objects (if "Java" doesn't already exist in the SCP). One in the Heap memory (pointed to by `s`), and one literal in the String Constant Pool.

### Q3: Why is multiple inheritance not supported in Java classes?
**Answer:** To prevent the **Diamond Problem**. If Class C extends Class A and Class B, and both A and B have a method `display()`, the compiler will not know which `display()` method to execute when called via Class C. Java avoids this ambiguity entirely.
