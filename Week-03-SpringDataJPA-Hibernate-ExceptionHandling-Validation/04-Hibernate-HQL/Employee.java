package week3.hql.entity;

import jakarta.persistence.*;

/**
 * Employee Entity demonstrating NamedQueries and JPA mapping for HQL tests.
 */
@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employee.findByDepartmentNamed", query = "SELECT e FROM Employee e WHERE e.department = :dept")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String department;
    
    private Double salary;

    // Constructors, Getters, Setters
    public Employee() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public Double getSalary() { return salary; }
}
