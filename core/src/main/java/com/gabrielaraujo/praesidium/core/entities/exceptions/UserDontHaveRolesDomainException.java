package com.gabrielaraujo.praesidium.core.entities.exceptions;

public class UserDontHaveRolesDomainException extends DomainException {
    public UserDontHaveRolesDomainException() {
        super("User don't have any role");
    }
}
