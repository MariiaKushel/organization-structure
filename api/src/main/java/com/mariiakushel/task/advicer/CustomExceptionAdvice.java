package com.mariiakushel.task.advicer;

import com.mariiakushel.task.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

/**
 * Class represent spring advice to catch exceptions and wrap them into custom ExceptionResponse.
 */
@RestControllerAdvice
public class CustomExceptionAdvice {
    /**
     * Method catches CustomException and generates response entity.
     *
     * @param e - CustomException
     * @return - response entity consist body - ExceptionResponse and HttpStatus
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleCustomException(CustomException e) {
        HttpStatus httpStatus = e.getErrorCode() != null ? e.getErrorCode() : HttpStatus.INTERNAL_SERVER_ERROR;
        String errorCode = httpStatus.toString();
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, errorCode);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    /**
     * Method catches Exception and generates response entity.
     *
     * @param e - Exception
     * @return - response entity consist body - ExceptionResponse and HttpStatus
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleInternalServerException(Exception e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        String errorCode = httpStatus.toString();
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, errorCode);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    /**
     * Method catches HttpRequestMethodNotSupportedException and generates response entity.
     *
     * @param e - HttpRequestMethodNotSupportedException
     * @return - response entity consist body - ExceptionResponse and HttpStatus
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        HttpStatus httpStatus = HttpStatus.METHOD_NOT_ALLOWED;
        String errorCode = httpStatus.toString();
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, errorCode);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    /**
     * Method catches MethodArgumentTypeMismatchException and generates response entity.
     *
     * @param e - MethodArgumentTypeMismatchException
     * @return - response entity consist body - ExceptionResponse and HttpStatus
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String errorCode = httpStatus.toString();
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, errorCode);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    /**
     * Method catches HttpMessageNotReadableException and generates response entity.
     *
     * @param e - HttpMessageNotReadableException
     * @return - response entity consist body - ExceptionResponse and HttpStatus
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String errorCode = httpStatus.toString();
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, errorCode);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    /**
     * Method catches HttpMediaTypeNotSupportedException and generates response entity.
     *
     * @param e - HttpMediaTypeNotSupportedException
     * @return - response entity consist body - ExceptionResponse and HttpStatus
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadableException(
            HttpMediaTypeNotSupportedException e) {
        HttpStatus httpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        String errorCode = httpStatus.toString();
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, errorCode);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    /**
     * Method catches MissingServletRequestParameterException and generates response entity.
     *
     * @param e - MissingServletRequestParameterException
     * @return - response entity consist body - ExceptionResponse and HttpStatus
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionResponse> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String errorCode = httpStatus.toString();
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, errorCode);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    //    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ExceptionResponse> handleAccessDeniedException(
//            AccessDeniedException e) {
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//
//        HttpStatus httpStatus;
//        try {
//            Jwt jwt = (Jwt) authentication.getPrincipal();
//            httpStatus = HttpStatus.FORBIDDEN;
//        } catch (ClassCastException ex) {
//            httpStatus = HttpStatus.UNAUTHORIZED;
//        }
//        String errorCode = httpStatus.toString();
//        String message = e.getMessage();
//        ExceptionResponse exceptionResponse = new ExceptionResponse(message, errorCode);
//        return new ResponseEntity<>(exceptionResponse, httpStatus);
//    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleConstraintViolationException(
            ConstraintViolationException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String errorCode = httpStatus.toString();
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, errorCode);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }
}
