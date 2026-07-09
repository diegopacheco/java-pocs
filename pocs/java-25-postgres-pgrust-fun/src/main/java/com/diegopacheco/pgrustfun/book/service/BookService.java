package com.diegopacheco.pgrustfun.book.service;

import com.diegopacheco.pgrustfun.book.domain.Book;
import com.diegopacheco.pgrustfun.book.domain.BookPage;
import com.diegopacheco.pgrustfun.book.domain.CreateBookRequest;
import com.diegopacheco.pgrustfun.book.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookPage findAll(int page, int size) {
        validatePageRequest(page, size);
        List<Book> books = repository.findPage(page, size);
        long totalElements = repository.count();
        int totalPages = totalElements == 0 ? 0 : (int) Math.ceil((double) totalElements / size);
        return new BookPage(books, page, size, totalElements, totalPages);
    }

    public Book create(CreateBookRequest request) {
        validate(request);
        return repository.save(request);
    }

    private void validate(CreateBookRequest request) {
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is required");
        }
        if (!StringUtils.hasText(request.title())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "title is required");
        }
        if (!StringUtils.hasText(request.author())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "author is required");
        }
        if (!StringUtils.hasText(request.isbn())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "isbn is required");
        }
        if (request.publishedYear() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "publishedYear is required");
        }
    }

    private void validatePageRequest(int page, int size) {
        if (page < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "page must be greater than or equal to 0");
        }
        if (size <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "size must be greater than 0");
        }
    }
}
