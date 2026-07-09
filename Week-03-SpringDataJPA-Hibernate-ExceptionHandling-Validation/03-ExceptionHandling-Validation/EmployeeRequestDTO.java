package week3.validation.dto;

import jakarta.validation.constraints.*;

/**
 * Data Transfer Object representing incoming Employee creation requests.
 * Uses Jakarta Validation constraints to enforce strict payload verification.
 */
public class EmployeeRequestDTO {

    @NotBlank(message = "Employee name must not be blank")
    @Size(min = 2, max = 100, message = "Employee name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email address is required")
    @Email(message = "Email address must be well-formed")
    private String email;

    @NotBlank(message = "Department code is mandatory")
    private String department;

    @NotNull(message = "Salary is required")
    @DecimalMin(value = "300000.0", message = "Annual salary must be at least 3.0 LPA")
    private Double salary;

    @Min(value = 18, message = "Employee must be at least 18 years old")
    @Max(value = 65, message = "Employee age cannot exceed retirement age of 65")
    private Integer age;

    public EmployeeRequestDTO() {}

    public EmployeeRequestDTO(String name, String email, String department, Double salary, Integer age) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}
