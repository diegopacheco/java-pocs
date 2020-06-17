package com.github.diegopacheco.sandboxspring.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void sumTest() throws Exception {
        String result = this.restTemplate.getForObject("http://localhost:" + port + "/math/sum/1/1",String.class);
        System.out.println("Result: " + result);
        assertThat(result).contains("2");
    }

}
