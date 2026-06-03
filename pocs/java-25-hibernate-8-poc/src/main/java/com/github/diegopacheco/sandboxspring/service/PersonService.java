package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.model.Person;
import org.hibernate.KeyType;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final SessionFactory sessionFactory;

    public PersonService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Person findById(Integer id) {
        return sessionFactory.fromTransaction(session -> session.find(Person.class, id));
    }

    public Person findByIdentifier(Integer id) {
        return sessionFactory.fromTransaction(session -> session.find(Person.class, id, KeyType.IDENTIFIER));
    }

    public Person findByNaturalId(String name) {
        return sessionFactory.fromTransaction(session -> session.find(Person.class, name, KeyType.NATURAL));
    }

    public List<Person> findByNaturalIds(List<String> names) {
        return sessionFactory.fromTransaction(session -> session.findMultiple(Person.class, List.copyOf(names), KeyType.NATURAL));
    }

    public List<Person> findAll() {
        return sessionFactory.fromTransaction(session -> session.createQuery("from Person order by id", Person.class).list());
    }

    public Person save(Person person) {
        sessionFactory.inTransaction(session -> session.persist(person));
        return person;
    }
}
