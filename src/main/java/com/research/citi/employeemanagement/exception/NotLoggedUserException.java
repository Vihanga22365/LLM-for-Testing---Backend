package com.research.citi.employeemanagement.exception;

public class NotLoggedUserException extends Exception{
    public NotLoggedUserException() {
        super();
    }

    public NotLoggedUserException(String message) {
        super(message);
    }

    public NotLoggedUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLoggedUserException(Throwable cause) {
        super(cause);
    }

    protected NotLoggedUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
