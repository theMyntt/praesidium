package com.gabrielaraujo.praesidium.core.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StandardResponseEntity {
    private String message;
    private Integer statusCode;
    private List<String> errors;

    public Boolean getIsError() {
        return errors != null && !errors.isEmpty();
    }
}
