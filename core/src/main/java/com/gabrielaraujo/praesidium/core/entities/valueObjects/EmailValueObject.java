package com.gabrielaraujo.praesidium.core.entities.valueObjects;

public record EmailValueObject(String value) {
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    public EmailValueObject(String value) {
        if (value == null || !value.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid Email: " + value);
        }

        this.value = value.trim()
                .toLowerCase();
    }
}
