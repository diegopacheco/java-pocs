package com.github.diegopacheco.javapocs.reclections.pojo;

import com.github.diegopacheco.javapocs.reclections.annotations.PostProcessToString;
import com.github.diegopacheco.javapocs.reclections.annotations.UpperCasePostToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    private String name;
    private String email;
    private String addess;
    private Boolean active = true;
    private List<String> interests = new ArrayList<>();

    public Person() {}

    public Person(String name, String email, String addess, Boolean active, List<String> interests) {
        this.name = name;
        this.email = email;
        this.addess = addess;
        this.active = active;
        this.interests = interests;
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

    public String getAddess() {
        return addess;
    }
    public void setAddess(String addess) {
        this.addess = addess;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<String> getInterests() {
        return interests;
    }
    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(email, person.email) && Objects.equals(addess, person.addess) && Objects.equals(active, person.active) && Objects.equals(interests, person.interests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, addess, active, interests);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", addess='" + addess + '\'' +
                ", active=" + active +
                ", interests=" + interests +
                '}';
    }

    @PostProcessToString
    public String toStringPostProcessing(String s){
            System.out.println("running generic post process... ");
           return s.toLowerCase();
    }

}
