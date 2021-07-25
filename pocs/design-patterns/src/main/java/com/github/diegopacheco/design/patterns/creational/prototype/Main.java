package com.github.diegopacheco.design.patterns.creational.prototype;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics();
        stats.registerSucess("/persist/person/1");
        stats.registerSucess("/persist/person/1");
        stats.registerError("/persist/person/3");
        Statistics stats2 = stats.clone();
        System.out.println(stats2);
    }
}
