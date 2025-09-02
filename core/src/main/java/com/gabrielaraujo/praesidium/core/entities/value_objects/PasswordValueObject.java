package com.gabrielaraujo.praesidium.core.entities.value_objects;

import lombok.Getter;
import org.mindrot.jbcrypt.BCrypt;

@Getter
public class PasswordValueObject {
    private final String value;

    public PasswordValueObject(String value) {
        this(value, true);
    }

    public PasswordValueObject(String value, Boolean isToEncrypt) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Password cant be blank");
        }
        value = value.trim();

        if (!isToEncrypt) {
            this.value = value;
            return;
        }

        this.value = BCrypt.hashpw(value, BCrypt.gensalt(12));
    }

    public Boolean compare(String rawPassword) {
        if (rawPassword == null || rawPassword.isEmpty()) {
            throw new IllegalArgumentException("Plain Password cant be blank");
        }
        if (this.value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Password cant be blank");
        }

        return BCrypt.checkpw(rawPassword, this.value);
    }

}
