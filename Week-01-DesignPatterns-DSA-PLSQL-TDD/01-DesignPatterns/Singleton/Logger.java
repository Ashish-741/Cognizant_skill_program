package week1.designpatterns.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    // 1. Private static volatile instance of itself (volatile prevents instruction reordering)
    private static volatile Logger instance;

    // Formatter for timestamping logs
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 2. Private constructor to prevent external instantiation
    private Logger() {
        System.out.println("[INIT] Singleton Logger instance initialized.");
    }

    // 3. Public static method to get the single instance using Double-Checked Locking
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Business method for logging messages
    public void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.printf("[%s] [%-5s] %s%n", timestamp, level, message);
    }
}
