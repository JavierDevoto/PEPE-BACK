package com.ecommerce.core.exceptions;

import lombok.Getter;

@Getter
public class InvalidParametersException extends UseCaseException {

    private final transient Object businessCause;

    public InvalidParametersException(String message) {
        super(message);
        businessCause = null;
    }

    public InvalidParametersException(String message, Throwable throwable) {
        super(message, throwable);
        businessCause = null;
    }

    public InvalidParametersException(String message, Object businessCause) {
        super(message);
        this.businessCause = businessCause;
    }
}
