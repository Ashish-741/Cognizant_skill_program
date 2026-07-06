package week1.designpatterns.mvc;

// View class responsible solely for UI display logic
public class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("-------------------------------------");
        System.out.println("       STUDENT RECORD DETAILS        ");
        System.out.println("-------------------------------------");
        System.out.printf("  Name  : %s%n", studentName);
        System.out.printf("  ID    : %s%n", studentId);
        System.out.printf("  Grade : %s%n", studentGrade);
        System.out.println("-------------------------------------\n");
    }
}
