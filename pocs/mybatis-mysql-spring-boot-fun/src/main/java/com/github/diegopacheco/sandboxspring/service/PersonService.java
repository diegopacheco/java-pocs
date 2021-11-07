package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.mapper.PersonMapper;
import com.github.diegopacheco.sandboxspring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonMapper mapper;

    public List<Person> getAllPeople(){
        return (List<Person>) mapper.selectAll();
    }

    public void save(Person p){
        mapper.insert(p);
    }

    public Person getById(Integer id){
        Collection<Person> result = mapper.search(id);
        return result.stream().findFirst().orElse(new Person("Not Found","Not Found"));
    }

}
