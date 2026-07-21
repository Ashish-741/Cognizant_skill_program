# Spring JDBC Template vs Raw JDBC

## 1. What is `JdbcTemplate`?
`JdbcTemplate` is the central class in the Spring JDBC core package. It simplifies the use of JDBC and helps avoid common errors, such as forgetting to close database connections. It acts as a wrapper over the standard JDBC API.

## 2. Why use `JdbcTemplate` over Raw JDBC?

| Feature | Raw JDBC (`java.sql.*`) | Spring `JdbcTemplate` |
|---------|-------------------------|-----------------------|
| **Boilerplate Code** | High (Try-Catch-Finally, Opening/Closing connections) | Low (Spring handles connections automatically) |
| **Exception Handling** | Throws checked `SQLException` (Must be caught everywhere) | Translates to Spring's unchecked `DataAccessException` hierarchy |
| **Connection Leaks** | High risk if `close()` is forgotten in `finally` block | Zero risk, connection management is fully abstracted |
| **Object Mapping** | Manual `ResultSet` parsing row by row | Easy mapping using `RowMapper<T>` interface |

## 3. Top GenC Next Interview Questions

### Q1: What is a `RowMapper` in Spring JDBC?
**Answer:**
`RowMapper` is an interface used by `JdbcTemplate` for mapping rows of a `java.sql.ResultSet` on a per-row basis. You implement the `mapRow(ResultSet rs, int rowNum)` method to extract values from the ResultSet and return a populated Domain Object (like `Employee`). This avoids writing redundant extraction logic across multiple queries.

### Q2: Why does Spring convert checked `SQLException` to unchecked `DataAccessException`?
**Answer:**
In raw JDBC, `SQLException` is a checked exception, forcing the developer to write `try-catch` blocks everywhere, even when they cannot recover from the error (e.g., database is down). Spring converts this into `DataAccessException` (a `RuntimeException`), which bubbles up automatically, keeping the business logic clean and delegating error handling to global exception handlers (like `@RestControllerAdvice`). Furthermore, `DataAccessException` provides a rich hierarchy (e.g., `BadSqlGrammarException`, `DuplicateKeyException`) which is database-agnostic.
