package com.employee.dao;

import com.employee.factory.ConnectionFactory;
import com.employee.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of EmployeeDao using JDBC.
 * Uses Java 21 features like String Templates, enhanced switch, and pattern matching.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    // SQL Queries as constants
    private static final String INSERT_EMPLOYEE = 
        "INSERT INTO employees (name, email) VALUES (?, ?)";
    
    private static final String SELECT_BY_ID = 
        "SELECT id, name, email FROM employees WHERE id = ?";
    
    private static final String SELECT_ALL = 
        "SELECT id, name, email FROM employees";
    
    private static final String UPDATE_EMPLOYEE = 
        "UPDATE employees SET name = ?, email = ? WHERE id = ?";
    
    private static final String DELETE_EMPLOYEE = 
        "DELETE FROM employees WHERE id = ?";
    
    private static final String EXISTS_BY_ID = 
        "SELECT COUNT(*) FROM employees WHERE id = ?";
    
    private static final String COUNT_ALL = 
        "SELECT COUNT(*) FROM employees";

    @Override
    public int addEmployee(Employee employee) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_EMPLOYEE, 
                 Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating employee failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println(STR."✓ Employee added successfully [ID: \{id}]");
                    return id;
                } else {
                    throw new SQLException("Creating employee failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.err.println(STR."✗ Error adding employee: \{e.getMessage()}");
            return -1;
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToEmployee(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println(STR."✗ Error fetching employee [ID: \{id}]: \{e.getMessage()}");
        }
        
        return Optional.empty();
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
            
            System.out.println(STR."✓ Retrieved \{employees.size()} employees");
            
        } catch (SQLException e) {
            System.err.println(STR."✗ Error fetching all employees: \{e.getMessage()}");
        }
        
        return employees;
    }

    @Override
    public int updateEmployee(Employee employee) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_EMPLOYEE)) {
            
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setInt(3, employee.getId());
            
            int affectedRows = pstmt.executeUpdate();
            
            String message = switch (affectedRows) {
                case 0 -> STR."⚠ No employee found with ID: \{employee.getId()}";
                case 1 -> STR."✓ Employee updated successfully [ID: \{employee.getId()}]";
                default -> STR."⚠ Updated \{affectedRows} rows (expected 1)";
            };
            
            System.out.println(message);
            return affectedRows;
            
        } catch (SQLException e) {
            System.err.println(STR."✗ Error updating employee: \{e.getMessage()}");
            return 0;
        }
    }

    @Override
    public int deleteEmployee(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE_EMPLOYEE)) {
            
            pstmt.setInt(1, id);
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println(STR."✓ Employee deleted successfully [ID: \{id}]");
            } else {
                System.out.println(STR."⚠ No employee found with ID: \{id}");
            }
            
            return affectedRows;
            
        } catch (SQLException e) {
            System.err.println(STR."✗ Error deleting employee: \{e.getMessage()}");
            return 0;
        }
    }

    @Override
    public boolean existsById(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(EXISTS_BY_ID)) {
            
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println(STR."✗ Error checking employee existence: \{e.getMessage()}");
        }
        
        return false;
    }

    @Override
    public long count() {
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(COUNT_ALL)) {
            
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            System.err.println(STR."✗ Error counting employees: \{e.getMessage()}");
        }
        
        return 0;
    }

    /**
     * Maps a ResultSet row to an Employee object.
     * Uses pattern matching concept for clean mapping.
     */
    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        return new Employee()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .email(rs.getString("email"));
    }
}
