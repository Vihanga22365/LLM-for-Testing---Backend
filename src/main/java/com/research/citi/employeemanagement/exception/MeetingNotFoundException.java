package com.research.citi.employeemanagement.exception;

public class MeetingNotFoundException extends Exception{
    public MeetingNotFoundException() {
        super();
    }

    public MeetingNotFoundException(String message) {
        super(message);
    }

    public MeetingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetingNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MeetingNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
