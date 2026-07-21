-- =========================================================================
-- PL/SQL Module: Control Structures (Loops/If-Else) & Exception Handling
-- Purpose: Demonstrates Decision Making, Iterative Controls, and Error Handling
-- =========================================================================

-- 1. Decision Making & Loops (Control Structures)
SET SERVEROUTPUT ON;

DECLARE
    v_counter NUMBER := 1;
    v_total_salary NUMBER := 0;
    v_bonus_percentage NUMBER;
    v_department_id NUMBER := 10;
BEGIN
    -- Basic IF-ELSIF-ELSE Statement
    IF v_department_id = 10 THEN
        v_bonus_percentage := 0.15;
        DBMS_OUTPUT.PUT_LINE('IT Department Bonus Applied: 15%');
    ELSIF v_department_id = 20 THEN
        v_bonus_percentage := 0.10;
        DBMS_OUTPUT.PUT_LINE('HR Department Bonus Applied: 10%');
    ELSE
        v_bonus_percentage := 0.05;
        DBMS_OUTPUT.PUT_LINE('Standard Bonus Applied: 5%');
    END IF;

    -- Basic LOOP (Exit condition)
    DBMS_OUTPUT.PUT_LINE('--- Basic Loop ---');
    LOOP
        DBMS_OUTPUT.PUT_LINE('Iteration: ' || v_counter);
        v_counter := v_counter + 1;
        EXIT WHEN v_counter > 3;
    END LOOP;

    -- FOR Loop
    DBMS_OUTPUT.PUT_LINE('--- FOR Loop ---');
    FOR i IN 1..3 LOOP
        DBMS_OUTPUT.PUT_LINE('FOR Loop Iteration: ' || i);
    END LOOP;

    -- WHILE Loop
    DBMS_OUTPUT.PUT_LINE('--- WHILE Loop ---');
    v_counter := 1;
    WHILE v_counter <= 3 LOOP
        DBMS_OUTPUT.PUT_LINE('WHILE Loop Iteration: ' || v_counter);
        v_counter := v_counter + 1;
    END LOOP;
END;
/

-- 2. Exception Handling (Pre-defined and User-defined)
DECLARE
    v_employee_name VARCHAR2(100);
    v_employee_salary NUMBER;
    
    -- User-defined exception
    ex_salary_too_high EXCEPTION;
    PRAGMA EXCEPTION_INIT(ex_salary_too_high, -20001);
BEGIN
    -- Simulating a NO_DATA_FOUND exception
    BEGIN
        SELECT first_name INTO v_employee_name FROM employees WHERE employee_id = 99999;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID 99999 does not exist (NO_DATA_FOUND).');
    END;

    -- Simulating a user-defined exception
    v_employee_salary := 1500000;
    IF v_employee_salary > 1000000 THEN
        RAISE ex_salary_too_high;
    END IF;

EXCEPTION
    WHEN ex_salary_too_high THEN
        DBMS_OUTPUT.PUT_LINE('Business Error: Salary exceeds the maximum permitted threshold.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END;
/
