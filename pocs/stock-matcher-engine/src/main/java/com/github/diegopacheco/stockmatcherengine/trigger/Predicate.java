package com.github.diegopacheco.stockmatcherengine.trigger;

import com.github.diegopacheco.stockmatcherengine.event.Event;

public interface Predicate {
    boolean match(Event event);
}
