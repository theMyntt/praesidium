package com.gabrielaraujo.praesidium.core.entities.exceptions;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
