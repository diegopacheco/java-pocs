package com.bookstore.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bookstore.config.DynamoProperties;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.BillingMode;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.services.dynamodb.model.TableStatus;

@Component
public class TableInitializer {

    private static final Logger log = LoggerFactory.getLogger(TableInitializer.class);

    private final DynamoDbClient client;
    private final DynamoProperties props;

    public TableInitializer(DynamoDbClient client, DynamoProperties props) {
        this.client = client;
        this.props = props;
    }

    @Order(1)
    @EventListener(ApplicationReadyEvent.class)
    public void createTableIfMissing() {
        String table = props.table();
        try {
            client.describeTable(b -> b.tableName(table));
            log.info("DynamoDB table '{}' already exists", table);
        } catch (ResourceNotFoundException notFound) {
            log.info("DynamoDB table '{}' not found, creating it", table);
            client.createTable(b -> b.tableName(table)
                    .keySchema(KeySchemaElement.builder().attributeName("id").keyType(KeyType.HASH).build())
                    .attributeDefinitions(AttributeDefinition.builder().attributeName("id")
                            .attributeType(ScalarAttributeType.S).build())
                    .billingMode(BillingMode.PAY_PER_REQUEST));
            waitUntilActive(table);
            log.info("DynamoDB table '{}' created and active", table);
        } catch (Exception e) {
            log.error("DynamoDB is not reachable at {}: {}", props.endpoint(), e.getMessage());
        }
    }

    private void waitUntilActive(String table) {
        for (int i = 0; i < 30; i++) {
            if (client.describeTable(b -> b.tableName(table)).table().tableStatus() == TableStatus.ACTIVE) {
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
