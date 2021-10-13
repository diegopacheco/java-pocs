package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) = LOWER(:title)")
    Book findByTitle(@Param("title") String title);

    // To query values in H2 do - VALUES NEXT VALUE FOR BOOK_SCHEMA.BOOK_SEQ;
    @Modifying
    @Query(value = "alter sequence BOOK_SCHEMA.BOOK_SEQ restart with 1",nativeQuery = true)
    void resetIdSequence();

}