package com.gabrielaraujo.praesidium.adapters.dao.repositories;

import com.gabrielaraujo.praesidium.adapters.dao.tables.UserTableRow;
import com.gabrielaraujo.praesidium.adapters.dao.tables.mappers.UserTableRowMapper;
import com.gabrielaraujo.praesidium.core.entities.UserEntity;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final DynamoDbEnhancedClient dbEnhancedClient;
    private DynamoDbTable<UserTableRow> userTable;

    @PostConstruct
    public void init() {
        userTable = dbEnhancedClient.table("users", TableSchema.fromBean(UserTableRow.class));
    }

    public UserTableRow save(UserTableRow user) {
        userTable.putItem(user);

        return user;
    }
}
