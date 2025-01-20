package com.github.diegopacheco.sandboxspring.controller;
import com.github.diegopacheco.sandboxspring.model.Person;
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
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        List<Person> people = Arrays.asList(
                new Person(1, "Victor", "****"),
                new Person(2, "Dante", "*********"),
                new Person(3, "Stefan", "*****"),
                new Person(4, "Oscar", "*****"),
                new Person(5, "Diego", "*******")
        );

        when(personService.getAllPeople()).thenReturn(people);

        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath("$[*].id").value(org.hamcrest.Matchers.contains(1, 2, 3, 4, 5)))
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath("$[*].firstName").value(org.hamcrest.Matchers.containsInAnyOrder("Victor", "Dante", "Stefan", "Oscar", "Diego")))
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath("$[*].lastName").value(org.hamcrest.Matchers.containsInAnyOrder("****", "*********", "*****", "*****", "*******")));
    }

}