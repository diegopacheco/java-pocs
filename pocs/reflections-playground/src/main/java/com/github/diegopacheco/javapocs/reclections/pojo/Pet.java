package com.github.diegopacheco.javapocs.reclections.pojo;

import com.github.diegopacheco.javapocs.reclections.annotations.UpperCasePostToString;

import java.util.Objects;

@UpperCasePostToString
public class Pet {

    private String name;
    private String sex;

    public Pet(){ }

    public Pet(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) && Objects.equals(sex, pet.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}
