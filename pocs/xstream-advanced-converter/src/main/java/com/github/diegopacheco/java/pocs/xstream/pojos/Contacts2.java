package com.github.diegopacheco.java.pocs.xstream.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XStreamAlias("contacts2")
public class Contacts2 {

    private List<ContactPre> list = new ArrayList<>();

    public ContactsPre() {}

    public ContactsPre(List<ContactPre> list) {
        this.list = list;
    }

    public List<ContactPre> getList() {
        return list;
    }
    public void setList(List<ContactPre> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsPre that = (ContactsPre) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "ContactsPre{" +
                "list=" + list +
                '}';
    }

}
