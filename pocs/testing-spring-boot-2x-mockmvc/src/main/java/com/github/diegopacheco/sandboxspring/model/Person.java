package com.github.diegopacheco.sandboxspring.model;

import java.util.Objects;

public class Person {

    private int id;
    private String name;
    private String supports;

    public Person(){}

    public Person(int id, String name, String supports) {
        this.id = id;
        this.name = name;
        this.supports = supports;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSupports() {
        return supports;
    }
    public void setSupports(String supports) {
        this.supports = supports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", supports='" + supports + '\'' +
                '}';
    }
}
