package com.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookstore.config.DynamoProperties;
import com.bookstore.model.Book;

@Repository
public class BookRepository {

    private static final RowMapper<Book> BOOK_MAPPER = (rs, rowNum) -> new Book(
            rs.getString("id"),
            rs.getString("title"),
            rs.getString("author"),
            (int) rs.getDouble("totalPages"),
            (int) rs.getDouble("pagesRead"));

    private final JdbcTemplate jdbc;
    private final String table;

    public BookRepository(JdbcTemplate jdbc, DynamoProperties props) {
        this.jdbc = jdbc;
        this.table = props.table();
    }

    public void insert(Book book) {
        jdbc.update("INSERT INTO \"" + table + "\" (id, title, author, totalPages, pagesRead) VALUES (?, ?, ?, ?, ?)",
                book.id(), book.title(), book.author(), book.totalPages(), book.pagesRead());
    }

    public List<Book> findAll() {
        return jdbc.query("SELECT id, title, author, totalPages, pagesRead FROM \"" + table + "\"", BOOK_MAPPER);
    }

    public Optional<Book> findById(String id) {
        return jdbc.query("SELECT id, title, author, totalPages, pagesRead FROM \"" + table + "\" WHERE id = ?",
                BOOK_MAPPER, id).stream().findFirst();
    }

    public int updatePages(String id, int pagesRead) {
        return jdbc.update("UPDATE \"" + table + "\" SET pagesRead = ? WHERE id = ?", pagesRead, id);
    }
}
