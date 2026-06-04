package com.github.diegopacheco.bookstore.service;

import com.github.diegopacheco.bookstore.dao.BookRepository;
import com.github.diegopacheco.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public Book save(Long id, Book book) {
        book.setId(id);
        book.markNew(!repository.existsById(id));
        return repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
