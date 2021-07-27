package com.github.diegopacheco.design.patterns._extra.tolerant_reader;

import java.io.Serializable;
import java.util.Objects;

public class PersonV1 implements Serializable {

    private String name;
    private String email;

    public PersonV1(){}

    public PersonV1(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonV1 personV1 = (PersonV1) o;
        return Objects.equals(name, personV1.name) && Objects.equals(email, personV1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
