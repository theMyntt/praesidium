package com.gabrielaraujo.praesidium.core.entities.value_objects;

import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
public class PasswordValueObject {
    private final String value;

    private final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder(24);

    public PasswordValueObject(String value) {
        this(value, true);
    }

    public PasswordValueObject(String value, Boolean isToEncrypt) {
        if (!isToEncrypt) {
            this.value = value;
            return;
        }

        if (value == null || value.isEmpty()) throw new IllegalArgumentException("Password cant be blank");
        value = value.trim();

        this.value = ENCODER.encode(value);
    }

    public Boolean compare(String rawPassword) {
        if (rawPassword == null || rawPassword.isEmpty()) throw new IllegalArgumentException("Plain Password cant be blank");
        if (this.value == null || value.isEmpty()) throw new IllegalArgumentException("Password cant be blank");

        return ENCODER.matches(rawPassword, this.value);
    }

}
