package week2.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {

    private static final Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("EMP-101", "ashish.kumar@cognizant.com");
        userDatabase.put("EMP-102", "priya.verma@cognizant.com");
        // EMP-103 has no email registered
    }

    // Method returning Optional to explicitly signal potential missing values
    public static Optional<String> findEmailByEmpId(String empId) {
        return Optional.ofNullable(userDatabase.get(empId));
    }

    public static void main(String[] args) {
        System.out.println("--- Java 8 Optional Class Demo ---");

        // Case 1: Employee exists
        Optional<String> emailOpt1 = findEmailByEmpId("EMP-101");
        emailOpt1.ifPresent(email -> System.out.println("Found Employee Email: " + email));

        // Case 2: Employee does not exist (Avoiding NullPointerException using orElse)
        String email2 = findEmailByEmpId("EMP-999")
                .orElse("default.contact@cognizant.com");
        System.out.println("EMP-999 Email (Fallback used): " + email2);

        // Case 3: Transforming Optional value safely using map()
        String domain = findEmailByEmpId("EMP-102")
                .map(email -> email.substring(email.indexOf("@") + 1))
                .orElse("unknown-domain");
        System.out.println("EMP-102 Domain Name: " + domain);
    }
}
