package com.ecommerce.route.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Accessors(chain = true)
public class ErrorResponse {
    private String message;
    private HttpStatus code;
    private Object cause;
}
