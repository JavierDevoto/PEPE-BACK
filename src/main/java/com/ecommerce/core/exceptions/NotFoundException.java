package com.ecommerce.core.exceptions;

public class NotFoundException extends UseCaseException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
