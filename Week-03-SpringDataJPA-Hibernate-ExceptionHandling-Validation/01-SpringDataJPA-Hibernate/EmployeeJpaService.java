package week3.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import week3.jpa.model.EmployeeEntity;
import week3.jpa.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service class encapsulating business logic and interacting with EmployeeRepository.
 */
@Service
public class EmployeeJpaService {

    private final EmployeeRepository employeeRepository;

    public EmployeeJpaService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity registerEmployee(EmployeeEntity employee) {
        System.out.println("[SERVICE] Persisting new employee entity: " + employee.getName());
        return employeeRepository.save(employee);
    }

    public List<EmployeeEntity> getEmployeesByDepartment(String departmentCode) {
        return employeeRepository.findByDepartment(departmentCode);
    }

    public Optional<EmployeeEntity> getEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    public Page<EmployeeEntity> getPaginatedEmployeesByDepartment(String department, int pageNumber, int pageSize) {
        // PageRequest is 0-indexed; sorted descending by salary
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("salary").descending());
        return employeeRepository.findByDepartment(department, pageRequest);
    }

    public void deleteEmployee(Long id) {
        System.out.println("[SERVICE] Removing employee with ID: " + id);
        employeeRepository.deleteById(id);
    }
}
