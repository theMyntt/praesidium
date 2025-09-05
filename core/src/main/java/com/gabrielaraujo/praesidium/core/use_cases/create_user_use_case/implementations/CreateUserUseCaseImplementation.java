package com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.implementations;

import com.gabrielaraujo.praesidium.core.entities.UserEntity;
import com.gabrielaraujo.praesidium.core.entities.enums.RolesEnum;
import com.gabrielaraujo.praesidium.core.entities.value_objects.EmailValueObject;
import com.gabrielaraujo.praesidium.core.entities.value_objects.PasswordValueObject;
import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.CreateUserUseCase;
import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.implementations.ports.SaveUserOnDbPort;
import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io.CreateUserUseCaseInput;
import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io.CreateUserUseCaseOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImplementation extends CreateUserUseCase {
    private final SaveUserOnDbPort port;

    @Override
    public CreateUserUseCaseOutput execute(CreateUserUseCaseInput input) {
        return applyInternalLogic(input);
    }

    @Override
    protected CreateUserUseCaseOutput applyInternalLogic(CreateUserUseCaseInput input) {
        var email = new EmailValueObject(input.getEmail());
        var password = new PasswordValueObject(input.getPassword());
        var user = new UserEntity(
                UUID.randomUUID(),
                input.getName(),
                email,
                password,
                false,
                false,
                null,
                input.getRoles().stream()
                        .map(RolesEnum::valueOf)
                        .toList()
        );

        var portInput = SaveUserOnDbPort.SaveUserOnDbPortInput.builder()
                .user(user)
                .build();

        var portOutput = port.execute(portInput);

        return CreateUserUseCaseOutput.builder()
                .message("Created.")
                .id(portOutput.getId().toString())
                .statusCode(201)
                .isError(false)
                .build();
    }
}
