package com.mariiakushel.task.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class. It includes additional field - errorCode for more information.
 */
public class CustomException extends Exception {
    private HttpStatus errorCode;

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Exception cause) {
        super(message, cause);
    }

    public CustomException(Exception cause) {
        super(cause);
    }

    public CustomException(String message, HttpStatus errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }
}
