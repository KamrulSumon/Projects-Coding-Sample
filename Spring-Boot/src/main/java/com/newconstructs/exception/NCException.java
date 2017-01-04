package com.newconstructs.exception;

import org.slf4j.Logger;

import java.text.MessageFormat;

public class NCException extends Exception {
    private static final long serialVersionUID = 1L;

    protected NCException(String message) {
        this((Throwable) null, message, (Object[]) null);
    }

    protected NCException(Throwable cause) {
        this(cause, cause.getMessage());
    }

    protected NCException(String message, Object... messageParameters) {
        this((Throwable) null, message, messageParameters);
    }

    protected NCException(Throwable cause, String message) {
        this(cause, message, (Object[]) null);
    }

    protected NCException(Throwable cause, String message, Object... messageParameters) {
        super((message == null) ? null : (messageParameters == null) ? message : MessageFormat.format(message, messageParameters), cause);
    }

    public NCException(Logger logger, Throwable cause) {
        this(logger, cause, null, (Object[]) null);
    }

    public NCException(Logger logger, String message) {
        this(logger, null, message, (Object[]) null);
    }

    public NCException(Logger logger, String message, Object... messageParameters) {
        this(logger, null, message, messageParameters);
    }

    public NCException(Logger logger, Throwable cause, String message) {
        this(logger, cause, message, (Object[]) null);
    }

    public NCException(Logger logger, Throwable cause, String message, Object... messageParameters) {
        super(message = (message == null) ? null : (messageParameters == null) ? message : MessageFormat.format(message, messageParameters), cause);

        logger.error(message, cause);
    }
}

