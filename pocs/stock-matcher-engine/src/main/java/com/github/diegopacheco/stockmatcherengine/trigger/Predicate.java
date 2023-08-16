package com.github.diegopacheco.stockmatcherengine.trigger;

import com.github.diegopacheco.stockmatcherengine.event.Event;

import java.util.Map;

public interface Predicate {
    boolean match(Event event);
}
