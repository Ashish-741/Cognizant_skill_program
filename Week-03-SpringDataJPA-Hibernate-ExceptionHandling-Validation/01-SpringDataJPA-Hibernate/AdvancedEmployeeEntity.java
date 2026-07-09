package week3.jpa.model;

import jakarta.persistence.*;
import org.hibernate.annotations.*;

/**
 * Advanced JPA/Hibernate Entity demonstrating all teacher-provided Hibernate categories:
 * - @DynamicInsert & @DynamicUpdate for optimized SQL generation
 * - @SQLDelete & @Where for Soft Deletion pattern
 * - @Formula for SQL calculated derived attributes
 * - Inherits @MappedSuperclass ID and creation/update timestamps from BaseEntity
 */
@Entity
@Table(name = "employees_advanced")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "UPDATE employees_advanced SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class AdvancedEmployeeEntity extends BaseEntity {

    @Column(name = "full_name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "salary")
    private Double salary;

    // Soft delete status flag
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    // Derived property calculated dynamically by database subquery
    @Formula("(SELECT COUNT(*) FROM employee_projects ep WHERE ep.employee_id = id)")
    private Integer projectCount;

    public AdvancedEmployeeEntity() {}

    public AdvancedEmployeeEntity(String name, String email, String departmentCode, Double salary) {
        this.name = name;
        this.email = email;
        this.departmentCode = departmentCode;
        this.salary = salary;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public Integer getProjectCount() { return projectCount; }
}
