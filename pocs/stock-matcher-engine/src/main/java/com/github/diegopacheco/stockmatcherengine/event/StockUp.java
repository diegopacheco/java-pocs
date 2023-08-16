package com.github.diegopacheco.stockmatcherengine.event;

public class StockUp implements Event{

    private Double value;
    private String symbol;

    public StockUp(String reason,Double value) {
        this.value = value;
        this.symbol = reason;
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
