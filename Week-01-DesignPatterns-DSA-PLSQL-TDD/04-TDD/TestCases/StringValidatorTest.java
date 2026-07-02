package tdd.testcases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringValidatorTest {

    // Helper method: Validates if a username meets minimum criteria (8-15 chars, alphanumeric)
    public boolean isValidUsername(String username) {
        if (username == null) return false;
        return username.matches("^[a-zA-Z0-9]{8,15}$");
    }

    @Test
    void testValidUsernameLengthBoundary() {
        assertTrue(isValidUsername("user1234"), "8 chars should be valid (Lower Boundary)");
        assertTrue(isValidUsername("user12345678901"), "15 chars should be valid (Upper Boundary)");
    }

    @Test
    void testInvalidUsernameLengthBoundary() {
        assertFalse(isValidUsername("user123"), "7 chars should be invalid (Below Lower Boundary)");
        assertFalse(isValidUsername("user123456789012"), "16 chars should be invalid (Above Upper Boundary)");
    }

    @Test
    void testInvalidCharacters() {
        assertFalse(isValidUsername("user@1234"), "Special characters should be rejected");
        assertFalse(isValidUsername("user 1234"), "Spaces should be rejected");
    }
}
