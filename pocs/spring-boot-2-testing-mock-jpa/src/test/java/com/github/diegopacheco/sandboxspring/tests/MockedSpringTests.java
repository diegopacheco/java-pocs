package com.github.diegopacheco.sandboxspring.tests;

import com.github.diegopacheco.sandboxspring.dao.PetRepository;
import com.github.diegopacheco.sandboxspring.model.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MockedSpringTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PetRepository repository;

    @Test
    public void createPetTest() throws Exception {
        Pet gandalf = new Pet("Gandalf");
        mvc.perform(post("/api/pets").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(gandalf)));

        List<Pet> found = repository.findAll();
        assertThat(found).extracting(Pet::getName).contains("Gandalf");
    }

}
