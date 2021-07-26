package com.github.diegopacheco.design.patterns.behavioral.visitor;

public interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}
