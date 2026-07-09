package week3.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import week3.jpa.model.EmployeeEntity;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface extending JpaRepository to inherit complete CRUD and pagination operations.
 * Demonstrates Derived Query Methods, custom JPQL queries, and Pageable support.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    // 1. Derived Query Methods (Spring automatically translates method names to SQL)
    List<EmployeeEntity> findByDepartment(String department);

    List<EmployeeEntity> findBySalaryGreaterThanEqual(Double minSalary);

    List<EmployeeEntity> findByDepartmentAndSalaryGreaterThan(String department, Double minSalary);

    // 2. Custom JPQL Query using @Query annotation
    @Query("SELECT e FROM EmployeeEntity e WHERE e.email = :email")
    Optional<EmployeeEntity> findEmployeeByEmail(@Param("email") String email);

    // 3. Custom Native SQL Query
    @Query(value = "SELECT * FROM employees WHERE department_code = :dept ORDER BY annual_salary DESC", nativeQuery = true)
    List<EmployeeEntity> findTopEarnersByDepartmentNative(@Param("dept") String department);

    // 4. Pagination and Sorting Support
    Page<EmployeeEntity> findByDepartment(String department, Pageable pageable);
}
