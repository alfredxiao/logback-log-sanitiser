package xiaoyf.demo.logback_log_sanitiser;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class MessageSanitiser extends MessageConverter {
    private CardNumberMasker masker = new CardNumberMasker();

    public String convert(ILoggingEvent event) {
        return masker.mask(event.getFormattedMessage());
    }
}
