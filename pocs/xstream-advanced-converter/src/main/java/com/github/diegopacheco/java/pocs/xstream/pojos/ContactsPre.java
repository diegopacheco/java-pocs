package com.github.diegopacheco.java.pocs.xstream.pojos;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactsPre {

    @XStreamImplicit
    private List<ContactPre> ContactList = new ArrayList<>();

    public ContactsPre() {}

    public ContactsPre(List<ContactPre> contactList) {
        this.ContactList = contactList;
    }

    public List<ContactPre> getContactList() {
        return ContactList;
    }
    public void setContactList(List<ContactPre> contactList) {
        this.ContactList = contactList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsPre that = (ContactsPre) o;
        return Objects.equals(ContactList, that.ContactList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ContactList);
    }

    @Override
    public String toString() {
        return "ContactsPre{" +
                "contactList=" + ContactList +
                '}';
    }

}
