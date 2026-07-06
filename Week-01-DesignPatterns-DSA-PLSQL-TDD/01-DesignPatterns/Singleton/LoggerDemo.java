package week1.designpatterns.singleton;

public class LoggerDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercise 1: Testing Singleton Pattern with Logger ===");

        // Get first instance of Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("INFO", "Application started successfully.");

        // Get second instance of Logger
        Logger logger2 = Logger.getInstance();
        logger2.log("DEBUG", "Connecting to database...");

        // Get third instance of Logger
        Logger logger3 = Logger.getInstance();
        logger3.log("ERROR", "Simulated exception for testing logging utility.");

        // Verify that all references point to the exact same memory location
        System.out.println("\n--- Verification ---");
        System.out.println("logger1 == logger2? " + (logger1 == logger2));
        System.out.println("logger2 == logger3? " + (logger2 == logger3));

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("SUCCESS: Only one instance of Logger was created across the application!");
        } else {
            System.out.println("FAILURE: Multiple Logger instances detected!");
        }
    }
}
