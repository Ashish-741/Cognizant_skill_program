package week3.mapping;

import week3.mapping.model.Department;
import week3.mapping.model.EmployeeMapped;
import week3.mapping.model.Project;
import week3.mapping.service.EmployeeTransactionService;

/**
 * Demo runner showcasing Entity mappings and Transaction rollback.
 */
public class EntityMappingDemo {

    public static void main(String[] args) {
        System.out.println("=== Week 3 Topic 2: Entity Mapping & Declarative Transactions Demo ===");

        Department dept = new Department("DIGITAL_ENGINEERING", "Bangalore");
        EmployeeMapped emp1 = new EmployeeMapped("Ashish Kumar Chahar", "ashish@cognizant.com");
        EmployeeMapped emp2 = new EmployeeMapped("Rohan Mehta", "rohan@cognizant.com");

        dept.addEmployee(emp1);
        dept.addEmployee(emp2);

        Project proj = new Project("DNS-5.0", "Cognizant SkillSpring Enterprise Hub");
        emp1.getProjects().add(proj);

        System.out.println("\n--- Relationship Structure Built (@OneToMany & @ManyToMany) ---");
        System.out.println("Department: " + dept.getName() + " | Employees count: " + dept.getEmployees().size());
        System.out.println("Employee 1 assigned projects: " + emp1.getProjects().size());

        System.out.println("\n--- Testing @OneToOne Bidirectional Relationship ---");
        week3.mapping.model.UserProfile profile = new week3.mapping.model.UserProfile("+91-9876543210", "Bangalore, India", "GenC Next Cloud Engineer");
        week3.mapping.model.User user = new week3.mapping.model.User("ashish_c", "ashish@cognizant.com", profile);
        System.out.println("User created: " + user.getUsername() + " | Profile Phone: " + user.getProfile().getPhoneNumber());
        System.out.println("Inverse Profile User verification: " + profile.getUser().getUsername());

        System.out.println("\n--- Testing @Transactional Rollback Simulation ---");
        EmployeeTransactionService txService = new EmployeeTransactionService();
        try {
            txService.createDepartmentWithEmployees(dept, true);
        } catch (Exception e) {
            System.out.println("Caught exception gracefully: " + e.getMessage());
        }
    }
}
