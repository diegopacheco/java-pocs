package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;

@RestController
public class HelloController {

    @Autowired
    private ExecutorService executor;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot 3.2.0! " + executor.toString();
    }

}