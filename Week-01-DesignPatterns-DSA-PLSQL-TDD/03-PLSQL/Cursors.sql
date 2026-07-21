-- =========================================================================
-- PL/SQL Module: Cursors (Implicit and Explicit)
-- Purpose: Demonstrates how to handle multi-row queries row-by-row
-- =========================================================================

SET SERVEROUTPUT ON;

-- 1. Explicit Cursor (Iterating through multiple rows)
DECLARE
    -- Cursor Declaration
    CURSOR c_employee_cursor IS 
        SELECT employee_id, first_name, salary 
        FROM employees 
        WHERE department_id = 10;
        
    -- Variables to hold cursor data
    v_emp_id employees.employee_id%TYPE;
    v_emp_name employees.first_name%TYPE;
    v_emp_salary employees.salary%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Explicit Cursor Processing ---');
    
    -- Open the cursor
    OPEN c_employee_cursor;
    
    LOOP
        -- Fetch row into variables
        FETCH c_employee_cursor INTO v_emp_id, v_emp_name, v_emp_salary;
        
        -- Exit condition checking cursor attribute
        EXIT WHEN c_employee_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('ID: ' || v_emp_id || ' | Name: ' || v_emp_name || ' | Salary: ' || v_emp_salary);
    END LOOP;
    
    -- Close the cursor
    CLOSE c_employee_cursor;
END;
/

-- 2. Cursor FOR Loop (Simplified explicit cursor, handles open/fetch/close automatically)
DECLARE
    CURSOR c_high_earners IS 
        SELECT first_name, salary 
        FROM employees 
        WHERE salary > 10000;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Cursor FOR Loop Processing ---');
    
    FOR emp_rec IN c_high_earners LOOP
        DBMS_OUTPUT.PUT_LINE('High Earner: ' || emp_rec.first_name || ' earning ' || emp_rec.salary);
    END LOOP;
END;
/

-- 3. Implicit Cursor Attributes (SQL%ROWCOUNT, SQL%FOUND)
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Implicit Cursor Attributes ---');
    
    UPDATE employees 
    SET salary = salary * 1.05 
    WHERE department_id = 20;
    
    IF SQL%FOUND THEN
        DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employees received a 5% raise.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('No employees found in Department 20.');
    END IF;
    
    -- Rollback to keep database state clean
    ROLLBACK;
END;
/
