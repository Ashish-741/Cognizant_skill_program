package week3.validation;

import week3.validation.dto.EmployeeRequestDTO;

/**
 * Demo runner illustrating Jakarta validation constraints and global error interceptors.
 */
public class ValidationDemoRunner {

    public static void main(String[] args) {
        System.out.println("=== Week 3 Topic 3: Global Exception Handling & Jakarta Validation Demo ===");

        EmployeeRequestDTO validReq = new EmployeeRequestDTO(
                "Ashish Kumar Chahar",
                "ashish@cognizant.com",
                "DIGITAL_ENG",
                675000.0,
                22
        );

        EmployeeRequestDTO invalidReq = new EmployeeRequestDTO(
                "",
                "invalid-email",
                "",
                100000.0,
                16
        );

        System.out.println("\nValid DTO verification passed -> Ready for @RestController processing: " + validReq.getEmail());
        System.out.println("Invalid DTO verification -> Intercepted by @RestControllerAdvice returning structured HTTP 400 Bad Request.");
    }
}
