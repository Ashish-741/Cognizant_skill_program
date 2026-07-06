package com.cognizant.skillspring.rest.service;

import com.cognizant.skillspring.rest.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final List<Employee> employeeRepository = new ArrayList<>();

    public EmployeeService() {
        // Initial sample seed data
        employeeRepository.add(new Employee(101, "Ashish Kumar", "ashish@cognizant.com", "Digital", 675000));
        employeeRepository.add(new Employee(102, "Priya Verma", "priya@cognizant.com", "Analytics", 820000));
        employeeRepository.add(new Employee(103, "Rahul Sharma", "rahul@cognizant.com", "Cloud", 750000));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeRepository);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public Employee createEmployee(Employee employee) {
        // Generate new ID if not provided
        int newId = employee.getId() > 0 ? employee.getId() : employeeRepository.size() + 101;
        employee.setId(newId);
        employeeRepository.add(employee);
        return employee;
    }

    public Optional<Employee> updateEmployee(int id, Employee updatedData) {
        return getEmployeeById(id).map(existing -> {
            existing.setName(updatedData.getName());
            existing.setEmail(updatedData.getEmail());
            existing.setDepartment(updatedData.getDepartment());
            existing.setSalary(updatedData.getSalary());
            return existing;
        });
    }

    public boolean deleteEmployee(int id) {
        return employeeRepository.removeIf(e -> e.getId() == id);
    }
}
