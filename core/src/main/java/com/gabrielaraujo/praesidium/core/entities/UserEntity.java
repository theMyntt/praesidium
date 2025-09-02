package com.gabrielaraujo.praesidium.core.entities;

import com.gabrielaraujo.praesidium.core.entities.enums.RolesEnum;
import com.gabrielaraujo.praesidium.core.entities.exceptions.*;
import com.gabrielaraujo.praesidium.core.entities.value_objects.EmailValueObject;
import com.gabrielaraujo.praesidium.core.entities.value_objects.PasswordValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
public class UserEntity {
    private final UUID id;

    @Setter(AccessLevel.MODULE)
    private String name;
    private EmailValueObject email;

    @Setter(AccessLevel.MODULE)
    private PasswordValueObject password;
    private Boolean isBlocked;
    private Boolean isSuspended;
    private OffsetDateTime timeSuspended;
    public List<RolesEnum> roles;

    /// Blocks a user. Irreversible action
    public void block() { this.isBlocked = true; }
    public void suspend(OffsetDateTime timeSuspended) {
        if (timeSuspended == null){
            throw new TimeToSuspendIsNullDomainException();
        }
        if (OffsetDateTime.now().isAfter(timeSuspended)) {
            throw new TimeToSuspendIsBeforeNowDomainException();
        }
        if (isSuspended) {
            throw new UserAlreadySuspendedDomainException();
        }
        this.isSuspended = true;
        this.timeSuspended = timeSuspended;
    }
    public void addRole(RolesEnum role) {
        if (this.roles == null) {
            this.roles = List.of(role);
            return;
        }

        this.roles.add(role);
    }
    public void removeRole(RolesEnum role) {
        if (this.roles == null) {
            throw new UserDontHaveRolesDomainException();
        }

        this.roles.remove(role);
    }
    public void updateEmail(EmailValueObject email) {
        if (email == null) {
            throw new EmailCantBeNullDomainException();
        }

        if (email.value() == null || email.value().isEmpty()) {
            throw new EmailCantBeNullDomainException();
        }

        this.email = email;
    }
}
