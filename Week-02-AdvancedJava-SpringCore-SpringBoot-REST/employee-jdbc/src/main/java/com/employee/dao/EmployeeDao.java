package com.employee.dao;

import com.employee.model.Employee;
import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for Employee entity.
 * Defines CRUD operations contract.
 */
public interface EmployeeDao {
    int addEmployee(Employee employee);
    Optional<Employee> getEmployeeById(int id);
    List<Employee> getAllEmployees();
    int updateEmployee(Employee employee);
    int deleteEmployee(int id);
    boolean existsById(int id);
    long count();
}
