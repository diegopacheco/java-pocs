package com.diegopacheco.pgrustfun.book.web;

import com.diegopacheco.pgrustfun.book.domain.Book;
import com.diegopacheco.pgrustfun.book.domain.BookPage;
import com.diegopacheco.pgrustfun.book.domain.CreateBookRequest;
import com.diegopacheco.pgrustfun.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "List all books")
    public BookPage findAll(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size) {
        return service.findAll(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Insert a new book")
    public Book create(@RequestBody CreateBookRequest request) {
        return service.create(request);
    }
}
