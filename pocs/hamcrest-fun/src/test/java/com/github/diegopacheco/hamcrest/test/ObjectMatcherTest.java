package com.github.diegopacheco.hamcrest.test;

import com.github.diegopacheco.hamcrest.Person;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasToString;

public class ObjectMatcherTest {
    @Test
    public void objectToStringTest(){
        Person person=new Person("Barrack", "Washington");
        String str=person.toString();
        assertThat(person,hasToString(str));
    }
}
