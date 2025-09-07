package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "OK", "message", "DDD Controllers are working!");
    }
}