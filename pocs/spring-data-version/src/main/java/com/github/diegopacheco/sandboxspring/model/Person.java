package com.github.diegopacheco.sandboxspring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Objects;

public class Person implements Persistable<Long> {

    @Id
    private Long id;
    private String firstName;
    private String lastName;

    @Version
    @Column("version")
    private int version = 0;

    @Override
    public boolean isNew() {
        return null==id;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public Person() {
        super();
    }

    public Person(long id, String firstName, String lastName,Integer version) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
    }

    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    public Integer getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Person{"
                + "id=" + id + ", "
                + "firstName='" + firstName + "', "
                + "lastName='" + lastName + "'}";
    }

}