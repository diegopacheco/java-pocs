package com.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.bookstore.error.NotFoundException;
import com.bookstore.error.ValidationException;
import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.web.dto.CreateBookRequest;

class BookServiceTest {

    private final BookRepository repository = mock(BookRepository.class);
    private final BookService service = new BookService(repository);

    @Test
    void createStartsPagesReadAtZeroAndPersists() {
        Book created = service.create(new CreateBookRequest("Dune", "Herbert", 412));
        assertEquals(0, created.pagesRead(), "a new book has been read zero pages");
        assertEquals(412, created.totalPages());
        verify(repository).insert(any(Book.class));
    }

    @Test
    void createRejectsBlankTitle() {
        assertThrows(ValidationException.class, () -> service.create(new CreateBookRequest("  ", "x", 10)),
                "a book without a title is not a usable catalog entry");
    }

    @Test
    void createRejectsNonPositiveTotalPages() {
        assertThrows(ValidationException.class, () -> service.create(new CreateBookRequest("t", "a", 0)),
                "totalPages bounds the pages-read tracking, so it must be positive");
    }

    @Test
    void getThrowsNotFoundWhenMissing() {
        when(repository.findById("nope")).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.get("nope"));
    }

    @Test
    void updatePagesReadRejectsValueBeyondTotalPages() {
        when(repository.findById("id1")).thenReturn(Optional.of(new Book("id1", "t", "a", 100, 0)));
        assertThrows(ValidationException.class, () -> service.updatePagesRead("id1", 101),
                "you cannot have read more pages than the book has");
    }

    @Test
    void updatePagesReadPersistsValidProgress() {
        when(repository.findById("id1")).thenReturn(Optional.of(new Book("id1", "t", "a", 100, 0)));
        Book updated = service.updatePagesRead("id1", 40);
        assertEquals(40, updated.pagesRead());
        verify(repository).updatePages(eq("id1"), eq(40));
    }
}
