package com.github.diegopacheco.sandbox.java.uber.tchannel.main;

public class Ping {
    private final String request;

    public Ping(String request) {
        this.request = request;
    }
    
    @Override
    public String toString() {
    	return request;
    }
}