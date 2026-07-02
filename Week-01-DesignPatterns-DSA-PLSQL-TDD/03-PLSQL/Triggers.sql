-- ============================================================================
-- PL/SQL: Database Triggers
-- Description: Scripts for defining row-level and statement-level triggers.
-- ============================================================================

-- Row-level trigger to record salary modifications in the audit log
CREATE OR REPLACE TRIGGER trg_salary_audit
AFTER UPDATE OF salary ON employees
FOR EACH ROW
WHEN (NEW.salary != OLD.salary)
DECLARE
    v_user VARCHAR2(50);
BEGIN
    SELECT USER INTO v_user FROM DUAL;
    
    INSERT INTO employee_audit_log (emp_id, old_salary, new_salary, changed_by)
    VALUES (:OLD.emp_id, :OLD.salary, :NEW.salary, v_user);
    
    DBMS_OUTPUT.PUT_LINE('Audit Log: Salary changed for Emp ID ' || :OLD.emp_id || 
                         ' from ₹' || :OLD.salary || ' to ₹' || :NEW.salary);
END;
/

-- Test trigger by updating an employee's salary
UPDATE employees SET salary = 700000 WHERE emp_id = 101;
COMMIT;

-- Verify audit log table
SELECT * FROM employee_audit_log;
