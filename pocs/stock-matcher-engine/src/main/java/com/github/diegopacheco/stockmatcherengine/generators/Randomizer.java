package com.github.diegopacheco.stockmatcherengine.generators;

import java.util.Random;

public class Randomizer {

    public static double value(){
        Random r = new Random();
        double value = r.nextDouble(9000-10) + 10;
        return value;
    }

    public static String symbol(){
        String[] symbols = new String[]{"XOM","GE","TM","PG","GOOG","ING","AAPL",
                "META","NFLX","AMZN","XOM"};
        Random r = new Random();
        int result = r.nextInt(9-1) + 1;
        return symbols[result];
    }
}
