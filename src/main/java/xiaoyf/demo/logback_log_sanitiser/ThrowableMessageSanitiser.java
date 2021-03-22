package xiaoyf.demo.logback_log_sanitiser;

import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.IThrowableProxy;

public class ThrowableMessageSanitiser extends ThrowableProxyConverter {

    @Override
    protected String throwableProxyToString(IThrowableProxy proxy) {
        return super.throwableProxyToString(new SanitisedThrowableProxy(proxy));
    }
}
