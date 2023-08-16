package com.github.diegopacheco.stockmatcherengine.engine;

import com.github.diegopacheco.stockmatcherengine.event.Event;

import java.util.List;

public interface Matcher {
    List<MaterializedMatch> run(List<Event> events);
}
