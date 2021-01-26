package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.controller.BookNotFoundException;
import com.github.diegopacheco.sandboxspring.dao.BookRepository;
import com.github.diegopacheco.sandboxspring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository dao;

    public Book save(Book b){
        return dao.save(b);
    }

    public Book getByTitle(String title){
        Book book = dao.findByTitle(title);
        if (null==book){
            throw new BookNotFoundException("Could not get book by title: " + title);
        }
        return book;
    }

    public List<Book> findAll(){
        return dao.findAll();
    }

    public void deleteById(Long id){
        dao.deleteById(id);
    }

}
