package com.github.diegopacheco.stockmatcherengine.trigger;

import com.github.diegopacheco.stockmatcherengine.event.Event;

public class Equal implements Predicate{

    private Double value;
    private String symbol;

    public Equal(String symbol,Double value) {
        this.value = value;
        this.symbol = symbol;
    }

    @Override
    public boolean match(Event event) {
        if (!symbol.equals(event.symbol())){
            return false;
        }
        Double stockValue = Double.valueOf(event.value());
        return value.equals(stockValue);
    }
}
