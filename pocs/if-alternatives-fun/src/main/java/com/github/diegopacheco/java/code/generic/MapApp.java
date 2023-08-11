package com.github.diegopacheco.java.code.generic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }

    private static Map<String,Double> prices = new ConcurrentHashMap<>();
    static{
        prices.put("car",10.93d);
        prices.put("motorhome",14.23d);
        prices.put("truck",17.55d);
    }
    private static double simulateTollPrice(String type){
        if (null==type) return 4.31;
        return prices.getOrDefault(type,4.31);
    }
}
