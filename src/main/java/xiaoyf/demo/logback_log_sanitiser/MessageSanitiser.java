package xiaoyf.demo.logback_log_sanitiser;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.util.Objects;

public class MessageSanitiser extends MessageConverter {

    public String convert(ILoggingEvent event) {
        // When an exception is not there, we do not touch the message (performance consideration)
        // e.g. when log.info("some message do not mask") or log.error("some message do not mask")

        if (Objects.isNull(event.getThrowableProxy())) {
            return event.getFormattedMessage();
        }

        // however, when there is an exception, we want to run masking
        // e.g. when log.error("some message to be masked", e)

        return CardNumberMasker.mask(event.getFormattedMessage());
    }
}
