-- =========================================================================
-- PL/SQL Module: Packages (Specification and Body)
-- Purpose: Groups logically related functions, procedures, and variables
-- =========================================================================

-- 1. Package Specification (The interface)
CREATE OR REPLACE PACKAGE Employee_Mgmt_Pkg IS
    -- Public variable
    g_company_name VARCHAR2(100) := 'Cognizant Technology Solutions';
    
    -- Public Procedures and Functions declarations
    PROCEDURE give_department_raise(p_dept_id IN NUMBER, p_percentage IN NUMBER);
    FUNCTION get_total_dept_salary(p_dept_id IN NUMBER) RETURN NUMBER;
END Employee_Mgmt_Pkg;
/

-- 2. Package Body (The implementation)
CREATE OR REPLACE PACKAGE BODY Employee_Mgmt_Pkg IS

    -- Private function (not declared in spec, only accessible within the body)
    FUNCTION validate_percentage(p_percent IN NUMBER) RETURN BOOLEAN IS
    BEGIN
        IF p_percent < 0 OR p_percent > 50 THEN
            RETURN FALSE;
        ELSE
            RETURN TRUE;
        END IF;
    END validate_percentage;

    -- Implementation of public procedure
    PROCEDURE give_department_raise(p_dept_id IN NUMBER, p_percentage IN NUMBER) IS
    BEGIN
        IF validate_percentage(p_percentage) THEN
            UPDATE employees
            SET salary = salary + (salary * (p_percentage / 100))
            WHERE department_id = p_dept_id;
            
            DBMS_OUTPUT.PUT_LINE('Raise of ' || p_percentage || '% applied to department ' || p_dept_id);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Error: Invalid percentage value. Must be between 0 and 50.');
        END IF;
    END give_department_raise;

    -- Implementation of public function
    FUNCTION get_total_dept_salary(p_dept_id IN NUMBER) RETURN NUMBER IS
        v_total_salary NUMBER;
    BEGIN
        SELECT SUM(salary) INTO v_total_salary
        FROM employees
        WHERE department_id = p_dept_id;
        
        RETURN NVL(v_total_salary, 0);
    END get_total_dept_salary;

END Employee_Mgmt_Pkg;
/

-- =========================================================================
-- Execution Example
-- =========================================================================
SET SERVEROUTPUT ON;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Company: ' || Employee_Mgmt_Pkg.g_company_name);
    
    -- Call Package Procedure
    Employee_Mgmt_Pkg.give_department_raise(10, 10);
    
    -- Call Package Function
    DBMS_OUTPUT.PUT_LINE('Total Dept 10 Salary: ' || Employee_Mgmt_Pkg.get_total_dept_salary(10));
    
    ROLLBACK;
END;
/
