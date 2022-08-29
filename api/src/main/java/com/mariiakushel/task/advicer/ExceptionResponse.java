package com.mariiakushel.task.advicer;

import org.springframework.http.HttpStatus;

/**
 * Class represents the body of exception response.
 */
public class ExceptionResponse {

    private String errorMessage;
    private String errorCode;

    public ExceptionResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
