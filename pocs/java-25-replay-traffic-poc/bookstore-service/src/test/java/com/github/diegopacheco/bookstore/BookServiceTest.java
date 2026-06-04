package com.github.diegopacheco.bookstore;

import com.github.diegopacheco.bookstore.dao.BookRepository;
import com.github.diegopacheco.bookstore.model.Book;
import com.github.diegopacheco.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class BookServiceTest {

    @Test
    void putOnAbsentIdInsertsAsNew() {
        BookRepository repo = mock(BookRepository.class);
        when(repo.existsById(42L)).thenReturn(false);
        when(repo.save(org.mockito.ArgumentMatchers.any(Book.class)))
                .thenAnswer(i -> i.getArgument(0));
        BookService service = new BookService(repo);

        Book book = new Book();
        book.setTitle("t");
        book.setAuthor("a");
        book.setPrice(1.0);
        book.setStock(1);
        service.save(42L, book);

        ArgumentCaptor<Book> captor = ArgumentCaptor.forClass(Book.class);
        verify(repo).save(captor.capture());
        assertThat(captor.getValue().getId()).isEqualTo(42L);
        assertThat(captor.getValue().isNew()).isTrue();
    }

    @Test
    void putOnExistingIdUpdatesNotNew() {
        BookRepository repo = mock(BookRepository.class);
        when(repo.existsById(7L)).thenReturn(true);
        when(repo.save(org.mockito.ArgumentMatchers.any(Book.class)))
                .thenAnswer(i -> i.getArgument(0));
        BookService service = new BookService(repo);

        Book book = new Book();
        book.setTitle("t");
        book.setAuthor("a");
        book.setPrice(2.0);
        book.setStock(2);
        service.save(7L, book);

        ArgumentCaptor<Book> captor = ArgumentCaptor.forClass(Book.class);
        verify(repo).save(captor.capture());
        assertThat(captor.getValue().isNew()).isFalse();
    }

}
