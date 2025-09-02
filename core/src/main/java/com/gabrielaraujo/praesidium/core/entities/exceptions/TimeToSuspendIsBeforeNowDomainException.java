package com.gabrielaraujo.praesidium.core.entities.exceptions;

import java.time.OffsetDateTime;

public class TimeToSuspendIsBeforeNowDomainException extends DomainException {
    public TimeToSuspendIsBeforeNowDomainException() {
        super("Time to suspend cant be before " + OffsetDateTime.now());
    }
}
