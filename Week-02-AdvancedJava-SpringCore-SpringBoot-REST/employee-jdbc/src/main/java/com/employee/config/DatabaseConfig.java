package com.employee.config;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Database configuration utility using ResourceBundle.
 * Provides type-safe access to database properties.
 */
public final class DatabaseConfig {
    private static final String BUNDLE_NAME = "dbConfig";
    private static final ResourceBundle bundle;

    static {
        try {
            bundle = ResourceBundle.getBundle(BUNDLE_NAME);
            // Load JDBC driver
            Class.forName(bundle.getString("db.driver"));
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(
                STR."Failed to load JDBC driver: \{e.getMessage()}"
            );
        } catch (MissingResourceException e) {
            throw new ExceptionInInitializerError(
                STR."Configuration file '\{BUNDLE_NAME}.properties' not found in classpath"
            );
        }
    }

    // Private constructor to prevent instantiation
    private DatabaseConfig() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    // Database connection properties
    public static String getDriver() { return getRequiredProperty("db.driver"); }
    public static String getUrl() { return getRequiredProperty("db.url"); }
    public static String getUsername() { return getRequiredProperty("db.username"); }
    public static String getPassword() { return getRequiredProperty("db.password"); }

    // Optional properties with defaults
    public static int getPoolSize() { 
        return getIntProperty("db.pool.size", 10); 
    }
    
    public static int getTimeout() { 
        return getIntProperty("db.timeout", 30); 
    }

    // Generic property accessors
    public static String getProperty(String key) {
        return bundle.containsKey(key) ? bundle.getString(key) : null;
    }

    public static String getProperty(String key, String defaultValue) {
        return bundle.containsKey(key) ? bundle.getString(key) : defaultValue;
    }

    public static int getIntProperty(String key, int defaultValue) {
        try {
            return bundle.containsKey(key) ? Integer.parseInt(bundle.getString(key)) : defaultValue;
        } catch (NumberFormatException e) {
            System.err.println(STR."Invalid integer value for key '\{key}', using default: \{defaultValue}");
            return defaultValue;
        }
    }

    public static boolean getBooleanProperty(String key, boolean defaultValue) {
        return bundle.containsKey(key) ? Boolean.parseBoolean(bundle.getString(key)) : defaultValue;
    }

    // Utility methods
    public static boolean hasProperty(String key) {
        return bundle.containsKey(key);
    }

    public static void printAllProperties() {
        System.out.println("=== Database Configuration ===");
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if (key.contains("password")) {
                System.out.println(STR."\{key} = ****");
            } else {
                System.out.println(STR."\{key} = \{bundle.getString(key)}");
            }
        }
        System.out.println("==============================");
    }

    // Clear cache and reload (useful for hot-reload scenarios)
    public static void reload() {
        ResourceBundle.clearCache();
    }

    // Private helper methods
    private static String getRequiredProperty(String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            throw new IllegalStateException(
                STR."Required property '\{key}' not found in \{BUNDLE_NAME}.properties"
            );
        }
    }
}
