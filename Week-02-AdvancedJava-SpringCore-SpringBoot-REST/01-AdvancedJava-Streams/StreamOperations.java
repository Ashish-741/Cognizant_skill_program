package week2.streams;

import java.util.*;
import java.util.stream.Collectors;

class EmployeeDTO {
    private int id;
    private String name;
    private String department;
    private double salary;

    public EmployeeDTO(int id, String name, String department, double salary) {
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
        return String.format("Emp #%d | %-15s | Dept: %-10s | ₹%,.2f", id, name, department, salary);
    }
}

public class StreamOperations {
    public static void main(String[] args) {
        System.out.println("--- Stream API Operations Demo ---");

        List<EmployeeDTO> roster = Arrays.asList(
            new EmployeeDTO(101, "Ashish Kumar", "Digital", 675000),
            new EmployeeDTO(102, "Priya Verma", "Analytics", 820000),
            new EmployeeDTO(103, "Rahul Sharma", "Digital", 710000),
            new EmployeeDTO(104, "Sneha Nair", "Cloud", 950000),
            new EmployeeDTO(105, "Amit Patel", "Cloud", 640000)
        );

        // 1. Filter: Employees earning more than ₹700,000
        System.out.println("\n1. High Earners (> ₹700,000):");
        roster.stream()
              .filter(e -> e.getSalary() > 700000)
              .forEach(System.out::println);

        // 2. Map & Sort: Uppercase names of Cloud department employees sorted by salary descending
        System.out.println("\n2. Cloud Team Names (Sorted by Salary Descending):");
        List<String> cloudNames = roster.stream()
              .filter(e -> e.getDepartment().equalsIgnoreCase("Cloud"))
              .sorted(Comparator.comparingDouble(EmployeeDTO::getSalary).reversed())
              .map(e -> e.getName().toUpperCase() + " (₹" + e.getSalary() + ")")
              .collect(Collectors.toList());
        cloudNames.forEach(System.out::println);

        // 3. GroupingBy: Group employees by department
        System.out.println("\n3. Headcount & Roster Grouped by Department:");
        Map<String, List<EmployeeDTO>> byDept = roster.stream()
              .collect(Collectors.groupingBy(EmployeeDTO::getDepartment));
        
        byDept.forEach((dept, list) -> {
            System.out.println("Department: [" + dept + "] - Count: " + list.size());
            list.forEach(emp -> System.out.println("   -> " + emp.getName()));
        });

        // 4. Reduce: Total company payroll
        double totalPayroll = roster.stream()
              .mapToDouble(EmployeeDTO::getSalary)
              .sum();
        System.out.printf("\n4. Total Annual Payroll: ₹%,.2f\n", totalPayroll);
    }
}
