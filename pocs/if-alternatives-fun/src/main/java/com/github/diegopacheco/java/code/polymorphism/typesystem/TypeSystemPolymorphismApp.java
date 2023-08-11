package com.github.diegopacheco.java.code.polymorphism.typesystem;

public class TypeSystemPolymorphismApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }

    static interface Vehicle {
        double price();
    }

    static class Car implements Vehicle{
        public double price(){
            return 10.93d;
        }
    }

    static class Motorhome implements Vehicle{
        public double price(){
            return 14.23d;
        }
    }

    static class Truck implements Vehicle{
        public double price(){
            return 17.55d;
        }
    }

    static class DefaultVehicle implements Vehicle{
        public double price(){
            return 4.31;
        }
    }

    static class VehicleFactory{
        static Vehicle build(String type){
            if (null==type){
                return new DefaultVehicle();
            }
            switch (type) {
                case "car":
                    return new Car();
                case "motorhome":
                    return new Motorhome();
                case "truck":
                    return new Truck();
                default:
                    return new DefaultVehicle();
            }
        }
    }

    private static double simulateTollPrice(String type){
        return VehicleFactory.build(type).price();
    }
}
