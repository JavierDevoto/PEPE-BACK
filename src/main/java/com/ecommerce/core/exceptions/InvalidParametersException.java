package com.ecommerce.core.exceptions;

public class InvalidParametersException extends UseCaseException {

    public InvalidParametersException(String message) {
        super(message);
    }

    public InvalidParametersException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
