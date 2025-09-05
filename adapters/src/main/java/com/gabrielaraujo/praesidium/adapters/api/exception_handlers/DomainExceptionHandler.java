package com.gabrielaraujo.praesidium.adapters.api.exception_handlers;

import com.gabrielaraujo.praesidium.core.entities.StandardResponseEntity;
import com.gabrielaraujo.praesidium.core.entities.exceptions.DomainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class DomainExceptionHandler {
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<StandardResponseEntity> handle(DomainException exception) {
        var body = StandardResponseEntity.builder()
                .message("Validation error!")
                .errors(List.of(exception.getMessage()))
                .statusCode(400)
                .build();

        return ResponseEntity.badRequest()
                .body(body);
    }
}
