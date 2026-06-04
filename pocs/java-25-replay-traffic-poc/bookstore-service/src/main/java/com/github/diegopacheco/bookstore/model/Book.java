package com.github.diegopacheco.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("books")
public class Book implements Persistable<Long> {

    @Id
    private Long id;
    private String title;
    private String author;
    private Double price;
    private Integer stock;

    @Transient
    private boolean fresh;

    public Book() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return fresh;
    }

    public void markNew(boolean fresh) {
        this.fresh = fresh;
    }

}
