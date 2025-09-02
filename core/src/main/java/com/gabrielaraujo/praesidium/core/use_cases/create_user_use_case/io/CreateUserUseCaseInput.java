package com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateUserUseCaseInput {
    private String name;
    private String email;
    private String password;
    private List<String> roles;
}
