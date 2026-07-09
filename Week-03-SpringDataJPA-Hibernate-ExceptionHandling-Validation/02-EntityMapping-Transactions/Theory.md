# Entity Relationship Mapping & Declarative Transactions

## Entity Lifecycle States in JPA
1. **Transient:** Newly instantiated Java object (`new EmployeeMapped()`) not yet associated with any JPA `EntityManager` or database row.
2. **Persistent (Managed):** Entity is attached to the `EntityManager` session (e.g., after `repository.save()`). Any modifications made to managed entities are automatically tracked via **Dirty Checking** and synchronized with the database.
3. **Detached:** Entity was previously managed, but the `EntityManager` session has closed or cleared. Changes to detached objects are not saved unless explicitly merged.
4. **Removed:** Entity scheduled for deletion from the database row upon transaction commit.

---

## Relationship Mappings & Fetch Types
- **`@OneToMany` / `@ManyToOne`:** Parent-child association (e.g., `Department` has many `Employee`s). Best practice is **Bidirectional** mapping where `@ManyToOne` owns the foreign key and `@OneToMany` uses `mappedBy`.
- **`@ManyToMany`:** Requires a join table (`@JoinTable`) containing foreign keys linking both entities (e.g., `Employee` <-> `Project`).
- **FetchType.LAZY vs. EAGER:**
  - `LAZY` (Recommended default): Child associations are fetched from the database only when explicitly accessed via getter methods.
  - `EAGER`: Fetches all related child tables immediately via `LEFT OUTER JOIN` queries, which can cause severe memory issues.

---

## What is the N+1 Select Problem?
When loading a list of $N$ parent entities (e.g., 50 departments), Hibernate executes 1 SQL query to get all departments. If you iterate through the list and call `.getEmployees()` on each department under `LAZY` fetching, Hibernate issues $N$ additional SQL queries—resulting in $N+1$ total database hits.
- **Solution:** Use JPQL `JOIN FETCH d.employees` or Spring Data JPA `@EntityGraph`.

---

## Declarative Transactions (`@Transactional`)
The `@Transactional` annotation creates a Spring AOP proxy around service methods to manage ACID properties automatically.
- **Propagation.REQUIRED (Default):** Joins an existing transaction if open; otherwise creates a new transaction.
- **Propagation.REQUIRES_NEW:** Suspends any existing transaction and starts an independent new transaction block.
- **Rollback Rules:** By default, Spring rolls back transactions only on **Unchecked Exceptions** (`RuntimeException`). To roll back on checked exceptions, use `@Transactional(rollbackFor = Exception.class)`.
