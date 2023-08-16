package com.github.diegopacheco.stockmatcherengine.event;

public class StockDown implements Event{

    private Double value;
    private String symbol;

    public StockDown(String symbol,Double value) {
        this.value = value;
        this.symbol = symbol;
    }

    @Override
    public String symbol() {
        return symbol;
    }

    @Override
    public Double value() {
        return value;
    }
}
