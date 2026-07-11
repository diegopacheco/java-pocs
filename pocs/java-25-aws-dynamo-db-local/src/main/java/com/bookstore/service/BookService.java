package com.bookstore.service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bookstore.error.NotFoundException;
import com.bookstore.error.ValidationException;
import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.web.dto.CreateBookRequest;
import com.bookstore.web.dto.PageResponse;

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

    public PageResponse<Book> list(int page, int size) {
        if (page < 0 || size < 1) {
            throw new ValidationException("page must be >= 0 and size must be >= 1");
        }
        List<Book> all = repository.findAll().stream()
                .sorted(Comparator.comparing(Book::title))
                .toList();
        long total = all.size();
        int totalPages = (int) Math.ceil((double) total / size);
        List<Book> content = all.stream().skip((long) page * size).limit(size).toList();
        return new PageResponse<>(page, size, total, totalPages, content);
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
