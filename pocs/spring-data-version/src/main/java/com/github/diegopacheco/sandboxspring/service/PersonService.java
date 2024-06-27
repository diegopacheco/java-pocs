package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.dao.PersonRepository;
import com.github.diegopacheco.sandboxspring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> getAllPeople(){
        List<Person> result = new ArrayList<Person>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Transactional
    public void save(Person p){
        repository.save(p);
    }

}
