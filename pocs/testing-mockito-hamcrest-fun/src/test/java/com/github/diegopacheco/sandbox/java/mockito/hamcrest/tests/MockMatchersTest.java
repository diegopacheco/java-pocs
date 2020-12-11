package com.github.diegopacheco.sandbox.java.mockito.hamcrest.tests;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockMatchersTest {

    @Test
    public void testList(){
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(anyInt())).thenReturn("works");

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(999));
        assertThat("works", equalTo(mockedList.get(42)));
    }

    @Test
    public void testAny(){
        class Person{
            private Integer id;
            private String name;
            public Person copy(Person p){
                Person pNewnew = new Person();
                pNewnew.id = p.id;
                pNewnew.name = p.name;
                return pNewnew;
            }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return Objects.equals(id, person.id) &&
                        Objects.equals(name, person.name);
            }
            @Override
            public int hashCode() {
                return Objects.hash(id, name);
            }
        }

        Person data = new Person();
        data.id = 0;
        data.name = "fake";

        Person mockedObject = mock(Person.class);
        when(mockedObject.copy(anyObject())).thenReturn(data);

        System.out.println(mockedObject.copy(new Person()));
        System.out.println(mockedObject.copy(new Person()));
        assertThat(data, equalTo(mockedObject.copy(new Person())));
    }

}
