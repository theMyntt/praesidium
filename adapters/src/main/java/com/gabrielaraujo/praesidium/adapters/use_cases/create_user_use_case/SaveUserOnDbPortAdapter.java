package com.gabrielaraujo.praesidium.adapters.use_cases.create_user_use_case;

import com.gabrielaraujo.praesidium.adapters.dao.repositories.UserRepository;
import com.gabrielaraujo.praesidium.adapters.dao.tables.mappers.UserTableRowMapper;
import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.implementations.ports.SaveUserOnDbPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveUserOnDbPortAdapter implements SaveUserOnDbPort {
    private final UserRepository repository;

    @Override
    public SaveUserOnDbPortOutput execute(SaveUserOnDbPortInput input) {
        var user = UserTableRowMapper.toPersistence(input.getUser());

        user = repository.save(user);

        return SaveUserOnDbPortOutput.builder()
                .id(user.getId())
                .build();
    }
}
