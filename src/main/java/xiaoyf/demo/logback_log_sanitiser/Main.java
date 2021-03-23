package xiaoyf.demo.logback_log_sanitiser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        log.info("Hello");
        log.warn("Be careful");
        log.error("Something went wrong! the card number is 5406103652184798");
        log.info("World");

        somethingBreaks();
    }

    private static void somethingBreaks() {
        try {
            Exception cause3 = new IllegalArgumentException("OS error card number 6011087959844029");
            Exception cause2 = new IOException("Network error while processing card number 4335933775050909", cause3);
            Exception cause1 = new SQLException("IO processing card number 342272131049605", cause2);
            throw new RuntimeException("Application error occurred with card number 5479543628277105 - bad card", cause1);
        } catch(Exception e) {
            log.error("Shit happens unfortunately for card number 343910583409046", e);
        }
    }
}