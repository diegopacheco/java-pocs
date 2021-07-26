package com.github.diegopacheco.design.patterns.behavioral.state;

public class TVStopState implements State {

    @Override
    public void doAction() {
        // Do real turn tv off...
        System.out.println("TV is turned OFF");
    }

}
