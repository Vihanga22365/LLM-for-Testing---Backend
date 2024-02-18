package com.research.citi.employeemanagement.exception;

public class LoginNotValidException extends Exception{
    public LoginNotValidException() {
        super();
    }

    public LoginNotValidException(String message) {
        super(message);
    }

    public LoginNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginNotValidException(Throwable cause) {
        super(cause);
    }

    protected LoginNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
