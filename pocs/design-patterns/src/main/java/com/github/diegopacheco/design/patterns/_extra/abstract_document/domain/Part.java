package com.github.diegopacheco.design.patterns._extra.abstract_document.domain;

import com.github.diegopacheco.design.patterns._extra.abstract_document.AbstractDocument;

import java.util.Map;

public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {
    public Part(Map<String, Object> properties) {
        super(properties);
    }
}
