package com.github.diegopacheco.sandboxspring.model;
import com.github.diegopacheco.sandboxspring.meta.UpperCase;
import org.springframework.data.redis.core.RedisHash;

import java.util.Objects;

@RedisHash
public class Person {

    private String id;

    @UpperCase
    private String name;

    @UpperCase
    private String mail;

    public Person() {}

    public Person(String name, String id, String mail) {
        this.name = name;
        this.id = id;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

