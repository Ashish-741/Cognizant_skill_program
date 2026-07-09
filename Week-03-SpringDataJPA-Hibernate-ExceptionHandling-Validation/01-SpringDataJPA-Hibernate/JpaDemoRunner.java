package week3.jpa;

import week3.jpa.model.EmployeeEntity;

/**
 * Demonstration runner showcasing Spring Data JPA concepts.
 */
public class JpaDemoRunner {

    public static void main(String[] args) {
        System.out.println("=== Week 3 Topic 1: Spring Data JPA & Hibernate ORM Architecture Demo ===");

        // Simulate Entity creation
        EmployeeEntity emp1 = new EmployeeEntity("Ashish Kumar Chahar", "ashish@cognizant.com", "DIGITAL_ENG", 675000.0);
        EmployeeEntity emp2 = new EmployeeEntity("Priya Sharma", "priya@cognizant.com", "DIGITAL_ENG", 850000.0);

        System.out.println("Created Transient Entities:");
        System.out.println("  -> " + emp1);
        System.out.println("  -> " + emp2);

        System.out.println("\nKey Spring Data JPA benefits demonstrated:");
        System.out.println("  ✓ No boilerplate JDBC SQL required for basic CRUD operations");
        System.out.println("  ✓ Automatic translation of method names (findByDepartmentAndSalaryGreaterThan)");
        System.out.println("  ✓ JPQL and Native query support via @Query annotation");
        System.out.println("  ✓ Built-in Pageable and Sort support for high-throughput enterprise lists");
    }
}
