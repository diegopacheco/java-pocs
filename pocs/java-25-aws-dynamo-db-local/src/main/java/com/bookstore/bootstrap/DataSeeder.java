package com.bookstore.bootstrap;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;

@Component
public class DataSeeder {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);

    private static final List<Book> SEED = List.of(
            book("Clean Code", "Robert C. Martin", 464, 120),
            book("The Pragmatic Programmer", "Hunt & Thomas", 352, 200),
            book("Designing Data-Intensive Applications", "Martin Kleppmann", 616, 300),
            book("Effective Java", "Joshua Bloch", 412, 0),
            book("Refactoring", "Martin Fowler", 448, 88),
            book("Domain-Driven Design", "Eric Evans", 560, 40),
            book("The Mythical Man-Month", "Fred Brooks", 336, 336),
            book("Working Effectively with Legacy Code", "Michael Feathers", 456, 12),
            book("Release It!", "Michael Nygard", 378, 150),
            book("Accelerate", "Forsgren, Humble, Kim", 288, 288));

    private final BookRepository repository;

    public DataSeeder(BookRepository repository) {
        this.repository = repository;
    }

    @Order(2)
    @EventListener(ApplicationReadyEvent.class)
    public void seed() {
        try {
            if (!repository.findAll().isEmpty()) {
                log.info("Books table already has data, skipping seed");
                return;
            }
            SEED.forEach(repository::insert);
            log.info("seeded {} books", SEED.size());
        } catch (Exception e) {
            log.error("unable to seed books: {}", e.getMessage());
        }
    }

    private static Book book(String title, String author, int totalPages, int pagesRead) {
        return new Book(UUID.randomUUID().toString(), title, author, totalPages, pagesRead);
    }
}
