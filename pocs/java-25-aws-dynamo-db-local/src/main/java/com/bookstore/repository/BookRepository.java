package com.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookstore.config.DynamoProperties;
import com.bookstore.model.Book;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;
import software.amazon.awssdk.services.dynamodb.model.ParameterizedStatement;

@Repository
public class BookRepository {

    private static final RowMapper<Book> BOOK_MAPPER = (rs, rowNum) -> new Book(
            rs.getString("id"),
            rs.getString("title"),
            rs.getString("author"),
            (int) rs.getDouble("totalPages"),
            (int) rs.getDouble("pagesRead"));

    private final JdbcTemplate jdbc;
    private final DynamoDbClient client;
    private final String table;

    public BookRepository(JdbcTemplate jdbc, DynamoDbClient client, DynamoProperties props) {
        this.jdbc = jdbc;
        this.client = client;
        this.table = props.table();
    }

    public void insert(Book book) {
        ParameterizedStatement statement = ParameterizedStatement.builder()
                .statement("INSERT INTO \"" + table + "\" VALUE {'id':?, 'title':?, 'author':?, 'totalPages':?, 'pagesRead':?}")
                .parameters(
                        AttributeValue.fromS(book.id()),
                        AttributeValue.fromS(book.title()),
                        AttributeValue.fromS(book.author()),
                        AttributeValue.fromN(Integer.toString(book.totalPages())),
                        AttributeValue.fromN(Integer.toString(book.pagesRead())))
                .build();
        client.executeTransaction(ExecuteTransactionRequest.builder().transactStatements(statement).build());
    }

    public void updatePages(String id, int pagesRead) {
        ParameterizedStatement statement = ParameterizedStatement.builder()
                .statement("UPDATE \"" + table + "\" SET pagesRead = ? WHERE id = ? AND totalPages >= ?")
                .parameters(
                        AttributeValue.fromN(Integer.toString(pagesRead)),
                        AttributeValue.fromS(id),
                        AttributeValue.fromN(Integer.toString(pagesRead)))
                .build();
        client.executeTransaction(ExecuteTransactionRequest.builder().transactStatements(statement).build());
    }

    public List<Book> findAll() {
        return jdbc.query("SELECT id, title, author, totalPages, pagesRead FROM \"" + table + "\"", BOOK_MAPPER);
    }

    public Optional<Book> findById(String id) {
        return jdbc.query("SELECT id, title, author, totalPages, pagesRead FROM \"" + table + "\" WHERE id = ?",
                BOOK_MAPPER, id).stream().findFirst();
    }
}
