# Employee JDBC Project & Java 21 Architecture

## What is JDBC with DAO & Factory Pattern?
**Java Database Connectivity (JDBC)** is the Java API that manages connecting to relational databases (like MySQL or Oracle), issuing queries, and handling result sets. To build clean, maintainable enterprise applications, JDBC is combined with three classic structural patterns:
1. **DAO (Data Access Object) Pattern:** Abstracts and encapsulates all database access calls behind an interface (`EmployeeDao`), decoupling business logic from SQL dialect specifics.
2. **Factory Pattern:** Abstracts the creation of DAO instances (`EmployeeDaoFactory`) and database connections (`ConnectionFactory`), allowing seamless switching of implementations.
3. **Singleton Pattern:** Ensures only one shared connection manager or DAO instance exists in memory, optimizing resource usage.

---

## Why Use ResourceBundle?
Instead of hardcoding database passwords and URLs directly in Java source code, properties are stored in `src/main/resources/dbConfig.properties`. **`ResourceBundle`** loads these key-value pairs cleanly at runtime, enabling:
- **Environment Separation:** Easily switch between Development, Staging, and Production database configurations without recompiling code.
- **Security:** Keeps sensitive credentials out of source classes.

---

## Key Java 21 Features Utilized
1. **String Templates (`STR."..."`):** Allows safe, readable string interpolation without string concatenation boilerplate (`STR."Employee added successfully [ID: \{id}]"`).
2. **Switch Expressions with Yield:** Enhanced `switch` statements that return values and use `yield` inside block arms for concise conditional execution in menu navigation.
3. **Pattern Matching & Optional API:** Employs modern `Optional.ifPresentOrElse()` and `var` local variable type inference for clean, defensive data mapping.
4. **Text Blocks (`"""..."""`):** For clean multi-line UI banners without escape characters.

---

## Real World Example
- **Cognizant Enterprise Data Pipelines:** In legacy banking or high-throughput batch processing apps where full ORMs like Hibernate introduce too much memory overhead, custom JDBC connection pooling with DAO abstraction is used to execute millions of prepared statements per minute with microsecond precision.

---

## Top Interview Questions

### Q1: Why should you always use `PreparedStatement` instead of regular `Statement` in JDBC?
**Answer:**
1. **SQL Injection Prevention:** `PreparedStatement` automatically sanitizes and escapes parameter values passed via `.setString()` and `.setInt()`, preventing malicious SQL injection attacks.
2. **Pre-compilation Performance:** The database parses, compiles, and caches the execution plan of a `PreparedStatement` once. Subsequent executions reuse the compiled plan, significantly boosting throughput.

### Q2: How does `try-with-resources` prevent database connection leaks?
**Answer:** Prior to Java 7, developers had to manually write verbose `finally` blocks to close `Connection`, `PreparedStatement`, and `ResultSet` objects. If an exception occurred during closing, connections leaked, eventually exhausting the database connection pool. **Try-with-resources** (`try (Connection c = ...)`) automatically calls `.close()` on any resource implementing `AutoCloseable` at the end of the block, even if an exception is thrown.
