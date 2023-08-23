package com.github.diegopacheco.hamcrest.test;

import com.github.diegopacheco.hamcrest.Music;
import com.github.diegopacheco.hamcrest.Person;
import com.github.diegopacheco.hamcrest.Rock;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ObjectMatcherTest {
    @Test
    public void objectToStringTest(){
        Person person=new Person("Barrack", "Washington");
        String str=person.toString();
        assertThat(person,hasToString(str));
    }

    @Test
    public void typeSystemCompatibleTest(){
        assertThat(Rock.class,typeCompatibleWith(Music.class));
    }

    @Test
    public void hasPropertyTest() {
        Person person = new Person("John", "Doe");
        assertThat(person, hasProperty("name"));
    }

    @Test
    public void hasPropertyValueTest() {
        Person person = new Person("Joe", "Joy");
        assertThat(person, hasProperty("lastName", equalTo("Joy")));
    }

}
