package com.github.diegopacheco.java.pocs.xstream.playground.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

import java.util.Objects;

@XStreamAlias("Book")
@XStreamConverter(value= ToAttributedValueConverter.class, strings={"name"}) // all attributes but name
public class Book {

    private String name;
    private Integer year;
    private String authorName;

    public Book() {}

    public Book(String name, Integer year, String authorName) {
        this.name = name;
        this.year = year;
        this.authorName = authorName;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(year, book.year) && Objects.equals(authorName, book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, authorName);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
