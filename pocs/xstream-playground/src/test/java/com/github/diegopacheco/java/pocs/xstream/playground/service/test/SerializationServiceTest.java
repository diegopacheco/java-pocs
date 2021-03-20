package com.github.diegopacheco.java.pocs.xstream.playground.service.test;

import com.github.diegopacheco.java.pocs.xstream.playground.pojos.Author;
import com.github.diegopacheco.java.pocs.xstream.playground.pojos.Book;
import com.github.diegopacheco.java.pocs.xstream.playground.pojos.Hobbies;
import com.github.diegopacheco.java.pocs.xstream.playground.service.SerializationService;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SerializationServiceTest {

    @Test
    public void testSerialize(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Building Scala Applications",2016,"DiegoPacheco"));
        books.add(new Book("Building Scala Applications",2016,"DiegoPacheco"));
        books.add(new Book("Building Scala Applications",2016,"DiegoPacheco"));

        List<String> interests = new ArrayList<>();
        interests.add("Footbal");
        interests.add("Music");
        interests.add("TVShows");

        List<String> hobbiList = new ArrayList<>();
        hobbiList.add("Travel");
        hobbiList.add("Games");
        Hobbies hobbies = new Hobbies(hobbiList);

        Author author = new Author();
        author.setId(UUID.randomUUID());
        author.setBooks(books);
        author.setInterests(interests);
        author.setHobs(hobbies);
        author.setName("Diego Pacheco");
        author.setEmail("diego@diego.diego");

        SerializationService ss = new SerializationService();
        String xml = ss.serialize(author);
        assertNotNull(xml);
        System.out.println(xml);
    }

    @Test
    public void testDeserialize(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Building Scala Applications",2016,"DiegoPacheco"));

        List<String> interests = new ArrayList<>();
        interests.add("Footbal");
        interests.add("Music");
        interests.add("TVShows");

        List<String> hobbiList = new ArrayList<>();
        hobbiList.add("Travel");
        hobbiList.add("Games");
        Hobbies hobbies = new Hobbies(hobbiList);

        Author author = new Author();
        author.setId(UUID.randomUUID());
        author.setBooks(books);
        author.setInterests(interests);
        author.setHobs(hobbies);
        author.setName("Diego Pacheco");
        author.setEmail("diego@diego.diego");

        SerializationService<Author> ss = new SerializationService<>();
        String xml = ss.serialize(author);

        Author backToObjecct = ss.deserialize(xml);
        assertNotNull(backToObjecct);
        System.out.println(backToObjecct);
    }

}
