package week3.mapping.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Project entity demonstrating @ManyToMany relationship with EmployeeMapped.
 */
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_code", nullable = false, unique = true)
    private String projectCode;

    @Column(name = "project_title")
    private String projectTitle;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<EmployeeMapped> employees = new HashSet<>();

    public Project() {}

    public Project(String projectCode, String projectTitle) {
        this.projectCode = projectCode;
        this.projectTitle = projectTitle;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProjectCode() { return projectCode; }
    public void setProjectCode(String projectCode) { this.projectCode = projectCode; }

    public String getProjectTitle() { return projectTitle; }
    public void setProjectTitle(String projectTitle) { this.projectTitle = projectTitle; }

    public Set<EmployeeMapped> getEmployees() { return employees; }
    public void setEmployees(Set<EmployeeMapped> employees) { this.employees = employees; }
}
