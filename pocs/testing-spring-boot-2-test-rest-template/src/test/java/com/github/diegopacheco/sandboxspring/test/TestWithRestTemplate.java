package com.github.diegopacheco.sandboxspring.test;

import com.github.diegopacheco.sandboxspring.Application;
import com.github.diegopacheco.sandboxspring.contract.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@SpringBootTest(classes = Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestWithRestTemplate {

    @LocalServerPort
    Integer port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testAddBook(){
        Book book = new Book("Principles","Ray Dalio");
        ResponseEntity<Book> result = restTemplate.postForEntity("http://localhost:"+port+"/book",book,Book.class);
        System.out.println(result);
        assertEquals(book,result.getBody());
    }

    @Test
    public void listAllBooks(){
        Book book = new Book("Principles","Ray Dalio");
        restTemplate.postForEntity("http://localhost:"+port+"/book",book,Book.class);

        ResponseEntity<List> result = restTemplate.getForEntity("http://localhost:"+port+"/book", List.class);
        System.out.println(result);
        assertNotNull(result);
    }

}



