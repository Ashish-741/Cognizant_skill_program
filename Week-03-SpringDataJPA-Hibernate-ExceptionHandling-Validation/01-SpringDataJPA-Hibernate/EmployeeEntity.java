package week3.jpa.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * JPA Entity representing the 'employees' table in the relational database.
 * Demonstrates standard ORM annotations including table mapping and identity generation.
 */
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String name;

    @Column(name = "email_address", nullable = false, unique = true)
    private String email;

    @Column(name = "department_code", length = 50)
    private String department;

    @Column(name = "annual_salary")
    private Double salary;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public EmployeeEntity() {}

    public EmployeeEntity(String name, String email, String department, Double salary) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.createdAt = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", name=" + name + ", email=" + email + 
               ", department=" + department + ", salary=" + salary + "]";
    }
}
