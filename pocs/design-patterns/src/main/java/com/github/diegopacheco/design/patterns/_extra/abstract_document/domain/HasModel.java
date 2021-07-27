package com.github.diegopacheco.design.patterns._extra.abstract_document.domain;

import com.github.diegopacheco.design.patterns._extra.abstract_document.Document;

import java.util.Optional;

public interface HasModel extends Document {
    String PROPERTY = "model";

    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(PROPERTY));
    }
}