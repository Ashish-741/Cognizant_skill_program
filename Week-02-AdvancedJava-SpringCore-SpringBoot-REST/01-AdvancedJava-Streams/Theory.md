# Advanced Java: Lambda Expressions, Stream API & Optional

## What are Lambda Expressions & Stream API?
- **Lambda Expressions:** Introduce functional programming syntax to Java 8+. They allow treating functionality as method arguments and implementing single-method interfaces (`@FunctionalInterface`) concisely without verbose anonymous inner classes.
- **Stream API (`java.util.stream`):** A powerful abstraction for processing sequences of elements (collections, arrays) declaratively. It supports functional-style pipeline operations like filtering, mapping, reducing, and grouping.
- **`Optional<T>`:** A container object used to contain not-null objects, designed to explicitly represent the presence or absence of a value and eradicate the dreaded `NullPointerException`.

---

## Advantages
- **Declarative Code:** Tells the computer *what* to do (e.g., `.filter(salary > 700k)`) rather than writing imperative loops telling it *how* to iterate.
- **Parallel Processing:** Converting a standard stream to a parallel stream (`roster.parallelStream()`) allows multi-core CPUs to process collection subsets concurrently without writing manual `Thread` or `synchronized` code.
- **Null Safety:** `Optional` forces API consumers to explicitly handle missing values at compile time using `.orElse()`, `.orElseThrow()`, or `.ifPresent()`.

---

## Disadvantages
- **Debugging Difficulty:** Stepping through chained stream pipelines in IDE debuggers is much harder than debugging traditional `for` loops.
- **Performance Overhead on Small Collections:** For tiny lists (< 50 items), setting up stream pipelines and functional lambdas incurs slight object allocation overhead compared to simple indexed array loops.
- **Single-Use Limitation:** Once a Stream terminal operation (`collect`, `forEach`, `sum`) is executed, the stream is considered **consumed** and cannot be reused.

---

## Real World Example
- **Financial Transaction Filtering:** In Cognizant banking microservices, when processing thousands of daily credit card transactions, Java Streams filter out failed transactions, map currencies to USD, sort by timestamp, and group by merchant category in just 4 declarative lines of code.

---

## Interview Questions

### Q1: What is the difference between Intermediate and Terminal operations in Java Streams?
**Answer:**
- **Intermediate Operations (`filter`, `map`, `sorted`, `distinct`):** Transform a stream into another stream. They are **lazy**; they do not execute immediately when called. They merely build an execution pipeline.
- **Terminal Operations (`collect`, `forEach`, `reduce`, `count`, `findFirst`):** Trigger the actual execution of the entire stream pipeline and produce a final non-stream result or side-effect. After a terminal operation runs, the stream is closed.

### Q2: Why shouldn't you use `Optional.get()` directly without checking?
**Answer:** Calling `optional.get()` directly on an empty `Optional` throws a **`NoSuchElementException`**, which is just as bad as a `NullPointerException`! You should always check `optional.isPresent()` first, or prefer modern functional methods like `optional.orElse(defaultValue)`, `optional.orElseGet(supplier)`, or `optional.ifPresent(consumer)`.
