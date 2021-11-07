package com.github.diegopacheco.sandboxspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private long id;
    private String first_name;
    private String last_name;

    public Person(String first_name,String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

}