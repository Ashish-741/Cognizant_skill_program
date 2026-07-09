# Hibernate & JPA Annotations by Categories — Definitive Reference Guide

This document organizes standard JPA and Hibernate-specific annotations into **8 practical categories** with complete code examples, including the bidirectional `@OneToOne` entity mapping pattern.

---

## 1. Core Entity Annotations
- **`@Entity`**: Marks a Java class as a JPA entity managed by `EntityManager`.
- **`@Table`**: Specifies database table name, schema, and indexes.
- **`@Id`**: Marks the primary key attribute.
- **`@GeneratedValue`**: Configures primary key generation (`IDENTITY`, `SEQUENCE`, `AUTO`).

```java
@Entity
@Table(name = "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;
}
```

---

## 2. Column Mapping Annotations
- **`@Column`**: Customizes column name, nullable, uniqueness, length, precision, and scale.
- **`@Transient`**: Excludes field from database persistence.
- **`@Lob`**: Large object field mapping (`BLOB` for binary, `CLOB` for text).
- **`@Enumerated`**: Maps Java `enum` types (`EnumType.STRING` recommended).
- **`@CreationTimestamp` & `@UpdateTimestamp`** *(Hibernate specific)*: Auto-populates creation/update timestamps.

```java
@Column(name = "full_name", nullable = false, length = 100, unique = true)
private String name;

@Enumerated(EnumType.STRING)
private UserStatus status;

@CreationTimestamp
private LocalDateTime createdAt;
```

---

## 3. Relationship Annotations (with Proper `@OneToOne` Example)

### Proper `@OneToOne` Bidirectional Mapping Example (`User` <-> `UserProfile`)
```java
// Owning Side (owns profile_id foreign key)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private UserProfile profile;
}

// Inverse Side (mappedBy avoids duplicate FK column)
@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private User user;
}
```

### `@OneToMany`, `@ManyToOne` & `@ManyToMany`
```java
@Entity
public class Department {
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("createdAt DESC")
    private List<Employee> employees;
}
```

---

## 4. Fetching and Caching Annotations
- **`@Fetch`** *(Hibernate specific)*: Customizes fetching mode (`JOIN`, `SELECT`, `SUBSELECT`).
- **`@BatchSize`** *(Hibernate specific)*: Optimizes lazy collection fetching in batches to avoid N+1 queries.
- **`@Cache`** *(Hibernate specific)*: Enables second-level cache concurrency strategies (`READ_WRITE`, `NONSTRICT_READ_WRITE`).

---

## 5. Inheritance Annotations
- **`@Inheritance`**: Defines inheritance strategy (`SINGLE_TABLE`, `JOINED`, `TABLE_PER_CLASS`).
- **`@DiscriminatorColumn`**: Column distinguishing subclass types in a `SINGLE_TABLE` hierarchy.
- **`@MappedSuperclass`**: Base class whose properties are inherited by child table mappings without creating its own table.

```java
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
```

---

## 6. Validation Annotations (Jakarta Bean Validation)
- **`@NotBlank`**, **`@NotNull`**, **`@Size`**, **`@Email`**, **`@Min`**, **`@Max`**, **`@Pattern`**, **`@Future`**

---

## 7. Query Annotations
- **`@NamedQuery` & `@NamedQueries`**: Static pre-compiled JPQL queries registered at startup.
- **`@NamedNativeQuery`**: Pre-compiled database-specific SQL queries.

---

## 8. Other Useful Annotations (Hibernate Specific)
- **`@Formula`**: Computes derived property via SQL expression executed on every SELECT query.
- **`@Where`**: Automatically appends a SQL condition to entity or collection queries (essential for soft deletion).
- **`@SQLDelete`**: Overrides default `DELETE FROM` query with custom SQL (soft delete pattern).
- **`@DynamicInsert` / `@DynamicUpdate`**: Instructs Hibernate to generate SQL `INSERT`/`UPDATE` queries including only non-null or modified columns.
- **`@Immutable`**: Prevents updates to entities or database views.

```java
@Entity
@Table(name = "employees")
@DynamicUpdate
@SQLDelete(sql = "UPDATE employees SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Employee extends BaseEntity {
    @Formula("(SELECT COUNT(*) FROM projects p WHERE p.employee_id = id)")
    private Integer projectCount;
}
```
