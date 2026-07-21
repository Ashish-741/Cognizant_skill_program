package week2.springjdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import week2.springjdbc.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Repository layer using Spring's JdbcTemplate to abstract away raw JDBC boilerplate.
 */
@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    // Dependency Injection of JdbcTemplate
    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * RowMapper to map ResultSet rows to Employee objects
     */
    private final RowMapper<Employee> employeeRowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Employee(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("department"),
                rs.getDouble("salary")
            );
        }
    };

    // 1. CREATE (Insert)
    public int save(Employee employee) {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        // JdbcTemplate handles Connection, PreparedStatement, execution, and closing automatically
        return jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
    }

    // 2. READ (Select All)
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, employeeRowMapper);
    }

    // 3. READ (Select by ID)
    public Employee findById(Long id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        // queryForObject fetches exactly one row, throws exception if 0 or >1 row found
        return jdbcTemplate.queryForObject(sql, employeeRowMapper, id);
    }

    // 4. UPDATE
    public int updateSalary(Long id, Double newSalary) {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        return jdbcTemplate.update(sql, newSalary, id);
    }

    // 5. DELETE
    public int deleteById(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
