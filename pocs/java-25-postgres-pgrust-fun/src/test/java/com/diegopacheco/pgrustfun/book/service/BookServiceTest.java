package com.diegopacheco.pgrustfun.book.service;

import com.diegopacheco.pgrustfun.book.domain.Book;
import com.diegopacheco.pgrustfun.book.domain.BookPage;
import com.diegopacheco.pgrustfun.book.domain.CreateBookRequest;
import com.diegopacheco.pgrustfun.book.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookServiceTest {

    @Test
    void returnsBooksFromRepository() {
        StubBookRepository repository = new StubBookRepository();
        repository.save(new CreateBookRequest("Clean Architecture", "Robert C. Martin", "9780134494166", 2017));

        BookService service = new BookService(repository);

        BookPage result = service.findAll(0, 10);

        assertEquals(1, result.content().size());
        assertEquals("Clean Architecture", result.content().getFirst().title());
        assertEquals(1, result.totalElements());
        assertEquals(1, result.totalPages());
    }

    @Test
    void createsBookWhenRequestIsValid() {
        StubBookRepository repository = new StubBookRepository();
        BookService service = new BookService(repository);

        Book result = service.create(new CreateBookRequest("Building Microservices", "Sam Newman", "9781492034025", 2021));

        assertEquals(1L, result.id());
        assertEquals("Building Microservices", result.title());
    }

    @Test
    void rejectsBlankTitle() {
        StubBookRepository repository = new StubBookRepository();
        BookService service = new BookService(repository);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> service.create(new CreateBookRequest(" ", "Author", "9781491950357", 2020)));

        assertEquals(400, exception.getStatusCode().value());
        assertEquals("title is required", exception.getReason());
    }

    @Test
    void rejectsNegativePage() {
        StubBookRepository repository = new StubBookRepository();
        BookService service = new BookService(repository);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> service.findAll(-1, 10));

        assertEquals(400, exception.getStatusCode().value());
        assertEquals("page must be greater than or equal to 0", exception.getReason());
    }

    @Test
    void returnsRequestedPage() {
        StubBookRepository repository = new StubBookRepository();
        repository.save(new CreateBookRequest("Book 1", "Author 1", "9780000000001", 2001));
        repository.save(new CreateBookRequest("Book 2", "Author 2", "9780000000002", 2002));
        repository.save(new CreateBookRequest("Book 3", "Author 3", "9780000000003", 2003));

        BookService service = new BookService(repository);

        BookPage result = service.findAll(1, 2);

        assertEquals(1, result.content().size());
        assertEquals("Book 3", result.content().getFirst().title());
        assertEquals(3, result.totalElements());
        assertEquals(2, result.totalPages());
    }

    private static final class StubBookRepository implements BookRepository {

        private final List<Book> books = new ArrayList<>();
        private long nextId = 1L;

        @Override
        public List<Book> findPage(int page, int size) {
            int fromIndex = Math.min(page * size, books.size());
            int toIndex = Math.min(fromIndex + size, books.size());
            return List.copyOf(books.subList(fromIndex, toIndex));
        }

        @Override
        public long count() {
            return books.size();
        }

        @Override
        public Book save(CreateBookRequest request) {
            Book book = new Book(nextId++, request.title(), request.author(), request.isbn(), request.publishedYear());
            books.add(book);
            return book;
        }
    }
}
