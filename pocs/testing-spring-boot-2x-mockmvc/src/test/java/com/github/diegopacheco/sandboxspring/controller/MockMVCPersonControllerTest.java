package com.github.diegopacheco.sandboxspring.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
public class MockMVCPersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testMockMvcNotFound() throws Exception{
        mvc.perform(get("/person/{id}", 3)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResourceNotFoundException))
                .andExpect(result -> assertEquals("Person with ID[3] not found", result.getResolvedException().getMessage()));
    }

    @Test
    public void testMockMvcGetExistentPerson() throws Exception{
        mvc.perform(get("/person/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals("{\"id\":1,\"name\":\"Diego\",\"supports\":\"Gremio\"}", result.getResponse().getContentAsString() ));
    }

}
