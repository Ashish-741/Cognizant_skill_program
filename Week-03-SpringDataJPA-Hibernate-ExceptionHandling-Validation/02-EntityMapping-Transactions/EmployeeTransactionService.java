package week3.mapping.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import week3.mapping.model.Department;
import week3.mapping.model.EmployeeMapped;

/**
 * Service class demonstrating declarative transaction management with @Transactional.
 */
@Service
public class EmployeeTransactionService {

    /**
     * Demonstrates atomicity: If any runtime exception occurs inside this block,
     * all database inserts (Department and Employees) are rolled back.
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public Department createDepartmentWithEmployees(Department department, boolean simulateError) throws Exception {
        System.out.println("[TRANSACTION START] Persisting department: " + department.getName());

        // In a real Spring context, repository.save(department) would happen here
        if (simulateError) {
            System.err.println("[TRANSACTION ROLLBACK] Simulated failure triggered! Rolling back all inserts.");
            throw new Exception("Simulated database constraint violation!");
        }

        System.out.println("[TRANSACTION COMMIT] Department and employees successfully committed to database.");
        return department;
    }

    /**
     * Read-only transaction optimization.
     */
    @Transactional(readOnly = true)
    public void fetchDepartmentHierarchy(Long departmentId) {
        System.out.println("[READ-ONLY TX] Fetching department hierarchy for ID: " + departmentId);
    }
}
