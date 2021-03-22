package xiaoyf.demo.logback_log_sanitiser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        log.info("Hello");
        log.warn("Be careful");
        log.error("Something went wrong! the card number is 5406103652184798");
        log.info("World");

        try {
            Exception cause = new IOException("Network not available while processing card number 342272131049605");
            throw new RuntimeException("Error occurred", cause);
        } catch(Exception e) {
            log.error("Shit happens unfortunately.", e);
        }
    }
}