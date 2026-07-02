package logging.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Demo {
    private static final Logger logger = LogManager.getLogger(Log4j2Demo.class);

    public static void main(String[] args) {
        logger.info("Log4j2 system initialized.");
        logger.debug("Debugging database query performance.");
        logger.warn("Deprecated API used in module AuthenticationService.");
        logger.error("NullPointerException caught in Transaction processing loop.");
        logger.info("Log4j2 demo execution completed.");
    }
}
