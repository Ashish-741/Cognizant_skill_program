-- ============================================================================
-- PL/SQL: Data Manipulation Language (DML)
-- Description: Scripts for inserting sample data into tables.
-- ============================================================================

-- Inserting into Departments
INSERT INTO departments (dept_id, dept_name, location) VALUES (10, 'IT & Engineering', 'Bangalore');
INSERT INTO departments (dept_id, dept_name, location) VALUES (20, 'Digital Experience', 'Chennai');
INSERT INTO departments (dept_id, dept_name, location) VALUES (30, 'Data & Analytics', 'Hyderabad');
INSERT INTO departments (dept_id, dept_name, location) VALUES (40, 'Human Resources', 'Pune');

-- Inserting into Employees
INSERT INTO employees (emp_id, first_name, last_name, email, hire_date, salary, dept_id)
VALUES (101, 'Ashish', 'Kumar', 'ashish.k@cognizant.com', TO_DATE('15-01-2024', 'DD-MM-YYYY'), 675000, 10);

INSERT INTO employees (emp_id, first_name, last_name, email, hire_date, salary, dept_id)
VALUES (102, 'Rahul', 'Sharma', 'rahul.sharma@cognizant.com', TO_DATE('10-02-2024', 'DD-MM-YYYY'), 650000, 10);

INSERT INTO employees (emp_id, first_name, last_name, email, hire_date, salary, dept_id)
VALUES (103, 'Priya', 'Verma', 'priya.v@cognizant.com', TO_DATE('01-03-2024', 'DD-MM-YYYY'), 700000, 20);

INSERT INTO employees (emp_id, first_name, last_name, email, hire_date, salary, dept_id)
VALUES (104, 'Amit', 'Patel', 'amit.p@cognizant.com', TO_DATE('20-03-2024', 'DD-MM-YYYY'), 680000, 20);

INSERT INTO employees (emp_id, first_name, last_name, email, hire_date, salary, dept_id)
VALUES (105, 'Sneha', 'Nair', 'sneha.n@cognizant.com', TO_DATE('12-04-2024', 'DD-MM-YYYY'), 720000, 30);

INSERT INTO employees (emp_id, first_name, last_name, email, hire_date, salary, dept_id)
VALUES (106, 'Vikram', 'Singh', 'vikram.s@cognizant.com', TO_DATE('05-05-2024', 'DD-MM-YYYY'), 500000, 40);

COMMIT;
