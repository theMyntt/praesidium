package com.gabrielaraujo.praesidium.core.entities.exceptions;

public class TimeToSuspendIsNullDomainException extends DomainException {
    public TimeToSuspendIsNullDomainException() {
        super("Time to suspend a user cant be null");
    }
}
