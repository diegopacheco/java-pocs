package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class HelloService {

    public String getGreetings(@Valid @NotNull String person) {
        return "Greetings " + person;
    }

}
