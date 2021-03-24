package xiaoyf.demo.logback_log_sanitiser;

import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;

import java.util.Objects;

public class SanitisedThrowableProxy implements IThrowableProxy {
    private final IThrowableProxy proxy;

    public SanitisedThrowableProxy(IThrowableProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public String getMessage() {
        if (proxy.getMessage() == null) {
            return null;
        }
        return CardNumberMasker.mask(proxy.getMessage());
    }

    @Override
    public IThrowableProxy getCause() {
        if (proxy.getCause() == null) {
            return null;
        }
        if (proxy.getCause() == proxy || proxy.getCause() == this) {
            return this;
        }
        return new SanitisedThrowableProxy(proxy.getCause());
    }

    @Override
    public String getClassName() {
        return proxy.getClassName();
    }

    @Override
    public StackTraceElementProxy[] getStackTraceElementProxyArray() {
        return proxy.getStackTraceElementProxyArray();
    }

    @Override
    public int getCommonFrames() {
        return proxy.getCommonFrames();
    }

    @Override
    public IThrowableProxy[] getSuppressed() {
        IThrowableProxy[] suppressed = proxy.getSuppressed();
        if (Objects.isNull(suppressed)) {
            return null;
        }

        IThrowableProxy[] suppressedAndMarked = new IThrowableProxy[suppressed.length];
        for (int i = 0; i < suppressed.length; i++) {
            suppressedAndMarked[i] = new SanitisedThrowableProxy(suppressed[i]);
        }

        return suppressedAndMarked;
    }
}
