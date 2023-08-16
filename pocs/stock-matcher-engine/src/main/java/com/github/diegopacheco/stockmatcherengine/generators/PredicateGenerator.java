package com.github.diegopacheco.stockmatcherengine.generators;

import com.github.diegopacheco.stockmatcherengine.trigger.Predicate;

import java.util.List;

public interface PredicateGenerator {
    List<Predicate> generate(int amount);
}
