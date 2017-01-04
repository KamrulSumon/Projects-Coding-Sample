package com.newconstructs.exception;

import org.slf4j.Logger;


public class NCPersistenceException extends NCRuntimeException {
    private static final long serialVersionUID = 1L;

    public NCPersistenceException(NCException nce) {
        super(nce);
    }

    public NCPersistenceException(Logger logger, Throwable cause) {
        super(logger, cause);
    }

    public NCPersistenceException(Logger logger, String message) {
        super(logger, message);
    }

    public NCPersistenceException(Logger logger, String message, Object... messageParameters) {
        super(logger, message, messageParameters);
    }

    public NCPersistenceException(Logger logger, Throwable cause, String message) {
        super(logger, cause, message);
    }

    public NCPersistenceException(Logger logger, Throwable cause, String message, Object... messageParameters) {
        super(logger, cause, message, messageParameters);
    }
}

