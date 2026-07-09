# Spring Data JPA & Hibernate ORM

## What is JPA vs. Hibernate?
- **JPA (Jakarta Persistence API / Java Persistence API):** It is a **specification** (standard interface rules) defining how Java objects should be mapped to relational database tables. JPA itself does not perform any actual database operations.
- **Hibernate:** It is the most popular **ORM (Object-Relational Mapping) framework implementation** of the JPA specification. Hibernate implements the persistence logic, caching, dirty checking, and SQL generation.
- **Spring Data JPA:** An abstraction layer built on top of JPA/Hibernate that eliminates almost all boilerplate repository/DAO implementation code by generating runtime proxy repositories automatically.

---

## Repository Hierarchy in Spring Data JPA
```text
org.springframework.data.repository.Repository<T, ID>
        │
        ▼
org.springframework.data.repository.CrudRepository<T, ID>   (Provides basic save, findById, findAll, delete)
        │
        ▼
org.springframework.data.repository.PagingAndSortingRepository<T, ID>   (Adds Pageable & Sort support)
        │
        ▼
org.springframework.data.jpa.repository.JpaRepository<T, ID>   (Adds JPA-specific flush, batch delete, and query features)
```

---

## Advantages
- **Zero Boilerplate DAO Code:** Developers only define repository interfaces; Spring automatically generates the underlying proxy class at boot time.
- **Database Portability:** Switching from MySQL to PostgreSQL or Oracle only requires changing the JDBC driver and `spring.jpa.database-platform` dialect property.
- **First-Level & Second-Level Caching:** Hibernate automatically caches entities inside the `EntityManager` session (1st-level cache), drastically reducing repetitive database SELECT queries.

---

## Disadvantages
- **N+1 Select Problem:** Improper use of lazy loading or fetching relationships without explicit `JOIN FETCH` can result in executing $N+1$ SQL queries for a single list operation.
- **Performance Overhead:** For massive batch data insertions (e.g., inserting 500,000 records simultaneously), plain JDBC `PreparedStatement` batching outperforms standard ORM tracking.

---

## Real World Example
- **Cognizant Cloud Microservices:** When building high-traffic enterprise microservices, engineers extend `JpaRepository<EmployeeEntity, Long>` to handle 90% of routine CRUD operations and pagination (`PageRequest`), while using `@Query` JPQL for complex reporting queries.

---

## Top Interview Questions

### Q1: What is the difference between `save()` and `saveAndFlush()` in `JpaRepository`?
**Answer:**
- `save()`: Stores or merges the entity inside the Hibernate Persistence Context (`EntityManager`). The actual SQL `INSERT` or `UPDATE` query might be delayed until transaction commit time.
- `saveAndFlush()`: Immediately forces Hibernate to execute the SQL query against the database inside the current transaction block.

### Q2: How does Spring Data JPA translate method names into SQL queries?
**Answer:** Spring Data JPA uses a query builder mechanism that parses method name prefixes (`findBy`, `readBy`, `countBy`) and combines them with entity property names and keywords (`And`, `Or`, `GreaterThan`, `Like`, `OrderBy`). For example, `findByDepartmentAndSalaryGreaterThan(String dept, Double sal)` automatically compiles to:
`SELECT * FROM employees WHERE department_code = ? AND annual_salary > ?`
