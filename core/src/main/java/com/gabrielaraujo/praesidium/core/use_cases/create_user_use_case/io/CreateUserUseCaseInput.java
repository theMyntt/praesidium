package com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateUserUseCaseInput {
    @NotNull
    @NotBlank
    private String name;

    @Email
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    @Min(12)
    private String password;

    @NotNull
    private List<String> roles;
}
