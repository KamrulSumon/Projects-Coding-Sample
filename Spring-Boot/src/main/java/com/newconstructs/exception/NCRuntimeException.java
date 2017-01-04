package com.newconstructs.exception;

import org.slf4j.Logger;

import java.text.MessageFormat;


public class NCRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NCRuntimeException(NCException nce) {
        super(nce);
    }

    protected NCRuntimeException(String message) {
        this((Throwable) null, message, (Object[]) null);
    }

    protected NCRuntimeException(Throwable cause) {
        this(cause, cause.getMessage());
    }

    protected NCRuntimeException(String message, Object... messageParameters) {
        this((Throwable) null, message, messageParameters);
    }

    protected NCRuntimeException(Throwable cause, String message) {
        this(cause, message, (Object[]) null);
    }

    protected NCRuntimeException(Throwable cause, String message, Object... messageParameters) {
        super((message == null) ? null : (messageParameters == null) ? message : MessageFormat.format(message, messageParameters), cause);
    }

    public NCRuntimeException(Logger logger, Throwable cause) {
        this(logger, cause, null, (Object[]) null);
    }

    public NCRuntimeException(Logger logger, String message) {
        this(logger, null, message, (Object[]) null);
    }

    public NCRuntimeException(Logger logger, String message, Object... messageParameters) {
        this(logger, null, message, messageParameters);
    }

    public NCRuntimeException(Logger logger, Throwable cause, String message) {
        this(logger, cause, message, (Object[]) null);
    }

    public NCRuntimeException(Logger logger, Throwable cause, String message, Object... messageParameters) {
        super(message = (message == null) ? null : (messageParameters == null) ? message : MessageFormat.format(message, messageParameters), cause);

        cause = (cause == null) ? this : cause;

        logger.error(message, cause);
    }
}

