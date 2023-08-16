package com.github.diegopacheco.stockmatcherengine.trigger;

import com.github.diegopacheco.stockmatcherengine.event.Event;

public class GreaterThan implements Predicate{

    private String symbol;
    private Double value;

    public GreaterThan(String symbol, Double value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public boolean match(Event event) {
        if (!symbol.equals(event.symbol())){
            return false;
        }
        Double stockValue = Double.valueOf(event.value());
        return stockValue.compareTo(value) >= 0;
    }
}
