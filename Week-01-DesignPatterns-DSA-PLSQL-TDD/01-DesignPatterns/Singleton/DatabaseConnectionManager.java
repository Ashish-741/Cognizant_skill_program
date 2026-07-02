package singleton;

public class DatabaseConnectionManager {
    // volatile keyword ensures visibility of changes across threads
    private static volatile DatabaseConnectionManager instance;
    private String connectionString;

    // Private constructor to prevent direct instantiation
    private DatabaseConnectionManager() {
        this.connectionString = "jdbc:oracle:thin:@localhost:1521:xe";
        System.out.println("Initializing Database Connection Manager...");
    }

    // Double-checked locking for thread-safe singleton
    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to database using: " + connectionString);
    }

    public void executeQuery(String query) {
        System.out.println("Executing SQL Query: " + query);
    }
}
