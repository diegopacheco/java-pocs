package com.github.diegopacheco.design.patterns._extra.abstract_document.domain;

import com.github.diegopacheco.design.patterns._extra.abstract_document.Document;

import java.util.stream.Stream;

public interface HasParts extends Document {
    String PROPERTY = "parts";

    default Stream<Part> getParts() {
        return children(PROPERTY, Part::new);
    }
}
