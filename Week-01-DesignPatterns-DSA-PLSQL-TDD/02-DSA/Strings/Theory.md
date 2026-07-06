# Strings Data Structure

## What is a String?
A **String** is an immutable sequence of characters stored in memory. In Java, Strings are treated as first-class objects rather than primitive character arrays and are backed by an internal character array (or byte array with coder flag in Java 9+ Compact Strings).

---

## Advantages
- **Immutability & Thread Safety:** Because Java Strings cannot be modified after creation, they are inherently thread-safe and can be shared across threads without synchronization overhead.
- **String Pool Optimization:** The JVM maintains a special memory region called the **String Constant Pool** in Heap memory. Identical string literals reuse the exact same memory reference, drastically reducing RAM usage.
- **Security:** Used heavily for storing sensitive parameters (database URLs, usernames, file paths). Immutability prevents malicious code from altering values during network execution.

---

## Disadvantages
- **Memory Overhead on Heavy Modification:** Repeatedly concatenating strings using `+` in a loop creates a new String object in Heap memory on every iteration, leading to rapid garbage collection spikes.
- **Sensitive Data Persistence:** Since Strings are immutable, sensitive passwords cannot be erased or cleared from memory manually; they remain until the Garbage Collector cleans them up.

---

## Real World Example
- **Data Serialization & Parsing:** JSON, XML, and HTTP request headers are transmitted over networks as continuous string streams that must be parsed, validated, and tokenized by backend APIs.
- **Text Search Engines:** Algorithms like Knuth-Morris-Pratt (KMP) or Rabin-Karp perform pattern matching across massive text corpora (e.g., searching logs or biomedical DNA sequences).

---

## Interview Questions

### Q1: Why is String immutable in Java?
**Answer:** 
1. **String Pool:** Without immutability, changing a literal string reference would corrupt all other variables pointing to that same pooled literal.
2. **Caching HashCode:** Because Strings never change, their `hashCode()` is calculated once and cached in an internal field, making them extremely fast as `HashMap` keys.
3. **Security:** Prevents tampering with network connections, file access paths, and SQL query strings after validation.

### Q2: What is the difference between `String`, `StringBuilder`, and `StringBuffer`?
| Feature | `String` | `StringBuilder` | `StringBuffer` |
| :--- | :--- | :--- | :--- |
| **Mutability** | Immutable | Mutable | Mutable |
| **Thread Safety** | Thread-Safe | **Not Thread-Safe** (No sync) | **Thread-Safe** (Synchronized methods) |
| **Performance** | Slowest for edits | **Fastest** for edits | Moderate (due to lock overhead) |
| **Best Used When** | Values don't change | Single-threaded string manipulation | Multi-threaded string manipulation |
