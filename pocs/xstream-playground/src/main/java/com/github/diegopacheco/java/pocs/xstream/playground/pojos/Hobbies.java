package com.github.diegopacheco.java.pocs.xstream.playground.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;
import java.util.Objects;

@XStreamAlias("Hobbies")
public class Hobbies {

    @XStreamImplicit(itemFieldName="hobbie-name")
    private List<String> hobbies;

    public Hobbies() {}

    public Hobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getHobbies() {
        return hobbies;
    }
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobbies hobbies1 = (Hobbies) o;
        return Objects.equals(hobbies, hobbies1.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hobbies);
    }

    @Override
    public String toString() {
        return "Hobbies{" +
                "hobbies=" + hobbies +
                '}';
    }

}
