package com.github.diegopacheco.sandboxspring.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class MutualTLSIT {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testMutualTLSCall(){
        ResponseEntity<String> result = restTemplate.getForEntity("https://localhost:9002/data",String.class);
        System.out.println(result.getBody());
    }

}
