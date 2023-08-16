package com.github.diegopacheco.stockmatcherengine.engine;

import com.github.diegopacheco.stockmatcherengine.event.Event;
import com.github.diegopacheco.stockmatcherengine.trigger.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Matcher {

    private List<Predicate> predicates;

    public Matcher(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    public List<MaterializedMatch> run(List<Event> events){
        List<MaterializedMatch> materializedMatches = new ArrayList<>(events.toArray().length/2);
        for(Event event : events){
            for(Predicate predicate : predicates){
                if (predicate.match(event)){
                    materializedMatches.add(new MaterializedMatch(event,predicate));
                }
            }
        }
        return materializedMatches;
    }

}
