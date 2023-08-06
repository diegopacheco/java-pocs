package com.github.diegopacheco.java.code.polymorphism.typesystem;

public class InstanceOfApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }

    static class Car{
        public double price(){
            return 6.35d;
        }
    }

    static class Motorhome{
        public double price(){
            return 8.72d;
        }
    }

    static class Truck{
        public double price(){
            return 12.98d;
        }
    }

    static class DefaultVehicle{
        public double price(){
            return 4.31;
        }
    }

    static class VehicleFactory{
        static Object build(String type){
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
        Object obj = VehicleFactory.build(type);
        if (obj instanceof Car){
            return ((Car)obj).price();
        }
        if (obj instanceof Motorhome){
            return ((Motorhome)obj).price();
        }
        if (obj instanceof Truck){
            return ((Truck)obj).price();
        }
        return ((DefaultVehicle)obj).price();
    }
}
