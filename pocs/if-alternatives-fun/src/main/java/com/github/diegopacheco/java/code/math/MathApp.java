package com.github.diegopacheco.java.code.math;

public class MathApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(0));
        System.out.println("Toll price: for a null = " + simulateTollPrice(0));
        System.out.println("Toll price: for a car = " + simulateTollPrice(2));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice(3));
        System.out.println("Toll price: for a truck = " + simulateTollPrice(4));
    }

    private static double simulateTollPrice(int axes){
        double basePrice = 4.31;
        double grandTotal = basePrice + (axes*3.31);
        return grandTotal;
    }
}
