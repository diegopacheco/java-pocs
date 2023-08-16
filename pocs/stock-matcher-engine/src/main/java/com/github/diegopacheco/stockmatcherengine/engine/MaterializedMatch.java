package com.github.diegopacheco.stockmatcherengine.engine;

import com.github.diegopacheco.stockmatcherengine.event.Event;
import com.github.diegopacheco.stockmatcherengine.predicates.Predicate;

import java.time.Instant;

public class MaterializedMatch {

    private Event event;
    private Predicate predicate;
    private Instant matchTime;

    public MaterializedMatch(Event event, Predicate predicate) {
        this.event = event;
        this.predicate = predicate;
        this.matchTime = Instant.now();
    }

    @Override
    public String toString() {
        return "MaterializedMatch{" +
                "event=" + event +
                ", predicate=" + predicate +
                ", matchTime=" + matchTime +
                '}';
    }
}
