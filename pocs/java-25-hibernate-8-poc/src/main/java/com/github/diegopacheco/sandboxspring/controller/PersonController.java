package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Person;
import com.github.diegopacheco.sandboxspring.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> all() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> byId(@PathVariable Integer id) {
        return ok(personService.findById(id));
    }

    @GetMapping("/identifier/{id}")
    public ResponseEntity<Person> byIdentifier(@PathVariable Integer id) {
        return ok(personService.findByIdentifier(id));
    }

    @GetMapping("/natural/{name}")
    public ResponseEntity<Person> byNaturalId(@PathVariable String name) {
        return ok(personService.findByNaturalId(name));
    }

    @PostMapping("/natural")
    public List<Person> byNaturalIds(@RequestBody List<String> names) {
        return personService.findByNaturalIds(names);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
    }

    private ResponseEntity<Person> ok(Person person) {
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }
}
