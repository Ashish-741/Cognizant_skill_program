-- ============================================================================
-- PL/SQL: Queries & Reports
-- Description: SQL queries, joins, aggregations, and analytical statements.
-- ============================================================================

-- 1. Display all employees along with their department name and location (INNER JOIN)
SELECT e.emp_id, e.first_name || ' ' || e.last_name AS full_name, e.salary, d.dept_name, d.location
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id
ORDER BY e.emp_id;

-- 2. Find total and average salary per department (GROUP BY)
SELECT d.dept_name, COUNT(e.emp_id) AS total_employees, 
       ROUND(AVG(e.salary), 2) AS avg_salary, MAX(e.salary) AS max_salary
FROM departments d
LEFT JOIN employees e ON d.dept_id = e.dept_id
GROUP BY d.dept_name
ORDER BY avg_salary DESC;

-- 3. Subquery: Find employees earning above the department average salary
SELECT emp_id, first_name, last_name, salary, dept_id
FROM employees e1
WHERE salary > (
    SELECT AVG(salary) 
    FROM employees e2 
    WHERE e1.dept_id = e2.dept_id
);

-- 4. Find the second highest salary among all employees using ROWNUM / subquery
SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);
