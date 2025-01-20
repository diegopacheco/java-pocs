package com.github.diegopacheco.sandboxspring.controller;
import com.github.diegopacheco.sandboxspring.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasItems;

/**
 *  Dont forget to run ./run-mysql-5.7-docker.sh first.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Greetings from Spring Boot!"));
    }

    @Test
    public void testGetAllThePeople() throws Exception {
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").value(org.hamcrest.Matchers.hasItems(1, 2, 3, 4, 5)))
                .andExpect(jsonPath("$[*].firstName").value(hasItems("**ctor", "*ante", "**efan", "*scar", "*iego")))
                .andExpect(jsonPath("$[*].lastName").value(hasItems("****", "*********", "*****", "*****", "*******")));
    }

}