# Top Interview Questions - Cognizant GenC Next / GenC Pro

This document compiles high-frequency technical interview questions and structured answers tailored for Cognizant's GenC Next and GenC Pro evaluations.

---

## 1. Object-Oriented Programming & Design Patterns

### Q1: What is the difference between a Factory Pattern and an Abstract Factory Pattern?
- **Factory Method Pattern:** Creates objects without exposing the instantiation logic to the client and refers to the newly created object through a common interface. It deals with a *single* product hierarchy.
- **Abstract Factory Pattern:** Provides an interface for creating *families* of related or dependent objects without specifying their concrete classes. It deals with *multiple* product hierarchies (e.g., UI components for Windows vs. MacOS).

### Q2: Why is double-checked locking used in the Singleton pattern?
In a multi-threaded environment, if two threads simultaneously check `if (instance == null)`, both might pass the condition and create two separate instances, violating the Singleton contract. **Double-checked locking** checks the null condition twice: once without synchronization (for high performance after initialization) and once inside a `synchronized` block (to ensure thread safety during initial creation). The `volatile` keyword is also required to prevent instruction reordering by the JVM.

### Q3: When should you prefer the Builder pattern over multiple constructors (Telescoping Constructor pattern)?
When a class has more than 4-5 attributes, many of which are optional. Telescoping constructors result in unreadable code (e.g., `new Computer("16GB", "512GB", null, true, false)`). The Builder pattern allows step-by-step readable construction with descriptive method names and immutable target objects.

---

## 2. Java 8+ & Stream API

### Q4: How does `HashMap` work internally in Java 8, and what is the significance of the threshold?
In Java 8, `HashMap` uses an array of buckets storing singly linked lists. When `put(k, v)` is called, the key's hash code is calculated to find the bucket index. If collision occurs, nodes are appended to the linked list. However, once the number of items in a single bucket reaches the **TREEIFY_THRESHOLD (default 8)** and array capacity is at least 64, the linked list is transformed into a **Red-Black Tree**, improving worst-case search time complexity from $O(N)$ to $O(\log N)$.

### Q5: What is the difference between `map()` and `flatMap()` in Java Streams?
- `map()`: Transforms each element of a stream into another object (1-to-1 mapping). Example: converting a list of words to their lengths.
- `flatMap()`: Transforms each element into a stream of objects and then flattens the multiple streams into a single stream (1-to-Many mapping). Example: flattening a `List<List<String>>` into a `List<String>`.

---

## 3. Database, SQL & PL/SQL

### Q6: What is the difference between a Stored Procedure and a User-Defined Function in PL/SQL?
| Feature | Stored Procedure | User-Defined Function |
| :--- | :--- | :--- |
| **Return Value** | May or may not return values (uses `OUT` parameters). | Must return exactly **one** value using the `RETURN` clause. |
| **SQL Usage** | Cannot be called directly inside a DML/DQL SELECT query. | Can be invoked directly within SQL SELECT/WHERE clauses. |
| **Transactions** | Can execute transaction statements (`COMMIT`, `ROLLBACK`). | Cannot execute transaction control statements if called inside SQL. |
| **Purpose** | Designed to perform actions and workflows. | Designed to compute and return a derived value. |

### Q7: What is the difference between ROW-LEVEL and STATEMENT-LEVEL triggers?
- **Row-Level Trigger:** Includes `FOR EACH ROW` clause. It fires once for every row affected by the DML statement. Allows access to `:OLD` and `:NEW` row qualifiers. Used for data auditing and row validation.
- **Statement-Level Trigger:** Fires exactly once per DML statement execution, regardless of how many rows are modified (even 0 rows). Cannot access `:OLD` and `:NEW` values. Used for security checks (e.g., restricting DML operations during weekends).

---

## 4. Test-Driven Development & Mockito

### Q8: What is the difference between `@Mock` and `@InjectMocks` in Mockito?
- `@Mock`: Creates a dummy mock object of an interface or class. Method calls on this object return default values (null, 0, false) unless explicitly stubbed using `when().thenReturn()`.
- `@InjectMocks`: Creates an instance of the *actual* class under test and automatically injects all fields annotated with `@Mock` into it.
