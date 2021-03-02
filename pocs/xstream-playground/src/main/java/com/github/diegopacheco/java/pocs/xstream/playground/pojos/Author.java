package com.github.diegopacheco.java.pocs.xstream.playground.pojos;

import com.github.diegopacheco.java.pocs.xstream.playground.converters.NullTagConverter;
import com.thoughtworks.xstream.annotations.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Author {

    @XStreamOmitField
    private UUID id;

    @XStreamAsAttribute
    private String email;

    private String name;

    @XStreamImplicit
    private List<Book> books;

    // 3 Options:
    // 1. default bank String(facebookID="") forces XStream to print null value: <facebookID></facebookID>
    // 2. Do #1 and use the generic converter I created NullTagConverter which will force any String to be empty tag of null or empty String
    @XStreamConverter(NullTagConverter.class)
    private String facebookID="";

    // 3. Option 3 - use Optional
    private Optional<String> twitterID = Optional.empty(); // make the empty as: <twitterID/>

    @XStreamImplicit(itemFieldName = "subject") // make a flat list with the tag subject
    private List<String> interests;

    @XStreamAlias("hobbies-list")
    private Hobbies hobs;

    public Author() { }

    public Author(UUID id, String email, String name, List<Book> books, String facebookID, Optional<String> twitterID, List<String> interests, Hobbies hobs) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.books = books;
        this.facebookID = facebookID;
        this.twitterID = twitterID;
        this.interests = interests;
        this.hobs = hobs;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getInterests() {
        return interests;
    }
    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public Hobbies getHobs() {
        return hobs;
    }
    public void setHobs(Hobbies hobs) {
        this.hobs = hobs;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getFacebookID() {
        return facebookID;
    }
    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public Optional<String> getTwitterID() {
        return twitterID;
    }
    public void setTwitterID(Optional<String> twitterID) {
        this.twitterID = twitterID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(email, author.email) && Objects.equals(name, author.name) && Objects.equals(books, author.books) && Objects.equals(facebookID, author.facebookID) && Objects.equals(twitterID, author.twitterID) && Objects.equals(interests, author.interests) && Objects.equals(hobs, author.hobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, books, facebookID, twitterID, interests, hobs);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", books=" + books +
                ", facebookID='" + facebookID + '\'' +
                ", twitterID=" + twitterID +
                ", interests=" + interests +
                ", hobs=" + hobs +
                '}';
    }
}
