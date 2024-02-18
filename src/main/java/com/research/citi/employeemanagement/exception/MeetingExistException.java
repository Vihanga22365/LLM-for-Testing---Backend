package com.research.citi.employeemanagement.exception;

public class MeetingExistException extends Exception{
    public MeetingExistException() {
        super();
    }

    public MeetingExistException(String message) {
        super(message);
    }

    public MeetingExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetingExistException(Throwable cause) {
        super(cause);
    }

    protected MeetingExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
