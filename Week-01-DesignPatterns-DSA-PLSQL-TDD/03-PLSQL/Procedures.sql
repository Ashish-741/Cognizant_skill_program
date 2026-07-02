-- ============================================================================
-- PL/SQL: Stored Procedures
-- Description: Scripts for defining and executing PL/SQL stored procedures.
-- ============================================================================

-- Stored Procedure to update salaries for a specific department by a percentage hike
CREATE OR REPLACE PROCEDURE give_department_hike(
    p_dept_id IN NUMBER,
    p_hike_percent IN NUMBER,
    p_rows_updated OUT NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_hike_percent / 100)
    WHERE dept_id = p_dept_id;
    
    p_rows_updated := SQL%ROWCOUNT;
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Successfully applied ' || p_hike_percent || '% hike to Department ID ' || p_dept_id);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
END give_department_hike;
/

-- Test execution of the procedure
SET SERVEROUTPUT ON;
DECLARE
    v_count NUMBER;
BEGIN
    give_department_hike(10, 8.5, v_count);
    DBMS_OUTPUT.PUT_LINE('Total employees updated: ' || v_count);
END;
/
