package com.github.diegopacheco.stockmatcherengine.predicates;

import com.github.diegopacheco.stockmatcherengine.event.Event;

public class LessThan implements Predicate{

    private String symbol;
    private Double value;

    public LessThan(String symbol, Double value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public boolean match(Event event) {
        if (!symbol.equals(event.symbol())){
            return false;
        }
        return event.value().compareTo(value) <= 0;
    }
}
