package com.newconstructs.exception;

import org.slf4j.Logger;


public class NCWebException extends NCRuntimeException {
    private static final long serialVersionUID = 1L;

    public NCWebException(String message) {
        super(message);
    }

    public NCWebException(Throwable cause) {
        super(cause);
    }

    public NCWebException(String message, Object... messageParameters) {
        super(message, messageParameters);
    }

    public NCWebException(Throwable cause, String message) {
        super(cause, message, (Object[]) null);
    }

    public NCWebException(Throwable cause, String message, Object... messageParameters) {
        super(cause, message, messageParameters);
    }

    public NCWebException(Logger logger, Throwable cause) {
        this(logger, cause, null, (Object[]) null);
    }

    public NCWebException(Logger logger, String message) {
        this(logger, null, message, (Object[]) null);
    }

    public NCWebException(Logger logger, String message, Object... messageParameters) {
        this(logger, null, message, messageParameters);
    }

    public NCWebException(Logger logger, Throwable cause, String message) {
        this(logger, cause, message, (Object[]) null);
    }

    public NCWebException(Logger logger, Throwable cause, String message, Object... messageParameters) {
        super(logger, cause, message, messageParameters);
    }
}