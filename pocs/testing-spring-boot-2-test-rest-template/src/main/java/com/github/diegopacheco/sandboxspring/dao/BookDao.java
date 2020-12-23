package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.contract.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class BookDao {

    private ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<String, Book>();

    public List<Book> getAll(){
        return books.values().stream().collect(Collectors.toList());
    }

    public void add(Book book){
        books.put(book.getName(),book);
    }

}
