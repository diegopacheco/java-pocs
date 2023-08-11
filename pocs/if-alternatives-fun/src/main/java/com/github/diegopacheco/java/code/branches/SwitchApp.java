package com.github.diegopacheco.java.code.branches;

public class SwitchApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car  = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }
    private static double simulateTollPrice(String type){
        if (null==type || "".equals(type.trim())){
            return 4.31;
        }
        switch (type){
            case "car": return 10.93d;
            case "motorhome": return 14.23d;
            case "truck": return 17.55d;
            default: return 4.31; // bikes, small smart cars, tuk-tuk, whatever...
        }
    }
}
