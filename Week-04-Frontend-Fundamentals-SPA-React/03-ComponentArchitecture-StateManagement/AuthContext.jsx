import React, { createContext, useState, useContext } from 'react';

// 1. Create the AuthContext to share authentication state across the component tree
const AuthContext = createContext();

/**
 * Context Provider Component.
 * Wraps the application hierarchy and provides current user data to any consumer component without prop drilling.
 */
export function AuthProvider({ children }) {
    const [currentUser, setCurrentUser] = useState({
        username: 'Ashish Kumar Chahar',
        role: 'GenC Next Architect',
        isAuthenticated: true,
        sessionToken: 'jwt-mock-token-dns-5.0'
    });

    const login = (username, role) => {
        setCurrentUser({
            username,
            role,
            isAuthenticated: true,
            sessionToken: `token-${Date.now()}`
        });
    };

    const logout = () => {
        setCurrentUser({
            username: 'Guest',
            role: 'Unauthorized',
            isAuthenticated: false,
            sessionToken: null
        });
    };

    return (
        <AuthContext.Provider value={{ currentUser, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
}

/**
 * Custom hook for consuming AuthContext cleanly across child components.
 */
export function useAuth() {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error('useAuth must be used within an AuthProvider hierarchy');
    }
    return context;
}
