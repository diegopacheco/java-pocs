package com.github.diegopacheco.stockmatcherengine.predicates;

import com.github.diegopacheco.stockmatcherengine.event.Event;

public interface Predicate {
    boolean match(Event event);
}
