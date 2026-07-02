package singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern Demo ---");
        
        // Request two instances of DatabaseConnectionManager
        DatabaseConnectionManager conn1 = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager conn2 = DatabaseConnectionManager.getInstance();

        conn1.connect();
        conn1.executeQuery("SELECT * FROM employees");

        // Verify that both references point to the same object in memory
        if (conn1 == conn2) {
            System.out.println("Success: conn1 and conn2 point to the same Singleton instance.");
        } else {
            System.out.println("Error: Different instances were created!");
        }
    }
}
