# PL/SQL Programming Architecture & Theory

## What is PL/SQL?
**PL/SQL (Procedural Language extensions to SQL)** is Oracle's procedural extension to structured query language. It combines the data manipulation power of SQL with the processing power of procedural programming languages (loops, conditions, variables, exceptions).

---

## Key Components

### 1. DDL & DML (Data Definition & Manipulation)
- **DDL (`CREATE`, `ALTER`, `DROP`, `TRUNCATE`):** Defines database schema and table constraints.
- **DML (`INSERT`, `UPDATE`, `DELETE`, `MERGE`):** Manipulates persistent data rows within tables.

### 2. Stored Procedures & Functions
- **Procedures:** Named PL/SQL blocks stored in the database designed to perform complex business workflows (e.g., applying annual salary hikes across departments).
- **Functions:** Named blocks that compute and return a single derived value (e.g., calculating annual compensation with tax deductions).

### 3. Cursors (Implicit & Explicit)
- **Implicit Cursors:** Automatically created by Oracle for single-row queries (`SELECT INTO`) or DML operations. Evaluated using attributes like `SQL%FOUND` or `SQL%ROWCOUNT`.
- **Explicit Cursors:** User-defined structures used to iterate through multiple rows returned by a query, row-by-row (`OPEN`, `FETCH`, `CLOSE`).

### 4. Packages
- A schema object that groups logically related PL/SQL types, variables, and subprograms (Procedures/Functions). It has two parts:
  - **Specification:** The public interface declaring available methods.
  - **Body:** The hidden implementation and private methods.

### 5. Database Triggers
- Automated PL/SQL blocks that execute implicitly whenever a DML event occurs on a table (`BEFORE INSERT/UPDATE/DELETE` or `AFTER`).

---

## Advantages of PL/SQL
- **High Performance:** Sends entire blocks of SQL statements to the database server at once, drastically reducing network traffic between application servers and the database.
- **Centralized Business Logic:** Core rules (like auditing or salary validation) enforced directly at the database layer apply universally across all web, mobile, and desktop clients.
- **Exception Handling:** Robust `EXCEPTION` blocks catch database errors gracefully without crashing the client application.

---

## Disadvantages
- **Vendor Lock-In:** PL/SQL is proprietary to Oracle. Migrating stored procedures and triggers to MySQL, PostgreSQL, or SQL Server requires complete manual rewrite.
- **CPU Resource Heavy:** Executing intense procedural loops inside the database engine consumes expensive database server memory and CPU, which can bottleneck concurrent user queries.
- **Harder Version Control & CI/CD:** Database code stored in Oracle schemas is harder to unit test, debug, and version control compared to stateless Java backend services.

---

## Real World Example
- **Banking Fraud Audit Trail:** When a customer attempts to transfer funds, a `BEFORE UPDATE` row trigger checks if the withdrawal amount exceeds account balance. An `AFTER UPDATE` trigger automatically records the transaction timestamp, old balance, new balance, and IP address into an immutable `audit_log` table.

---

## Interview Questions

### Q1: What is the difference between `%TYPE` and `%ROWTYPE` in PL/SQL?
**Answer:** 
- `%TYPE`: Declares a variable with the exact same data type as a single database table column (e.g., `v_emp_id employees.emp_id%TYPE;`). Prevents type mismatch errors if the column size changes later.
- `%ROWTYPE`: Declares a record variable representing an entire row of a table or cursor (e.g., `v_emp_row employees%ROWTYPE;`). You can access fields using `v_emp_row.first_name`.

### Q2: Why should you avoid mutating table errors in PL/SQL triggers?
**Answer:** A **Mutating Table Error (`ORA-04091`)** occurs when a row-level trigger attempts to query or modify the exact same table that triggered it while the DML operation is still in progress. Oracle locks the table during DML to maintain read consistency. *Fix:* Use a statement-level trigger, temporary tables, or compound triggers in modern Oracle DBs.
