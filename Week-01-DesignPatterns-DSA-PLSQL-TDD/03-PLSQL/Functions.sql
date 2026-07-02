-- ============================================================================
-- PL/SQL: User-Defined Functions
-- Description: Scripts for defining and executing PL/SQL functions.
-- ============================================================================

-- Function to calculate annual compensation including performance bonus
CREATE OR REPLACE FUNCTION get_annual_compensation(p_emp_id IN NUMBER, p_bonus_percentage IN NUMBER DEFAULT 10) 
RETURN NUMBER IS
    v_salary employees.salary%TYPE;
    v_total_comp NUMBER(12, 2);
BEGIN
    SELECT salary INTO v_salary 
    FROM employees 
    WHERE emp_id = p_emp_id;

    v_total_comp := v_salary + (v_salary * p_bonus_percentage / 100);
    RETURN v_total_comp;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee ID ' || p_emp_id || ' not found.');
        RETURN 0;
    WHEN OTHERS THEN
        RETURN -1;
END get_annual_compensation;
/

-- Test execution of the function
SET SERVEROUTPUT ON;
DECLARE
    v_annual_pay NUMBER;
BEGIN
    v_annual_pay := get_annual_compensation(101, 15);
    DBMS_OUTPUT.PUT_LINE('Total Annual Compensation for Emp 101: ₹' || v_annual_pay);
END;
/
