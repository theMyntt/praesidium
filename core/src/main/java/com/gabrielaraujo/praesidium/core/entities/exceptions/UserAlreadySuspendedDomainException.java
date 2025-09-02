package com.gabrielaraujo.praesidium.core.entities.exceptions;

public class UserAlreadySuspendedDomainException extends DomainException {
    public UserAlreadySuspendedDomainException() {
        super("User is already suspended");
    }
}
