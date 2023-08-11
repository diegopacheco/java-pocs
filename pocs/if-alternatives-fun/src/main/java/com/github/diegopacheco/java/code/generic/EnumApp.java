package com.github.diegopacheco.java.code.generic;

public class EnumApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + Vehicle.OTHERS.getPrice());
        System.out.println("Toll price: for a null = " + Vehicle.OTHERS.getPrice());
        System.out.println("Toll price: for a car = " + Vehicle.valueOf("CAR").getPrice());
        System.out.println("Toll price: for a motorhome = " + Vehicle.MOTORHOME.getPrice());
        System.out.println("Toll price: for a truck = " + Vehicle.TRUCK.getPrice());

        // using valueOf creates weaker type system, push to runtime errors
        // System.out.println("Toll price: for a truck = " + Vehicle.valueOf("null"));    // NPE
        // System.out.println("Toll price: for a truck = " + Vehicle.valueOf("banana"));  // IllegalArgumentException: No enum constant com.github.diegopacheco.java.code.generic.EnumApp.Vehicle.banana
    }

    enum Vehicle{
        CAR(10.93d),
        MOTORHOME(14.23d),
        TRUCK(17.55d),
        OTHERS(4.31);

        private final double price;
        Vehicle(double price) {
            this.price = price;
        }
        public double getPrice(){
            return price;
        }
    }
}
