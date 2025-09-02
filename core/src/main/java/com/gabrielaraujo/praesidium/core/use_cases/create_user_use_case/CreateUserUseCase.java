package com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case;

import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io.CreateUserUseCaseInput;
import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.io.CreateUserUseCaseOutput;

public abstract class CreateUserUseCase {
    public abstract CreateUserUseCaseOutput execute(CreateUserUseCaseInput input);
    protected abstract CreateUserUseCaseOutput applyInternalLogic(CreateUserUseCaseInput input);
}
