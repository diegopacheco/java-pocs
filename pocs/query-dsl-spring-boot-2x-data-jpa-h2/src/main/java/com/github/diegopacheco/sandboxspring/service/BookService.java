package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.controller.BookNotFoundException;
import com.github.diegopacheco.sandboxspring.dao.BookRepository;
import com.github.diegopacheco.sandboxspring.model.Book;
import com.github.diegopacheco.sandboxspring.model.QBook;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository dao;

    @Autowired
    EntityManager entityManager;

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
        Boolean exist = dao.existsById(id);
        if (exist){
            dao.deleteById(id);
            return;
        }
        throw new BookNotFoundException("Book with id: "+id+" Not Found. Impossible to delete record.");
    }

    @Transactional
    public void deleteAllBooks(){
        dao.deleteAll();
        dao.resetIdSequence();
    }

    public Book getBookQueryDSL(){
        QBook book = QBook.book;
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        Book b = queryFactory.selectFrom(book)
                .where(book.author.eq("Diego Pacheco"))
                .fetchOne();
        return b;
    }

}
