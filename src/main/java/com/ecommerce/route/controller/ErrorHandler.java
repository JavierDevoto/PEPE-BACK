package com.ecommerce.route.controller;

import com.ecommerce.core.exceptions.InvalidParametersException;
import com.ecommerce.core.exceptions.NotFoundException;
import com.ecommerce.core.exceptions.UseCaseException;
import com.ecommerce.route.controller.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.util.Objects.nonNull;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { NotFoundException.class })
    protected ResponseEntity<Object> handleConflict(NotFoundException ex, WebRequest request) {
        return respondWith(ex, request, ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { InvalidParametersException.class })
    protected ResponseEntity<Object> handleConflict(InvalidParametersException ex, WebRequest request) {
        return respondWith(ex, request, ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getBusinessCause());
    }

    @ExceptionHandler(value = { UseCaseException.class })
    protected ResponseEntity<Object> handleConflict(UseCaseException ex, WebRequest request) {
        return respondWith(ex, request, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return respondWith(ex, request, ex.getClass().getName() + ": " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, nonNull(ex.getCause()) ? ex.getCause().getMessage() : null, ex.getStackTrace());
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        return respondWith(ex, request, ex.getClass().getName() + ": " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, nonNull(ex.getCause()) ? ex.getCause().getMessage() : null, ex.getStackTrace());
    }

    private ResponseEntity<Object> respondWith(Exception ex, WebRequest request, String message, HttpStatus statusCode) {
        return respondWith(ex, request, message, statusCode, null);
    }

    private ResponseEntity<Object> respondWith(Exception ex, WebRequest request, String message, HttpStatus statusCode, Object cause) {
        return respondWith(ex, request, message, statusCode, cause, null);
    }

    private ResponseEntity<Object> respondWith(Exception ex, WebRequest request, String message, HttpStatus statusCode, Object cause, Object stacktrace) {
        ErrorResponse errorResponse = new ErrorResponse()
                .setMessage(message)
                .setCode(statusCode)
                .setCause(cause)
                .setStacktrace(stacktrace);

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), statusCode, request);
    }
}
