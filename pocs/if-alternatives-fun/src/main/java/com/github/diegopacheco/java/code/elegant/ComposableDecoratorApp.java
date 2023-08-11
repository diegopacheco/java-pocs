package com.github.diegopacheco.java.code.elegant;

public class ComposableDecoratorApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }

    interface TollPrice{
        double price();
    }

    static class VehiclePrice implements TollPrice {
        TollPrice tollPrice;
        double value;
        String type;
        String supportedType;
        VehiclePrice(TollPrice tollPrice,String type,String supportedType,double value){
            this.tollPrice = tollPrice;
            this.value = value;
            this.type = type;
            this.supportedType = supportedType;
        }
        @Override
        public double price() {
            if (type!=null && type.equals(supportedType)){
                return tollPrice.price() + value;
            }
            if (supportedType==null && type==null){
                return tollPrice.price() + value;
            }
            return tollPrice.price();
        }

        static public TollPrice defaultToll(){
            return new TollPrice() {
                @Override
                public double price() {
                    return 0;
                }
            };
        }

    }

    private static double simulateTollPrice(final String type){
        return new VehiclePrice(
            new VehiclePrice(
                new VehiclePrice(
                    new VehiclePrice(
                        new VehiclePrice(VehiclePrice.defaultToll(),type,"car",10.93d),
                            type,"motorhome",14.23d),
                                type, "truck", 17.55d),
                                    type, null, 4.31),
                                      type, "", 4.31).price();
    }
}
