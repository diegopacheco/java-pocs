package com.github.diegopacheco.javapocs.app;

import com.google.common.annotations.VisibleForTesting;

public class TaxCalculator {

    public enum State{
        RS(Double.parseDouble("0.07")),
        SC(Double.parseDouble("0.06")),
        SP(Double.parseDouble("0.08")),
        RJ(Double.parseDouble("0.09"));
        private Double value;
        private State(Double value){
            this.value = value;
        }
    }

    private Double value;
    private State state;

    public TaxCalculator(Double value){
        this(value,State.RS);
    }

    public TaxCalculator(Double value,State state){
        this.value = value;
        this.state = state;
    }

    public Double getPrice(){
        return (value * state.value) + value;
    }

    // This is for FLAG problems, not to inform is visible for testing.
    // here the level is fine for testing but still visible to all the package.
    // Also might be better to make it private and enable access on the test via reflections.
    // This works because the test code is on the same package
    @VisibleForTesting
    State getState(){
        return state;
    }

}
