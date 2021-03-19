package com.github.diegopacheco.java.pocs.xstream.pojos;

import com.github.diegopacheco.java.pocs.xstream.converter.PojoToListConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XStreamAlias("contacts")
@XStreamConverter(PojoToListConverter.class)
public class Contacts {

    private List<Contact> contactList = new ArrayList<>();

    public Contacts() {}

    public Contacts(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Contact> getContacts() {
        return contactList;
    }
    public void setContacts(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts1 = (Contacts) o;
        return Objects.equals(contactList, contacts1.contactList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactList);
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "contactList=" + contactList +
                '}';
    }

}
