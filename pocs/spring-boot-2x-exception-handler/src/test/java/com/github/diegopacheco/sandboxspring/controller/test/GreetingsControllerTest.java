package com.github.diegopacheco.sandboxspring.controller.test;

import com.github.diegopacheco.sandboxspring.controller.GreetingsController;
import com.github.diegopacheco.sandboxspring.controller.LanguageNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GreetingsController.class)
public class GreetingsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testInvalidLang() throws Exception{
        mvc.perform(get("/greet/{lang}", "italian")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof LanguageNotFoundException))
                .andExpect(result -> assertEquals("italian Not Found.", result.getResolvedException().getMessage()));
    }

    @Test
    public void testValidGreeting() throws Exception{
        mvc.perform(get("/greet/{lang}", "english")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> assertNull(result.getResolvedException()) )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(result -> assertEquals("hi, how is it going?", result.getResponse().getContentAsString() ));
    }

}
