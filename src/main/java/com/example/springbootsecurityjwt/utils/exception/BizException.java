package com.example.springbootsecurityjwt.utils.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BizException extends RuntimeException {

    private final String message;
    private HttpStatus httpStatus;

    public BizException(String message) {
        this.message = message;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public BizException(String message, HttpStatus httpStatus) {
        this(message);
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
