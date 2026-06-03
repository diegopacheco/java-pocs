package com.github.diegopacheco.sandboxspring;

import com.github.diegopacheco.sandboxspring.model.Person;
import com.github.diegopacheco.sandboxspring.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PersonService personService;

    public DataInitializer(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(String... args) {
        if (!personService.findAll().isEmpty()) {
            return;
        }
        List<Person> people = List.of(
                new Person(1, "Bilbo Baggins", "Hobbiton"),
                new Person(2, "Gandolph the Grey", "Valinor"),
                new Person(3, "Frodo Baggins", "Hobbiton"),
                new Person(4, "Aragorn", "Minas Tirith"));
        people.forEach(personService::save);
    }
}
