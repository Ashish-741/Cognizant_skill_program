# Week 3: Spring Data JPA, Hibernate ORM, Entity Mapping & REST Exception Handling

## Topics Covered

- Spring Data JPA & Hibernate ORM Architecture
- JPA Entity Lifecycle & Persistence Context (`EntityManager`)
- Repository Layer (`JpaRepository`, Derived Query Methods, `@Query` JPQL/Native SQL, Pagination & Sorting)
- Entity Relationship Mapping (`@OneToMany`, `@ManyToOne`, `@ManyToMany`, Cascade Types, Fetch Types)
- Declarative Transaction Management (`@Transactional`, Propagation Levels, Isolation Levels, Rollback Rules)
- REST API Validation using Jakarta Validation (`@Valid`, `@NotNull`, `@NotBlank`, `@Email`, `@Min`, `@Size`)
- Centralized Exception Handling (`@RestControllerAdvice`, `@ExceptionHandler`, Standardized Error Response DTOs)

---

## Folder Structure

```text
01-SpringDataJPA-Hibernate
02-EntityMapping-Transactions
03-ExceptionHandling-Validation
04-Hibernate-HQL
Assignments
Screenshots
```

---

## Learning Outcomes

- Learned the difference between JPA specification and Hibernate ORM implementation.
- Implemented clean repository layers using Spring Data JPA without writing boilerplate DAO code.
- Solved real-world database relationship problems using proper JPA annotations and avoided the N+1 Select issue.
- Configured declarative database transactions ensuring ACID compliance across multi-table updates.
- Built enterprise-grade error handling and request payload validation for REST endpoints using `@RestControllerAdvice`.

---

## Status

✅ Completed
