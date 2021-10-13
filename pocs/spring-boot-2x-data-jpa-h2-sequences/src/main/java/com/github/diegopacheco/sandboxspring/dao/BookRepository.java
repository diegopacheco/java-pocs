package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) = LOWER(:title)")
    Book findByTitle(@Param("title") String title);

    @Modifying
    @Query(value = "alter sequence BOOK_SEQ restart with 1",nativeQuery = true)
    void resetIdSequence();

}