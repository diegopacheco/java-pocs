package com.bookstore.health;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

import com.bookstore.config.DynamoProperties;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableResponse;

@Component
public class DynamoDbHealthIndicator implements HealthIndicator {

    private final DynamoDbClient client;
    private final DynamoProperties props;

    public DynamoDbHealthIndicator(DynamoDbClient client, DynamoProperties props) {
        this.client = client;
        this.props = props;
    }

    @Override
    public Health health() {
        try {
            DescribeTableResponse response = client.describeTable(b -> b.tableName(props.table()));
            return Health.up()
                    .withDetail("endpoint", props.endpoint())
                    .withDetail("table", props.table())
                    .withDetail("tableStatus", response.table().tableStatusAsString())
                    .withDetail("itemCount", response.table().itemCount())
                    .build();
        } catch (Exception e) {
            return Health.down()
                    .withDetail("endpoint", props.endpoint())
                    .withDetail("error", e.getMessage())
                    .build();
        }
    }
}
