package com.employee.factory;

import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImpl;

/**
 * Factory class for creating EmployeeDao instances.
 * Provides abstraction layer for DAO creation.
 */
public final class EmployeeDaoFactory {
    
    // Private constructor to prevent instantiation
    private EmployeeDaoFactory() {
        throw new UnsupportedOperationException("Factory class cannot be instantiated");
    }

    // Thread-safe singleton instance
    private static final class InstanceHolder {
        static final EmployeeDao INSTANCE = new EmployeeDaoImpl();
    }

    /**
     * Returns the singleton EmployeeDao implementation.
     */
    public static EmployeeDao getEmployeeDao() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * Factory method to create a new instance (if needed for different implementations).
     */
    public static EmployeeDao createEmployeeDao() {
        return new EmployeeDaoImpl();
    }
}
