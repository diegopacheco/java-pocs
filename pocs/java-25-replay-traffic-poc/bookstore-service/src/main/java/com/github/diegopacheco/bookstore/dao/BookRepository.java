package com.github.diegopacheco.bookstore.dao;

import com.github.diegopacheco.bookstore.model.Book;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ListCrudRepository<Book, Long> {
}
