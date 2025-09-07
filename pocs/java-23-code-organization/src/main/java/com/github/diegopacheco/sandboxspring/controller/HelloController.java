package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hello from Spring Boot!");
    }
    
    @GetMapping("/api/status")
    public Map<String, String> status() {
        return Map.of("status", "Application is running", "version", "1.0");
    }
}