package com.diegopacheco.pgrustfun.book.repository;

import com.diegopacheco.pgrustfun.book.domain.Book;
import com.diegopacheco.pgrustfun.book.domain.CreateBookRequest;

import java.util.List;

public interface BookRepository {

    List<Book> findPage(int page, int size);

    long count();

    Book save(CreateBookRequest request);
}
