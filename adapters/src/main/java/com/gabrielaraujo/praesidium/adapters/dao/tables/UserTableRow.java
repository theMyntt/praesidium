package com.gabrielaraujo.praesidium.adapters.dao.tables;

import com.gabrielaraujo.praesidium.adapters.dao.resolvers.DynamoDbTableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@DynamoDbBean
@DynamoDbTableName(name = "users")
public class UserTableRow {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Boolean isBlocked;
    private Boolean isSuspended;
    private OffsetDateTime timeSuspended;
    private List<String> roles;

    @DynamoDbPartitionKey
    public UUID getId() {
        return this.id;
    }
}
