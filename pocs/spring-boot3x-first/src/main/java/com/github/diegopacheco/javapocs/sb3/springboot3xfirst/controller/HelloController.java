package com.github.diegopacheco.javapocs.sb3.springboot3xfirst.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello Spring boot 3.x";
    }

}
