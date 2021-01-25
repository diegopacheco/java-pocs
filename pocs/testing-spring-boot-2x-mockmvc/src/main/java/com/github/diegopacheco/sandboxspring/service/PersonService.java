package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonService {

    private Map<Integer,Person> people = new HashMap<>();

    public PersonService(){
        people.put(1,new Person(1,"Diego","Gremio"));
        people.put(2, new Person(2,"Dessa","Gremio"));
    }

    public Person getPersonById(int id){
        return people.get(id);
    }

}
