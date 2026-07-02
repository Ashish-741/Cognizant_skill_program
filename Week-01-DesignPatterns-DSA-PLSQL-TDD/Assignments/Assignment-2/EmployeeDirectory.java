package assignments.assignment2;

import java.util.*;
import java.util.stream.Collectors;

// Assignment 2: Java Collections Framework & Java 8 Streams
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("Emp #%d | %-12s | Dept: %-12s | Salary: ₹%,.2f", id, name, department, salary);
    }
}

public class EmployeeDirectory {
    public static void main(String[] args) {
        System.out.println("--- Assignment 2: Employee Directory (Collections & Streams) ---");
        
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Ashish Kumar", "IT", 675000));
        employees.add(new Employee(102, "Priya Verma", "Digital", 720000));
        employees.add(new Employee(103, "Rahul Sharma", "IT", 640000));
        employees.add(new Employee(104, "Sneha Nair", "Analytics", 810000));
        employees.add(new Employee(105, "Amit Patel", "Digital", 690000));

        // 1. Filter employees in 'IT' department and sort by salary descending
        System.out.println("\nIT Department Employees sorted by salary (desc):");
        employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        // 2. Group employees by Department
        System.out.println("\nEmployees Grouped by Department:");
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        
        byDept.forEach((dept, empList) -> {
            System.out.println("Department: " + dept + " (" + empList.size() + " employees)");
            empList.forEach(e -> System.out.println("   -> " + e.getName()));
        });

        // 3. Find average salary across the company
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.printf("\nCompany Average Salary: ₹%,.2f\n", avgSalary);
    }
}
