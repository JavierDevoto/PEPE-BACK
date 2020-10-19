package com.ecommerce.core.exceptions;

public class RepositoryException extends RuntimeException {

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
