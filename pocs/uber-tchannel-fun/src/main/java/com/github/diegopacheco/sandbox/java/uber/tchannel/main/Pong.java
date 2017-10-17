package com.github.diegopacheco.sandbox.java.uber.tchannel.main;

public class Pong {
    private final String response;

    public Pong(String response) {
        this.response = response;
    }
    
    @Override
    public String toString() {
    	return response;
    }
}