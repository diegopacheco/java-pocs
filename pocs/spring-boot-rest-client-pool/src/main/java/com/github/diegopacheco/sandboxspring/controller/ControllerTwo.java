package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerTwo {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/slow2")
    public String callSlow() {
        return restTemplate.
                getForEntity("http://127.0.0.1:5000/slow", String.class)
                .getBody();
    }

}

