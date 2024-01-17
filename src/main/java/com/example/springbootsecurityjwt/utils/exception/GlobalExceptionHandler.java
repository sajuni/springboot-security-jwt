package com.example.springbootsecurityjwt.utils.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex, WebRequest request, HttpServletResponse response) {
        // 원하는 형태의 응답 메시지를 작성
        String errorMessage = "테스트중";
        Map<String, String> map = new HashMap<>();
        map.put("message", errorMessage);
        return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AuthenticationException ex, WebRequest request) {
        // 원하는 형태의 응답 메시지를 작성
        String errorMessage = "테스트중22";
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

}
