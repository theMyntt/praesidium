package com.gabrielaraujo.praesidium.adapters.dao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Component
public class DynamoDbConfig {

    @Value("{spring.cloud.aws.dynamodb.url}")
    private String url;

    @Value("{spring.cloud.aws.dynamodb.region}")
    private String region;

    @Value("{spring.cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("{spring.cloud.aws.credentials.secret-key}")
    private String privateKey;

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .endpointOverride(URI.create(url))
                .region(Region.of(region))
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create("dummy", "dummy")
                        )
                )
                .build();
    }
}
