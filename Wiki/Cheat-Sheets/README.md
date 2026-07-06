# Quick Reference Cheat Sheets

A condensed reference guide for Java 8 Streams, PL/SQL concepts, Algorithm Complexities, and Git workflows.

---

## 1. Java 8 Streams Cheat Sheet

```java
// 1. Filter and Collect to List
List<String> filtered = list.stream()
    .filter(s -> s.startsWith("A"))
    .collect(Collectors.toList());

// 2. Map (Transformation)
List<Integer> lengths = words.stream()
    .map(String::length)
    .collect(Collectors.toList());

// 3. Sorting (Ascending & Descending)
list.stream().sorted().collect(Collectors.toList());
list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

// 4. Grouping by Attribute
Map<String, List<Employee>> byDept = empList.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment));

// 5. Finding Max / Min
Optional<Employee> highestPaid = empList.stream()
    .max(Comparator.comparingDouble(Employee::getSalary));
```

---

## 2. Big-O Complexity Cheat Sheet (DSA)

| Data Structure / Algorithm | Time Complexity (Average) | Time Complexity (Worst) | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Array Access (by index)** | $O(1)$ | $O(1)$ | $O(N)$ |
| **Binary Search (Sorted Array)** | $O(\log N)$ | $O(\log N)$ | $O(1)$ Iterative |
| **Bubble Sort** | $O(N^2)$ | $O(N^2)$ | $O(1)$ |
| **Quick Sort** | $O(N \log N)$ | $O(N^2)$ (if pivot is poor) | $O(\log N)$ stack |
| **HashMap Search / Insert** | $O(1)$ | $O(N)$ (or $O(\log N)$ tree) | $O(N)$ |

---

## 3. PL/SQL Syntax Quick Reference

### Stored Procedure Structure
```sql
CREATE OR REPLACE PROCEDURE procedure_name (
    p_param1 IN NUMBER,
    p_param2 OUT VARCHAR2
) IS
    v_local_var NUMBER := 10;
BEGIN
    SELECT column_name INTO p_param2 FROM table_name WHERE id = p_param1;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        p_param2 := 'Default';
END procedure_name;
/
```

### Row-Level Trigger Structure
```sql
CREATE OR REPLACE TRIGGER trigger_name
BEFORE UPDATE ON table_name
FOR EACH ROW
BEGIN
    IF :NEW.salary < :OLD.salary THEN
        RAISE_APPLICATION_ERROR(-20001, 'Salary cannot be decreased!');
    END IF;
END;
/
```

---

## 4. Git Daily Workflow Cheat Sheet

```bash
# Check repository status and untracked files
git status -s

# Stage all changes
git add .

# Commit with a descriptive professional message
git commit -m "feat(week1): implement thread-safe singleton and plsql triggers"

# Push branch to remote GitHub repository
git push origin main
```

---

## 5. Java 21 & JDBC Pattern Cheat Sheet

```java
// 1. Java 21 String Templates (Preview)
String message = STR."Employee added [ID: \{id}, Name: '\{name}']";

// 2. Switch Expressions with Yield
String status = switch (affectedRows) {
    case 0 -> { yield "No rows updated"; }
    case 1 -> { yield "Update successful"; }
    default -> { yield STR."Updated \{affectedRows} rows"; }
};

// 3. ResourceBundle Loading
ResourceBundle bundle = ResourceBundle.getBundle("dbConfig");
String url = bundle.getString("db.url");

// 4. Thread-Safe Double-Checked Locking Singleton (ConnectionFactory)
public static Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
        synchronized (ConnectionFactory.class) {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, user, pass);
            }
        }
    }
    return connection;
}
```
