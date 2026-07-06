package week2.assignments.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

class Student {
    private int rollNo;
    private String name;
    private String course;
    private double gpa;

    public Student() {}
    public Student(int rollNo, String name, String course, double gpa) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
    }

    public int getRollNo() { return rollNo; }
    public void setRollNo(int rollNo) { this.rollNo = rollNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
}

@RestController
@RequestMapping("/api/v1/students")
class StudentController {
    private final Map<Integer, Student> studentDatabase = new HashMap<>();

    public StudentController() {
        studentDatabase.put(1, new Student(1, "Ashish Kumar Chahar", "Full Stack Engineering", 9.2));
        studentDatabase.put(2, "Priya Verma", "Cloud Computing & DevOps", 8.9);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentDatabase.values());
    }

    @GetMapping("/{rollNo}")
    public ResponseEntity<Student> getStudentByRollNo(@PathVariable int rollNo) {
        Student student = studentDatabase.get(rollNo);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Student> enrollStudent(@RequestBody Student student) {
        studentDatabase.put(student.getRollNo(), student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @DeleteMapping("/{rollNo}")
    public ResponseEntity<Void> expelStudent(@PathVariable int rollNo) {
        return studentDatabase.remove(rollNo) != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

@SpringBootApplication
public class StudentManagementRestApi {
    public static void main(String[] args) {
        SpringApplication.run(StudentManagementRestApi.class, args);
        System.out.println("=== Week 2 Mini-Project: Student Management REST API Running on port 8081 ===");
    }
}
