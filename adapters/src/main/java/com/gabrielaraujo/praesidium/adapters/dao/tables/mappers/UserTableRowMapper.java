package com.gabrielaraujo.praesidium.adapters.dao.tables.mappers;

import com.gabrielaraujo.praesidium.adapters.dao.tables.UserTableRow;
import com.gabrielaraujo.praesidium.core.entities.UserEntity;
import com.gabrielaraujo.praesidium.core.entities.enums.RolesEnum;
import com.gabrielaraujo.praesidium.core.entities.value_objects.EmailValueObject;
import com.gabrielaraujo.praesidium.core.entities.value_objects.PasswordValueObject;

public class UserTableRowMapper {
    public static UserTableRow toPersistence(UserEntity user) {
        return UserTableRow.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail().value())
                .password(user.getPassword().getValue())
                .isSuspended(user.getIsSuspended())
                .isBlocked(user.getIsBlocked())
                .timeSuspended(user.getTimeSuspended())
                .roles(user.getRoles().stream()
                        .map(Enum::toString).toList())
                .build();
    }

    public static UserEntity toDomain(UserTableRow user) {
        var password = new PasswordValueObject(user.getPassword(), false);
        var email = new EmailValueObject(user.getEmail());
        var roles = user.getRoles().stream()
                .map(RolesEnum::valueOf).toList();

        return new UserEntity(
                user.getId(),
                user.getName(),
                email,
                password,
                user.getIsBlocked(),
                user.getIsSuspended(),
                user.getTimeSuspended(),
                roles
        );
    }
}
