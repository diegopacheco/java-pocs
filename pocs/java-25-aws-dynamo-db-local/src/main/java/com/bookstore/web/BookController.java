package com.bookstore.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.TransactionService;
import com.bookstore.web.dto.BatchPagesRequest;
import com.bookstore.web.dto.CreateBookRequest;
import com.bookstore.web.dto.CursorPage;
import com.bookstore.web.dto.PageUpdate;
import com.bookstore.web.dto.UpdatePagesRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Books")
public class BookController {

    private final BookService bookService;
    private final TransactionService transactionService;

    public BookController(BookService bookService, TransactionService transactionService) {
        this.bookService = bookService;
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a book")
    public Book create(@RequestBody CreateBookRequest request) {
        return bookService.create(request);
    }

    @GetMapping
    @Operation(summary = "List books using DynamoDB cursor pagination (size defaults to 2; pass nextToken to page forward)")
    public CursorPage<Book> list(
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(required = false) String nextToken) {
        return bookService.list(size, nextToken);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a book by id")
    public Book get(@PathVariable String id) {
        return bookService.get(id);
    }

    @PatchMapping("/{id}/pages")
    @Operation(summary = "Track how many pages have been read in a book")
    public Book updatePages(@PathVariable String id, @RequestBody UpdatePagesRequest request) {
        return bookService.updatePagesRead(id, request.pagesRead());
    }

    @PostMapping("/batch-pages")
    @Operation(summary = "Atomically update pagesRead for multiple books in a single DynamoDB transaction")
    public List<Book> batchUpdatePages(@RequestBody BatchPagesRequest request) {
        transactionService.batchUpdatePages(request.updates());
        return request.updates().stream().map(PageUpdate::id).map(bookService::get).toList();
    }
}
