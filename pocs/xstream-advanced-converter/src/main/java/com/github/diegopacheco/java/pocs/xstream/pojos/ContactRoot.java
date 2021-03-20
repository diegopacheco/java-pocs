package com.github.diegopacheco.java.pocs.xstream.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XStreamAlias("ContactRoot")
public class ContactRoot {

    //@XStreamImplicit
    List<ContactItem> ContactItems = new ArrayList<>();

    public ContactRoot() {}

    public ContactRoot(List<ContactItem> ContactItems) {
        this.ContactItems = ContactItems;
    }

    public List<ContactItem> getContactItems() {
        return ContactItems;
    }
    public void setContactItems(List<ContactItem> contactItems) {
        ContactItems = contactItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactRoot that = (ContactRoot) o;
        return Objects.equals(ContactItems, that.ContactItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ContactItems);
    }

    @Override
    public String toString() {
        return "ContactRoot{" +
                "ContactItems=" + ContactItems +
                '}';
    }

}
