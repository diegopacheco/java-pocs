package com.github.diegopacheco.java.pocs.xstream.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contact {

    private Integer ID;
    private String Name;
    private String Email;
    private Boolean Active;
    private List<String> SpokenLanguages = new ArrayList<>();

    public Contact() {}

    public Contact(Integer ID, String name, String email, Boolean active, List<String> SpokenLanguages) {
        this.ID = ID;
        Name = name;
        Email = email;
        Active = active;
        this.SpokenLanguages = SpokenLanguages;
    }

    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public Boolean getActive() {
        return Active;
    }
    public void setActive(Boolean active) {
        Active = active;
    }

    public List<String> getSpokenLanguages() {
        return SpokenLanguages;
    }
    public void setSpokenLanguages(List<String> SpokenLanguages) {
        this.SpokenLanguages = SpokenLanguages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(ID, contact.ID) && Objects.equals(Name, contact.Name) && Objects.equals(Email, contact.Email) && Objects.equals(Active, contact.Active) && Objects.equals(SpokenLanguages, contact.SpokenLanguages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name, Email, Active, SpokenLanguages);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Active=" + Active +
                ", SpokenLanguages=" + SpokenLanguages +
                '}';
    }
}
