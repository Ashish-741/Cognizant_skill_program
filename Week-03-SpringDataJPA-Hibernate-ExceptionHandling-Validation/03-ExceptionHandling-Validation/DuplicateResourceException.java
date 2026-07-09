package week3.validation.exception;

/**
 * Custom exception thrown when attempting to register a duplicate unique constraint (e.g., email).
 */
public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message) {
        super(message);
    }
}
