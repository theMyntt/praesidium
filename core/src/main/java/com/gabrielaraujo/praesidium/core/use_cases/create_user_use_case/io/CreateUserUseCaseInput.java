package com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
public class CreateUserUseCaseInput {
    @NotNull
    @NotBlank
    private String name;

    @Email(message = "Invalid e-mail")
    @NotNull(message = "E-mail can't be null")
    @NotBlank(message = "E-mail can't be blank")
    private String email;

    @NotNull(message = "Password can't be null")
    @NotBlank(message = "Password can't be blank")
    @Length(min = 10, message = "Password too small")
    private String password;

    @NotNull(message = "User needs to be 1 role")
    private List<String> roles;
}
