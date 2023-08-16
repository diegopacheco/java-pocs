package com.github.diegopacheco.stockmatcherengine.engine;

import com.github.diegopacheco.stockmatcherengine.event.Event;
import com.github.diegopacheco.stockmatcherengine.predicates.Predicate;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMatcher implements Matcher{

    private List<Predicate> predicates;

    public InMemoryMatcher(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    @Override
    public List<MaterializedMatch> run(List<Event> events){
        List<MaterializedMatch> materializedMatches = new ArrayList<>(events.size());
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
