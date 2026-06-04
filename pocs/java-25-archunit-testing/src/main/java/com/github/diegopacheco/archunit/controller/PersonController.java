package com.github.diegopacheco.archunit.controller;

import com.github.diegopacheco.archunit.model.Person;
import com.github.diegopacheco.archunit.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> all() {
        return service.findAll();
    }

    @GetMapping("/search")
    public List<Person> byFirstName(@RequestParam String firstName) {
        return service.findByFirstName(firstName);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return service.save(person);
    }
}
