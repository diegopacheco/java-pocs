package com.github.diegopacheco.design.patterns._extra.tolerant_reader;

import java.util.Objects;
import java.util.UUID;

public class PersonV2 extends PersonV1{

    private UUID id;
    private String sex;

    public PersonV2(){
        super();
    }

    public PersonV2(String name, String email, String sex, UUID id) {
        super(name, email);
        this.sex = sex;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
        if (!super.equals(o)) return false;
        PersonV2 personV2 = (PersonV2) o;
        return Objects.equals(id, personV2.id) && Objects.equals(sex, personV2.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, sex);
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                '}';
    }
}
