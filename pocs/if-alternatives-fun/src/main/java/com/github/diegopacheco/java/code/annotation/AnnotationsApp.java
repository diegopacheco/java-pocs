package com.github.diegopacheco.java.code.annotation;

import java.math.BigDecimal;
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

    @Prices(
            prices = {
                    @Price(alias = "car", value = "6.35", clazz = Prices.class),
                    @Price(alias = "motorhome", value = "8.72", clazz = Prices.class),
                    @Price(alias = "truck", value = "12.98", clazz = Prices.class),
                    @Price(alias = "std", value = "4.31", clazz = Prices.class)
            }
    )
    private static class PricesTable{
        Map<String, BigDecimal> cache;
        Prices prices = PricesTable.class.getDeclaredAnnotation(Prices.class);
        public BigDecimal getPrice(String alias){
            if (null==cache){
                 cache = new ConcurrentHashMap<>();
                 for(Price price : prices.prices()){
                      cache.put(price.alias(), new BigDecimal(price.value()));
                 }
            }
            if (null==alias){
                return cache.get("std");
            }
            return cache.getOrDefault(alias,cache.get("std"));
        }
    }

    static PricesTable pricesTable = new PricesTable();
    private static double simulateTollPrice(String type){
        return pricesTable.getPrice(type).doubleValue();
    }

}
