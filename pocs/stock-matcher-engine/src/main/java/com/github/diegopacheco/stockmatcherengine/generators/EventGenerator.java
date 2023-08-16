package com.github.diegopacheco.stockmatcherengine.generators;

import com.github.diegopacheco.stockmatcherengine.event.Event;

import java.util.List;

public interface EventGenerator {
    List<Event> generate(int amount);
}
