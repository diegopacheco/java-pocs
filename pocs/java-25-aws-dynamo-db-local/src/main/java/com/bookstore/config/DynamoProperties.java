package com.bookstore.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dynamodb")
public record DynamoProperties(String endpoint, String region, String accessKey, String secretKey, String table) {
}
