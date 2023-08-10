package com.github.diegopacheco.java.code.annotation;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnnotationsApp {

    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }

    @com.github.diegopacheco.java.code.annotation.Prices(
            prices = {
                    @Price(alias = "car", value = "6.35", clazz = Prices.class),
                    @Price(alias = "motorhome", value = "8.72", clazz = Prices.class),
                    @Price(alias = "truck", value = "12.98", clazz = Prices.class),
                    @Price(alias = "std", value = "4.31", clazz = Prices.class)
            }
    )
    private class Prices{
        Map<String, Annotation> cache = new ConcurrentHashMap<>();
        public static double getPrice(String alias){
            return 0;
        }
    }

    private static double simulateTollPrice(String type){
       return 0;
    }

}
