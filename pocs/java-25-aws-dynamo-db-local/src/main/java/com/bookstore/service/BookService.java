package com.bookstore.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bookstore.error.NotFoundException;
import com.bookstore.error.ValidationException;
import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.web.dto.CreateBookRequest;
import com.bookstore.web.dto.CursorPage;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book create(CreateBookRequest request) {
        if (request.title() == null || request.title().isBlank()) {
            throw new ValidationException("title is required");
        }
        if (request.totalPages() <= 0) {
            throw new ValidationException("totalPages must be greater than zero");
        }
        Book book = new Book(UUID.randomUUID().toString(), request.title(), request.author(), request.totalPages(), 0);
        repository.insert(book);
        log.info("created book id={} title={}", book.id(), book.title());
        return book;
    }

    public CursorPage<Book> list(int size, String nextToken) {
        if (size < 1) {
            throw new ValidationException("size must be >= 1");
        }
        BookRepository.Page page = repository.scan(size, nextToken);
        return new CursorPage<>(size, page.items().size(), page.nextToken(), page.items());
    }

    public Book get(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("book not found: " + id));
    }

    public Book updatePagesRead(String id, int pagesRead) {
        Book book = get(id);
        if (pagesRead < 0 || pagesRead > book.totalPages()) {
            throw new ValidationException("pagesRead must be between 0 and " + book.totalPages());
        }
        repository.updatePages(id, pagesRead);
        log.info("updated pagesRead id={} pagesRead={}", id, pagesRead);
        return new Book(book.id(), book.title(), book.author(), book.totalPages(), pagesRead);
    }
}
