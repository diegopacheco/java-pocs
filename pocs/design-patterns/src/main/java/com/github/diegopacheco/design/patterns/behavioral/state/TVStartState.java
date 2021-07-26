package com.github.diegopacheco.design.patterns.behavioral.state;

public class TVStartState implements State {

    @Override
    public void doAction() {
        // Do real turn Tv on
        System.out.println("TV is turned ON");
    }

}