package com.employee;

import com.employee.config.DatabaseConfig;
import com.employee.dao.EmployeeDao;
import com.employee.factory.ConnectionFactory;
import com.employee.factory.EmployeeDaoFactory;
import com.employee.model.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main application class for Employee Management System.
 * Demonstrates CRUD operations using JDBC with Java 21 features.
 */
public class Main {
    private static final EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printBanner();
        
        // Validate database connection
        if (!ConnectionFactory.testConnection()) {
            System.err.println("✗ Failed to connect to database. Exiting...");
            return;
        }
        
        // Show configuration
        DatabaseConfig.printAllProperties();
        
        // Start application loop
        runApplication();
        
        // Cleanup
        cleanup();
    }

    private static void printBanner() {
        System.out.println("""
            ╔══════════════════════════════════════╗
            ║   Employee Management System v2.0    ║
            ║      Java 21 + JDBC + Maven          ║
            ╚══════════════════════════════════════╝
            """);
    }

    private static void runApplication() {
        boolean running = true;
        
        while (running) {
            displayMenu();
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                running = processChoice(choice);
                
            } catch (InputMismatchException e) {
                System.out.println("⚠ Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void displayMenu() {
        System.out.println(STR."""
            
            ┌────────────────────────────────────┐
            │           MAIN MENU                │
            ├────────────────────────────────────┤
            │  1. 📝 Add Employee                │
            │  2. 🔍 View Employee by ID         │
            │  3. 📋 View All Employees          │
            │  4. ✏️  Update Employee             │
            │  5. 🗑️  Delete Employee             │
            │  6. 📊 Show Statistics              │
            │  7. 🔧 Test Configuration           │
            │  8. 🚪 Exit                        │
            └────────────────────────────────────┘
            Enter your choice (1-8):\s""");
    }

    private static boolean processChoice(int choice) {
        return switch (choice) {
            case 1 -> { addEmployee(); yield true; }
            case 2 -> { viewEmployee(); yield true; }
            case 3 -> { viewAllEmployees(); yield true; }
            case 4 -> { updateEmployee(); yield true; }
            case 5 -> { deleteEmployee(); yield true; }
            case 6 -> { showStatistics(); yield true; }
            case 7 -> { testConfiguration(); yield true; }
            case 8 -> { 
                System.out.println("\n👋 Thank you for using Employee Management System!");
                yield false; 
            }
            default -> { 
                System.out.println("⚠ Invalid choice! Please enter a number between 1-8.");
                yield true; 
            }
        };
    }

    private static void addEmployee() {
        System.out.println("\n=== 📝 Add New Employee ===");
        
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            System.out.println("⚠ Name cannot be empty!");
            return;
        }
        
        System.out.print("Enter employee email: ");
        String email = scanner.nextLine().trim();
        
        if (email.isEmpty() || !email.contains("@")) {
            System.out.println("⚠ Invalid email format!");
            return;
        }
        
        Employee employee = new Employee(name, email);
        int id = employeeDao.addEmployee(employee);
        
        if (id > 0) {
            System.out.println(STR."✅ Employee created successfully with ID: \{id}");
        }
    }

    private static void viewEmployee() {
        System.out.println("\n=== 🔍 View Employee ===");
        System.out.print("Enter employee ID: ");
        
        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            employeeDao.getEmployeeById(id)
                .ifPresentOrElse(
                    emp -> System.out.println(STR."✅ Found: \{emp}"),
                    () -> System.out.println(STR."❌ No employee found with ID: \{id}")
                );
                
        } catch (InputMismatchException e) {
            System.out.println("⚠ Invalid ID format!");
            scanner.nextLine(); // Clear invalid input
        }
    }

    private static void viewAllEmployees() {
        System.out.println("\n=== 📋 All Employees ===");
        
        var employees = employeeDao.getAllEmployees();
        
        if (employees.isEmpty()) {
            System.out.println("📭 No employees found in the database.");
        } else {
            System.out.println(STR."📊 Total employees: \{employees.size()}");
            System.out.println("─".repeat(60));
            employees.forEach(emp -> 
                System.out.println(STR."  ID: \{emp.getId()} | Name: \{emp.getName()} | Email: \{emp.getEmail()}")
            );
            System.out.println("─".repeat(60));
        }
    }

    private static void updateEmployee() {
        System.out.println("\n=== ✏️ Update Employee ===");
        System.out.print("Enter employee ID to update: ");
        
        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            var employeeOpt = employeeDao.getEmployeeById(id);
            
            if (employeeOpt.isEmpty()) {
                System.out.println(STR."❌ No employee found with ID: \{id}");
                return;
            }
            
            var employee = employeeOpt.get();
            System.out.println(STR."Current details: \{employee}");
            
            System.out.print("Enter new name (press Enter to keep '");
            System.out.print(employee.getName());
            System.out.print("'): ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                employee.setName(name);
            }
            
            System.out.print("Enter new email (press Enter to keep '");
            System.out.print(employee.getEmail());
            System.out.print("'): ");
            String email = scanner.nextLine().trim();
            if (!email.isEmpty()) {
                employee.setEmail(email);
            }
            
            int result = employeeDao.updateEmployee(employee);
            if (result > 0) {
                System.out.println("✅ Employee updated successfully!");
            }
            
        } catch (InputMismatchException e) {
            System.out.println("⚠ Invalid ID format!");
            scanner.nextLine(); // Clear invalid input
        }
    }

    private static void deleteEmployee() {
        System.out.println("\n=== 🗑️ Delete Employee ===");
        System.out.print("Enter employee ID to delete: ");
        
        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            employeeDao.getEmployeeById(id).ifPresentOrElse(
                emp -> {
                    System.out.println(STR."Employee to delete: \{emp}");
                    System.out.print("⚠ Are you sure you want to delete this employee? (y/n): ");
                    String confirmation = scanner.nextLine();
                    
                    if (confirmation.equalsIgnoreCase("y")) {
                        int result = employeeDao.deleteEmployee(id);
                        if (result > 0) {
                            System.out.println("✅ Employee deleted successfully!");
                        }
                    } else {
                        System.out.println("❌ Deletion cancelled.");
                    }
                },
                () -> System.out.println(STR."❌ No employee found with ID: \{id}")
            );
            
        } catch (InputMismatchException e) {
            System.out.println("⚠ Invalid ID format!");
            scanner.nextLine(); // Clear invalid input
        }
    }

    private static void showStatistics() {
        System.out.println("\n=== 📊 System Statistics ===");
        System.out.println(STR."Total Employees: \{employeeDao.count()}");
        System.out.println(STR."Database Connected: \{ConnectionFactory.testConnection()}");
        DatabaseConfig.printAllProperties();
    }

    private static void testConfiguration() {
        System.out.println("\n=== 🔧 Testing Configuration ===");
        
        System.out.println("1. Testing ResourceBundle loading...");
        try {
            DatabaseConfig.printAllProperties();
            System.out.println("✅ ResourceBundle loaded successfully");
        } catch (Exception e) {
            System.err.println(STR."❌ ResourceBundle error: \{e.getMessage()}");
        }
        
        System.out.println("\n2. Testing Database Connection...");
        boolean connected = ConnectionFactory.testConnection();
        System.out.println(connected ? "✅ Connection successful" : "❌ Connection failed");
        
        System.out.println("\n3. Testing DAO Operations...");
        try {
            long count = employeeDao.count();
            System.out.println(STR."✅ DAO working - Found \{count} employees");
        } catch (Exception e) {
            System.err.println(STR."❌ DAO error: \{e.getMessage()}");
        }
    }

    private static void cleanup() {
        scanner.close();
        ConnectionFactory.closeConnection();
    }
}
