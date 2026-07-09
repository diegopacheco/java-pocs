package com.diegopacheco.pgrustfun.book.repository;

import com.diegopacheco.pgrustfun.book.domain.Book;
import com.diegopacheco.pgrustfun.book.domain.CreateBookRequest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcBookRepository implements BookRepository {

    private static final RowMapper<Book> BOOK_ROW_MAPPER = (resultSet, rowNum) -> new Book(
            resultSet.getLong("id"),
            resultSet.getString("title"),
            resultSet.getString("author"),
            resultSet.getString("isbn"),
            resultSet.getInt("published_year")
    );

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcBookRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> findPage(int page, int size) {
        int offset = page * size;
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("size", size)
                .addValue("offset", offset);
        return jdbcTemplate.query("""
                select id, title, author, isbn, published_year
                from books
                order by id
                limit :size offset :offset
                """, parameters, BOOK_ROW_MAPPER);
    }

    @Override
    public long count() {
        Long total = jdbcTemplate.queryForObject("select count(*) from books", new MapSqlParameterSource(), Long.class);
        return total == null ? 0L : total;
    }

    @Override
    public Book save(CreateBookRequest request) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("title", request.title())
                .addValue("author", request.author())
                .addValue("isbn", request.isbn())
                .addValue("publishedYear", request.publishedYear());
        return jdbcTemplate.queryForObject("""
                insert into books (title, author, isbn, published_year)
                values (:title, :author, :isbn, :publishedYear)
                returning id, title, author, isbn, published_year
                """, parameters, BOOK_ROW_MAPPER);
    }
}
