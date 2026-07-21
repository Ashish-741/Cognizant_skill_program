package week3.hql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import week3.hql.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // 1. Spring Data JPA Derived Query (Magic Method)
    List<Employee> findByDepartment(String department);

    // 2. HQL / JPQL (Hibernate Query Language)
    // Uses entity class names and property names, NOT database table names.
    // This makes it database agnostic (works on MySQL, Oracle, Postgres without changes).
    @Query("SELECT e FROM Employee e WHERE e.salary > :minSalary")
    List<Employee> findHighEarnersHQL(@Param("minSalary") Double minSalary);

    // 3. Native SQL Query
    // Uses actual database table names and column names.
    // Specific to the underlying database dialect (e.g., uses Oracle/MySQL specific functions).
    @Query(value = "SELECT * FROM employees e WHERE e.department = :dept AND e.salary > 50000", nativeQuery = true)
    List<Employee> findByDepartmentNativeSQL(@Param("dept") String department);

    // 4. Named Query (Defined in @NamedQueries on the Entity class)
    List<Employee> findByDepartmentNamed(@Param("dept") String department);
    
    // 5. HQL using Partial Data Extraction (DTO Projection)
    @Query("SELECT e.name, e.salary FROM Employee e WHERE e.department = 'IT'")
    List<Object[]> getITEmployeeNamesAndSalaries();
}
