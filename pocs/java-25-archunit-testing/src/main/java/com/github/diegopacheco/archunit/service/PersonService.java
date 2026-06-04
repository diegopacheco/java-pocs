package com.github.diegopacheco.archunit.service;

import com.github.diegopacheco.archunit.dao.PersonRepository;
import com.github.diegopacheco.archunit.model.Person;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public List<Person> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    public Person save(Person person) {
        return repository.save(person);
    }
}
