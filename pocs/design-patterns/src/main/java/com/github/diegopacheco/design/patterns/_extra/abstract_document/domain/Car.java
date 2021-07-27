package com.github.diegopacheco.design.patterns._extra.abstract_document.domain;

import com.github.diegopacheco.design.patterns._extra.abstract_document.AbstractDocument;

import java.util.Map;

public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {
    public Car(Map<String, Object> properties) {
        super(properties);
    }
}
