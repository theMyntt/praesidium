package com.gabrielaraujo.praesidium.adapters.dao.resolvers;

import io.awspring.cloud.dynamodb.DynamoDbTableNameResolver;
import org.springframework.stereotype.Component;

@Component
public class CustomDynamoDbTableNameResolver implements DynamoDbTableNameResolver {
    @Override
    public <T> String resolve(Class<T> clazz) {
        return clazz.getAnnotation(DynamoDbTableName.class).name();
    }
}
