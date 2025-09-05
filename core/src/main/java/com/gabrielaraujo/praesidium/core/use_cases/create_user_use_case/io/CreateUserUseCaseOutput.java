package com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserUseCaseOutput {
    private String message;
    private String id;
    private Integer statusCode;
    private Boolean isError;
}
