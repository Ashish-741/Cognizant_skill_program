package week1.designpatterns.mvc;

public class MVCDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercise 10: Testing MVC Pattern with Student Management System ===");

        // 1. Fetch student data from database (simulated)
        Student model = retrieveStudentFromDatabase();

        // 2. Initialize console display view
        StudentView view = new StudentView();

        // 3. Bind model and view via controller
        StudentController controller = new StudentController(model, view);

        // Display initial student details
        System.out.println("\n--- Initial Student Record ---");
        controller.updateView();

        // 4. Update student grade using controller
        System.out.println("--- Updating Student Grade to 'A+' via Controller ---");
        controller.setStudentGrade("A+");
        controller.setStudentName("Ashish Kumar Chahar");

        // Display updated student details
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        return new Student("CTS-884912", "Ashish Kumar", "A");
    }
}
