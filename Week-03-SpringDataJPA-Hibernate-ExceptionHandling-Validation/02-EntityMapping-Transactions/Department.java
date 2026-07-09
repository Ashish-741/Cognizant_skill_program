package week3.mapping.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Department entity demonstrating @OneToMany bidirectional relationship with Employee.
 */
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name", nullable = false, unique = true)
    private String name;

    @Column(name = "location")
    private String location;

    // Bidirectional OneToMany relationship with Cascade and Lazy Fetching
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<EmployeeMapped> employees = new ArrayList<>();

    public Department() {}

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addEmployee(EmployeeMapped employee) {
        employees.add(employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(EmployeeMapped employee) {
        employees.remove(employee);
        employee.setDepartment(null);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<EmployeeMapped> getEmployees() { return employees; }
    public void setEmployees(List<EmployeeMapped> employees) { this.employees = employees; }
}
