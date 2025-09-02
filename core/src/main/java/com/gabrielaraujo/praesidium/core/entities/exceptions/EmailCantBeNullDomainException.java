package com.gabrielaraujo.praesidium.core.entities.exceptions;

public class EmailCantBeNullDomainException extends DomainException {
    public EmailCantBeNullDomainException() {
        super("Email can't be null");
    }
}
