-- ============================================================================
-- PL/SQL: Data Definition Language (DDL)
-- Description: Scripts for creating database tables, constraints, and sequences.
-- ============================================================================

-- Drop tables if they already exist (clean setup)
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE employee_audit_log CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE employees CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE departments CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/

-- Create Departments Table
CREATE TABLE departments (
    dept_id NUMBER(4) PRIMARY KEY,
    dept_name VARCHAR2(50) NOT NULL,
    location VARCHAR2(50)
);

-- Create Employees Table
CREATE TABLE employees (
    emp_id NUMBER(6) PRIMARY KEY,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    email VARCHAR2(100) UNIQUE NOT NULL,
    hire_date DATE DEFAULT SYSDATE,
    salary NUMBER(10, 2) CHECK (salary > 0),
    dept_id NUMBER(4),
    CONSTRAINT fk_dept FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

-- Create Audit Log Table for Trigger demonstration
CREATE TABLE employee_audit_log (
    log_id NUMBER(10) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    emp_id NUMBER(6),
    old_salary NUMBER(10, 2),
    new_salary NUMBER(10, 2),
    change_date TIMESTAMP DEFAULT SYSTIMESTAMP,
    changed_by VARCHAR2(50)
);

COMMIT;
