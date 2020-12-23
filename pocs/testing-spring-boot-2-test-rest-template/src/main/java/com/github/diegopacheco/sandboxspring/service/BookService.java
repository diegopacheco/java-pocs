package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.contract.model.Book;
import com.github.diegopacheco.sandboxspring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao dao;

    public List<Book> getAll(){
      return dao.getAll();
    }

    public void addBook(Book b){
        dao.add(b);
    }

}
