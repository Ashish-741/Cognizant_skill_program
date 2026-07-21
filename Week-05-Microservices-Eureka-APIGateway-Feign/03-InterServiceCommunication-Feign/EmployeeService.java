package week5.feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week5.feign.client.DepartmentClient;
import week5.feign.client.DepartmentClient.DepartmentDTO;

/**
 * Employee Service demonstrating synchronous inter-service communication.
 * It uses the auto-generated Feign Client to seamlessly call the Department microservice.
 */
@Service
public class EmployeeService {

    private final DepartmentClient departmentClient;

    @Autowired
    public EmployeeService(DepartmentClient departmentClient) {
        this.departmentClient = departmentClient;
    }

    public String getEmployeeDetailsWithDepartment(Long empId, Long deptId) {
        System.out.println("Fetching Employee data from local database...");
        String employeeName = "Ashish Kumar Chahar"; // Mock local fetch

        System.out.println("Making synchronous REST call to DEPARTMENT-SERVICE via Feign...");
        // Network call happens here seamlessly!
        DepartmentDTO dept = departmentClient.getDepartmentById(deptId);

        return "Employee: " + employeeName + " | Belongs to: " + (dept != null ? dept.name : "Unknown Dept");
    }
}
