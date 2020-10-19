package com.ecommerce.core.exceptions;

public class UseCaseException extends RuntimeException {

    public UseCaseException(String message) {
        super(message);
    }
    
    public UseCaseException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
