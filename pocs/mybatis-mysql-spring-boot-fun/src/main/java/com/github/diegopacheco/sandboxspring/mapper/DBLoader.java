package com.github.diegopacheco.sandboxspring.mapper;

import com.github.diegopacheco.sandboxspring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBLoader {

    @Autowired
    PersonMapper mapper;

    public void load(){
        List<Person> people = Arrays.asList(
                new Person("John", "Wick"),
                new Person("John", "McClane"),
                new Person("John", "Rambo")
        );
        people.forEach(mapper::insert);
    }

}
