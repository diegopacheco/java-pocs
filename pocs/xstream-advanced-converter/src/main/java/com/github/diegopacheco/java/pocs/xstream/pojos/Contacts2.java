package com.github.diegopacheco.java.pocs.xstream.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Objects;

@XStreamAlias("Contacts2")
public class Contacts2 {

    private ListOfContacts list = new ListOfContacts();

    public Contacts2() {}

    public ListOfContacts getList() {
        return list;
    }
    public void setList(ListOfContacts list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts2 contacts2 = (Contacts2) o;
        return Objects.equals(list, contacts2.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "Contacts2{" +
                "list=" + list +
                '}';
    }

}
