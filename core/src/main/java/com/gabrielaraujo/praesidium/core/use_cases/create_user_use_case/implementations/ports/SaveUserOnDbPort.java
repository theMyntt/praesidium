package com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.implementations.ports;

import com.gabrielaraujo.praesidium.core.entities.UserEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

public interface SaveUserOnDbPort {
    SaveUserOnDbPortOutput execute(SaveUserOnDbPortInput input);

    @Builder
    @Getter
    class SaveUserOnDbPortInput {
        private UserEntity user;
    }

    @Builder
    @Getter
    class SaveUserOnDbPortOutput {
        private UUID id;
    }
}
