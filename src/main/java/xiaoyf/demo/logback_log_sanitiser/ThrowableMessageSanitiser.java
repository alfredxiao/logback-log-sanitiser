package xiaoyf.demo.logback_log_sanitiser;

import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.CoreConstants;

public class ThrowableMessageSanitiser extends ThrowableProxyConverter {

    @Override
    protected String throwableProxyToString(IThrowableProxy proxy) {
        return CoreConstants.LINE_SEPARATOR +
                super.throwableProxyToString(new SanitisedThrowableProxy(proxy)) +
                CoreConstants.LINE_SEPARATOR;
    }
}
