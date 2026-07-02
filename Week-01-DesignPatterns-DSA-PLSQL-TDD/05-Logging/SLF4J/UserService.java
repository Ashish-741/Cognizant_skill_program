package logging.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public void registerUser(String username, String email) {
        logger.info("Attempting to register new user: {}", username);
        
        if (email == null || !email.contains("@")) {
            logger.error("Registration failed for user '{}': Invalid email format ({})", username, email);
            throw new IllegalArgumentException("Invalid email address");
        }

        logger.debug("Validating username uniqueness in database for: {}", username);
        // Simulate database save
        logger.info("User '{}' successfully registered with email: {}", username, email);
    }

    public static void main(String[] args) {
        UserService service = new UserService();
        try {
            service.registerUser("ashish_k", "ashish@cognizant.com");
            service.registerUser("invalid_user", "invalid-email");
        } catch (Exception e) {
            logger.warn("Handled expected exception during user registration: {}", e.getMessage());
        }
    }
}
