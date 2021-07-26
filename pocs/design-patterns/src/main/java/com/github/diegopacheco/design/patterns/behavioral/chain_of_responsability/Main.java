package com.github.diegopacheco.design.patterns.behavioral.chain_of_responsability;

public class Main {
    public static void main(String[] args) {
        Handler rootHandler = new ProfanityHandler();
        rootHandler.add(new UpperCaseHandler());
        rootHandler.add(new LogHandler());
        rootHandler.run("dammit this is fine dammit");
    }
}
