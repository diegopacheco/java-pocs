package com.github.diegopacheco.stockmatcherengine.generators;

import com.github.diegopacheco.stockmatcherengine.predicates.Predicate;

import java.util.List;

public interface PredicateGenerator {
    List<Predicate> generate(int amount);
}
