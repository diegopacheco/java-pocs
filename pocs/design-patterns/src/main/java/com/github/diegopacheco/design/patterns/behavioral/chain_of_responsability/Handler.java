package com.github.diegopacheco.design.patterns.behavioral.chain_of_responsability;

public interface Handler {
    void add(Handler next);
    void run(Object context);
}
