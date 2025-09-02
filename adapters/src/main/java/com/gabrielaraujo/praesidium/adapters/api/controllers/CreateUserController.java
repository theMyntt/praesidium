package com.gabrielaraujo.praesidium.adapters.api.controllers;

import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.CreateUserUseCase;
import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io.CreateUserUseCaseInput;
import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io.CreateUserUseCaseOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class CreateUserController {
    private final CreateUserUseCase useCase;

    @PostMapping("v1/register")
    public ResponseEntity<CreateUserUseCaseOutput> performV1(
            @RequestBody @Valid CreateUserUseCaseInput input) {
        var result = useCase.execute(input);

        return ResponseEntity.status(result.getStatusCode())
                .body(result);
    }
}
