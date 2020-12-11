package com.github.diegopacheco.sandboxspring.tests;

import com.github.diegopacheco.sandboxspring.controller.PetController;
import com.github.diegopacheco.sandboxspring.model.Pet;
import com.github.diegopacheco.sandboxspring.service.PetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PetController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class ControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PetService service;

    @Test
    public void createPet() throws Exception {
        Pet melina = new Pet("Melina");
        given(service.save(Mockito.any())).willReturn(melina);

        mvc.perform(post("/api/pets").contentType(MediaType.APPLICATION_JSON).
                content(JsonUtil.toJson(melina))).andExpect(status().isCreated()).
                andExpect(jsonPath("$.name", is("Melina")));

        verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
        reset(service);
    }


}
