package com.github.diegopacheco.java.pocs.xstream.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XStreamAlias("list")
public class ListOfContacts {

    @XStreamImplicit
    private List<ContactPre> ContactPres = new ArrayList<>();

    public ListOfContacts() {
    }

    public List<com.github.diegopacheco.java.pocs.xstream.pojos.ContactPre> getContactPres() {
        return ContactPres;
    }

    public void setContactPres(List<com.github.diegopacheco.java.pocs.xstream.pojos.ContactPre> contactPres) {
        this.ContactPres = contactPres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOfContacts that = (ListOfContacts) o;
        return Objects.equals(ContactPres, that.ContactPres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ContactPres);
    }

    @Override
    public String toString() {
        return "ListOfContacts{" +
                "ContactPres=" + ContactPres +
                '}';
    }

}
