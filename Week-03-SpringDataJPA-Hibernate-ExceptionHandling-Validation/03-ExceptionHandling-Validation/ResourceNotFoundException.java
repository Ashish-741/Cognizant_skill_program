package week3.validation.exception;

/**
 * Custom exception thrown when a requested entity ID is missing.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
