package com.github.diegopacheco.sandboxspring.controller.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.github.diegopacheco.sandboxspring.controller.BookNotFoundException;
import com.github.diegopacheco.sandboxspring.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getBookByNameNotFound() throws Exception{
        mvc.perform(get("/book/{name}", "Peopleware")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof Exception))
                .andExpect(result -> assertEquals("Could not get book by title: Peopleware", result.getResolvedException().getMessage()));
    }

    @Test
    public void createBook() throws Exception{
        Book book = new Book();
        book.setAuthor("Isac Azimov");
        book.setTitle("Foundation");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(book);

        mvc.perform(post("/book/", book)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(result ->
                        assertTrue(result.getResponse().getContentAsString()
                                .contains("\"title\":\"Foundation\",\"author\":\"Isac Azimov\"") ));
    }

    @Test
    public void deleteBook() throws Exception{
        createBook();

        MvcResult mvcResult = mvc.perform(get("/book/")
                            .contentType(MediaType.APPLICATION_JSON)).andReturn();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        CollectionType typeReference = TypeFactory.defaultInstance().constructCollectionType(List.class, Book.class);
        List<Book> books =  mapper.readValue(mvcResult.getResponse().getContentAsString(), typeReference);

        mvc.perform(delete("/book/{id}", books.get(0).getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> assertTrue(null==result.getResolvedException()));
    }

    @Test
    public void deleteBookDoesNotExist() throws Exception{
        mvc.perform(delete("/book/{id}", 999999999L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BookNotFoundException))
                .andExpect(result -> assertEquals("Book with id: 999999999 Not Found. Impossible to delete record.", result.getResolvedException().getMessage()));
    }

}