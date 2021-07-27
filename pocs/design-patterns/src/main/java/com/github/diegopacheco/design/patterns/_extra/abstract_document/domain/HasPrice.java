package com.github.diegopacheco.design.patterns._extra.abstract_document.domain;

import com.github.diegopacheco.design.patterns._extra.abstract_document.Document;

import java.util.Optional;

public interface HasPrice extends Document {
    String PROPERTY = "price";

    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(PROPERTY));
    }
}