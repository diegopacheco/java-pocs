package com.bookstore.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bookstore.config.DynamoProperties;
import com.bookstore.error.ValidationException;
import com.bookstore.web.dto.PageUpdate;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;
import software.amazon.awssdk.services.dynamodb.model.ParameterizedStatement;

@Service
public class TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);

    private final DynamoDbClient client;
    private final String table;

    public TransactionService(DynamoDbClient client, DynamoProperties props) {
        this.client = client;
        this.table = props.table();
    }

    public void batchUpdatePages(List<PageUpdate> updates) {
        if (updates == null || updates.isEmpty()) {
            throw new ValidationException("updates must not be empty");
        }
        List<ParameterizedStatement> statements = updates.stream().map(this::toStatement).toList();
        client.executeTransaction(ExecuteTransactionRequest.builder().transactStatements(statements).build());
        log.info("committed transaction for {} page updates", updates.size());
    }

    private ParameterizedStatement toStatement(PageUpdate update) {
        if (update.pagesRead() < 0) {
            throw new ValidationException("pagesRead must not be negative for id " + update.id());
        }
        return ParameterizedStatement.builder()
                .statement("UPDATE \"" + table + "\" SET pagesRead = ? WHERE id = ? AND totalPages >= ?")
                .parameters(
                        AttributeValue.fromN(Integer.toString(update.pagesRead())),
                        AttributeValue.fromS(update.id()),
                        AttributeValue.fromN(Integer.toString(update.pagesRead())))
                .build();
    }
}
