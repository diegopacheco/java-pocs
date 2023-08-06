package com.github.diegopacheco.java.code.branches;

public class IFsApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }

    private static double simulateTollPrice(String type){
        if (null==type || "".equals(type.trim())){
            return 4.31;
        }
        if ("car".equals(type.toLowerCase().trim())){
            return 6.35d;
        }
        if ("motorhome".equals(type.toLowerCase().trim())){
            return 8.72d;
        }
        if ("truck".equals(type.toLowerCase().trim())){
            return 12.98d;
        }
        // bikes, small smart cars, tuk-tuk, whatever...
        return 4.31;
    }
}
