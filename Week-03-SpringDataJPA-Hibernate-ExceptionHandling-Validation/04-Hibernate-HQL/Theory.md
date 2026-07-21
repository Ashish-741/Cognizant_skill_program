# Hibernate Query Language (HQL) & JPQL

## 1. What is HQL / JPQL?
**HQL (Hibernate Query Language)** and **JPQL (Java Persistence Query Language)** are object-oriented query languages. Instead of querying database tables and columns like standard SQL, you query **Entity Classes** and their **Attributes**.

Example:
- **SQL:** `SELECT * FROM tbl_employees WHERE emp_salary > 50000;`
- **HQL:** `SELECT e FROM Employee e WHERE e.salary > 50000;`

## 2. HQL vs Native SQL

| Feature | HQL / JPQL (`nativeQuery = false`) | Native SQL (`nativeQuery = true`) |
|---------|------------------------------------|-----------------------------------|
| **Paradigm** | Object-Oriented (Uses Java Classes/Fields) | Relational (Uses Tables/Columns) |
| **Portability**| **Database Agnostic.** Will run perfectly on MySQL, Oracle, or PostgreSQL without code changes. Hibernate translates it. | **Database Dependent.** May break if you switch from Oracle to MySQL due to specific syntax. |
| **Use Case** | 95% of standard complex queries (Joins, filtering). | 5% of queries requiring proprietary database functions (e.g., Oracle analytic functions, specific partitioning). |

## 3. Top GenC Next Interview Questions

### Q1: Can we perform UPDATE or DELETE operations using HQL `@Query`?
**Answer:**
Yes, but you must use the `@Modifying` annotation along with `@Query`. By default, `@Query` is only meant for `SELECT` statements. Furthermore, if you are calling a modifying query from a service layer, the method must be wrapped in a `@Transactional` annotation.
```java
@Modifying
@Transactional
@Query("UPDATE Employee e SET e.salary = e.salary + 5000 WHERE e.department = :dept")
int giveBonusToDepartment(@Param("dept") String department);
```

### Q2: What is the N+1 Select Problem in Hibernate?
**Answer:**
The N+1 problem occurs when Hibernate executes 1 query to fetch a list of parent entities (e.g., 10 Departments), and then executes N additional queries (10 queries) to fetch the lazily-loaded child entities for each parent (e.g., Employees in each department).
*Solution:* Use HQL with `JOIN FETCH` (e.g., `SELECT d FROM Department d JOIN FETCH d.employees`) to load everything in a single SQL query.
