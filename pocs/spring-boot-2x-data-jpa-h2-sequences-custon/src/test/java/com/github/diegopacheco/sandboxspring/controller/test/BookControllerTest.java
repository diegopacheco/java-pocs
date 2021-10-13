package com.github.diegopacheco.sandboxspring.controller.test;

import com.github.diegopacheco.sandboxspring.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateBook(){
        Book toBeCreated = new Book("Building Scala Applications","Diego Pacheco");
        Book result = this.restTemplate.postForObject("/book",toBeCreated, Book.class);
        assertNotNull(result);
        assertEquals("Diego Pacheco",result.getAuthor());
        assertEquals("Building Scala Applications",result.getTitle());
        assertNotNull(result.getId());
        System.out.println(result);
    }

    @Test
    public void testGetBook(){
        Book toBeCreated = new Book("Building Scala Applications","Diego Pacheco");
        Book result = restTemplate.postForObject("/book",toBeCreated, Book.class);
        assertNotNull(result);
        assertEquals("Diego Pacheco",result.getAuthor());
        assertEquals("Building Scala Applications",result.getTitle());
        assertNotNull(result.getId());
        System.out.println(result);

        Book retrieveBook = restTemplate.getForObject("/book/Building Scala Applications",
                Book.class);
        assertNotNull(retrieveBook);
        assertEquals("Diego Pacheco",retrieveBook.getAuthor());
        assertEquals("Building Scala Applications",retrieveBook.getTitle());
        assertNotNull(retrieveBook.getId());
    }

    @Test
    public void testDeleteBook(){
        Book toBeCreated = new Book("Building Scala Applications","Diego Pacheco");
        Book result = restTemplate.postForObject("/book",toBeCreated, Book.class);
        assertNotNull(result);
        assertEquals("Diego Pacheco",result.getAuthor());
        assertEquals("Building Scala Applications",result.getTitle());
        assertNotNull(result.getId());
        System.out.println(result);

        restTemplate.delete("/book/" + result.getId());
        Book[] allBooks = restTemplate.getForObject("/book",Book[].class);
        assertNotNull(allBooks);
        Arrays.stream(allBooks).forEach( b -> assertNotEquals(result.getId(),b.getId()));
    }

    @Test
    public void testListAllBooks(){
        Book toBeCreated = new Book("Building Scala Applications","Diego Pacheco");
        Book result = restTemplate.postForObject("/book",toBeCreated, Book.class);
        assertNotNull(result);
        assertEquals("Diego Pacheco",result.getAuthor());
        assertEquals("Building Scala Applications",result.getTitle());
        assertNotNull(result.getId());
        System.out.println(result);
        Book[] allBooks = restTemplate.getForObject("/book",Book[].class);
        assertNotNull(allBooks);
        Arrays.stream(allBooks).forEach(System.out::println);
    }


}
