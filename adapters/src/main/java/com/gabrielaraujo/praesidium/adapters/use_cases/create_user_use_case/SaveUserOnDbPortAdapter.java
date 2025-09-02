package com.gabrielaraujo.praesidium.adapters.use_cases.create_user_use_case;

import com.gabrielaraujo.praesidium.adapters.dao.tables.mappers.UserTableRowMapper;
import com.gabrielaraujo.praesidium.core.use_cases.create_user_use_case.implementations.ports.SaveUserOnDbPort;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Service
public class SaveUserOnDbPortAdapter implements SaveUserOnDbPort {
    private final DynamoDbTemplate client;

    public SaveUserOnDbPortAdapter(DynamoDbClient dynamoDbClient) {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();

        this.client = new DynamoDbTemplate(enhancedClient);
    }

    @Override
    public SaveUserOnDbPortOutput execute(SaveUserOnDbPortInput input) {
        var user = UserTableRowMapper.toPersistence(input.getUser());

        user = client.save(user);

        return SaveUserOnDbPortOutput.builder()
                .id(user.getId())
                .build();
    }
}
