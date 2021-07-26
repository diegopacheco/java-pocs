package com.github.diegopacheco.design.patterns.behavioral.memento;

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Memento{" +
                "state='" + state + '\'' +
                '}';
    }
}