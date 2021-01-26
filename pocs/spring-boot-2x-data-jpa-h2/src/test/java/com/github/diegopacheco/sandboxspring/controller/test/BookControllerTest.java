package com.github.diegopacheco.sandboxspring.controller.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.diegopacheco.sandboxspring.controller.BookController;
import com.github.diegopacheco.sandboxspring.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

}