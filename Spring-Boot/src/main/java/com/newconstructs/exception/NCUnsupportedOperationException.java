package com.newconstructs.exception;

import org.slf4j.Logger;


public class NCUnsupportedOperationException extends NCRuntimeException {
    private static final long serialVersionUID = 1L;

    public NCUnsupportedOperationException(NCException nce) {
        super(nce);
    }

    public NCUnsupportedOperationException(Logger logger, Throwable cause) {
        super(logger, cause);
    }

    public NCUnsupportedOperationException(Logger logger, String message) {
        super(logger, message);
    }

    public NCUnsupportedOperationException(Logger logger, String message, Object... messageParameters) {
        super(logger, message, messageParameters);
    }

    public NCUnsupportedOperationException(Logger logger, Throwable cause, String message) {
        super(logger, cause, message);
    }

    public NCUnsupportedOperationException(Logger logger, Throwable cause, String message, Object... messageParameters) {
        super(logger, cause, message, messageParameters);
    }
}

