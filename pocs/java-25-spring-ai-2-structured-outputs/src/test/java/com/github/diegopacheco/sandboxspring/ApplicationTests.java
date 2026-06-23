package com.github.diegopacheco.sandboxspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.diegopacheco.sandboxspring.structuredoutput.FilmographyController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private FilmographyController controller;

    @Test
    void contextLoadsWithStructuredOutputWiring() {
        assertThat(controller).isNotNull();
    }
}
