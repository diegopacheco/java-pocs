package com.github.diegopacheco.java.code.generic;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }

    static class Prices{
        double getCarPrice(){
            return 10.93d;
        }
        double getMotorhomePrice(){
            return 14.23d;
        }
        double getTruckPrice(){
            return 17.55d;
        }
        double getStdPrice(){
            return 4.31d; // bikes, small smart cars, tuk-tuk, whatever...
        }
    }

    static Prices instance;
    static Map<String,Method> cache;
    static{
         instance = new Prices();
         cache = new ConcurrentHashMap<>();
    }

    private static Method getMethod(String name){
        try{
            Method method = cache.get(name);
            if (null==method){
                String cap = name.substring(0, 1).toUpperCase() + name.substring(1);
                method = instance.getClass().getDeclaredMethod("get" + cap + "Price");
                cache.put(name,method);
            }
            return method;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static Double invoke(String name){
        try{
            return (Double)getMethod(name).invoke(instance,null);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static double simulateTollPrice(String type){
        if (null==type || "".equals(type.trim())){
            return invoke("std");
        }
        return invoke(type);
    }
}
