package com.github.diegopacheco.sandboxspring.model;

import com.github.diegopacheco.sandboxspring.driver.Anonymizing;
import com.github.diegopacheco.sandboxspring.driver.AnonymizingStrategy;
import org.springframework.data.annotation.Id;
import java.util.Objects;

public class Person {

    @Id
    private long id;

    @Anonymizing(dbFieldName = "first_name", strategy = AnonymizingStrategy.LAST4)
    private String firstName;

    @Anonymizing(dbFieldName = "last_name", strategy = AnonymizingStrategy.STAR)
    private String lastName;

    public Person() {
        super();
    }

    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return this.id;
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