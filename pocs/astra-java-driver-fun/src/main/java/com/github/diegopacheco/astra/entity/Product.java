package com.github.diegopacheco.astra.entity;


import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

import java.util.UUID;

@Entity
public class Product {

    @PartitionKey
    private UUID id;
    private String description;

    public Product(){}

    public Product(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}