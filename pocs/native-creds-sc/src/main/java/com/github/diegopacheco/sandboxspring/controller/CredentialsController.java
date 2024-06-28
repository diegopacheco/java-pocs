package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CredentialsController {

    @Autowired
    private EncryptionService es;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/enc/{key}/{pt}")
    public String enc(@PathVariable("key") String key,
                      @PathVariable("pt") String pt) {
        return es.enc(key, pt);
    }

    @RequestMapping("/dec/{key}/{pt}")
    public String dec(@PathVariable("key") String key,
                      @PathVariable("pt") String pt) {
        return es.dec(key, pt);
    }

}

