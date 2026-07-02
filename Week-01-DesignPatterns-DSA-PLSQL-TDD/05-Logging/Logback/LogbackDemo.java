package logging.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
    private static final Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {
        logger.info("Starting Logback Demonstration application...");
        logger.debug("Loading initial configuration parameters...");
        logger.warn("Memory utilization approaching 75% threshold.");
        logger.error("Failed to connect to remote caching server. Retrying...");
        logger.info("Logback Demonstration finished successfully.");
    }
}
