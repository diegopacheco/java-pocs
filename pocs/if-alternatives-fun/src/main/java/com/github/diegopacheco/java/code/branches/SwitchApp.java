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
            case "car": return 6.35d;
            case "motorhome": return 8.72d;
            case "truck": return 12.98d;
            default: return 4.31; // bikes, small smart cars, tuk-tuk, whatever...
        }
    }
}
