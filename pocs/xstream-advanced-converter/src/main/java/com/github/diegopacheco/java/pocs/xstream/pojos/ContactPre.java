package com.github.diegopacheco.java.pocs.xstream.pojos;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactPre {

    private Integer ID=1;
    private String Name="";
    private String Email="";
    private Boolean Active=true;

    @XStreamImplicit
    private List<String> SpokenLanguages = new ArrayList<>();

    public ContactPre() {}

    public ContactPre(Integer ID, String name, String email, Boolean active, List<String> spokenLanguages) {
        this.ID = ID;
        Name = name;
        Email = email;
        Active = active;
        SpokenLanguages = spokenLanguages;
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
    public void setSpokenLanguages(List<String> spokenLanguages) {
        SpokenLanguages = spokenLanguages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPre that = (ContactPre) o;
        return Objects.equals(ID, that.ID) && Objects.equals(Name, that.Name) && Objects.equals(Email, that.Email) && Objects.equals(Active, that.Active) && Objects.equals(SpokenLanguages, that.SpokenLanguages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name, Email, Active, SpokenLanguages);
    }

    @Override
    public String toString() {
        return "ContactPre{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Active=" + Active +
                ", SpokenLanguages=" + SpokenLanguages +
                '}';
    }

}
