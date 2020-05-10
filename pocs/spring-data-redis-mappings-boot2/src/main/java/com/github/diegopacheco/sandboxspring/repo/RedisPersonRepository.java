package com.github.diegopacheco.sandboxspring.repo;

import com.github.diegopacheco.sandboxspring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisPersonRepository {

    @Autowired
    private PersonRepository repo;

    public <S extends Person> S save(S entity) {
        if (entity.getName()!=null) entity.setName(entity.getName().toUpperCase());
        if (entity.getMail()!=null) entity.setMail(entity.getMail().toUpperCase());
        return repo.save(entity);
    }

    public <S extends Person> Iterable<S> saveAll(Iterable<S> entities) {
        return repo.saveAll(entities);
    }

    public Optional<Person> findById(String s) {
        return repo.findById(s);
    }

    public boolean existsById(String s) {
        return repo.existsById(s);
    }

    public Iterable<Person> findAll() {
        return repo.findAll();
    }

    public Iterable<Person> findAllById(Iterable<String> strings) {
        return repo.findAllById(strings);
    }

    public long count() {
        return repo.count();
    }

    public void deleteById(String s) {
        repo.deleteById(s);
    }

    public void delete(Person entity) {
        repo.delete(entity);
    }

    public void deleteAll(Iterable<? extends Person> entities) {
        repo.deleteAll(entities);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

}
