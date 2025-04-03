package com.github.diegopacheco.oop.antipatterns.enums;

/**
 * Enums
 *
 *  - Force logic to into clients.
 *  - Easily leads to duplicated code.
 *  - What happens when you read a state in DB that does not exist into the enum?
 *  - Not proper abstractions.
 *
 */
public class Enums {

    // provider
    public enum RoomType {
        SINGLE,
        DOUBLE,
        SUITE
    }

    // consumer
    public class HotelService{

        public double calculatePrice(RoomType roomType, int days){
            double price = 0;
            switch(roomType){
                case SINGLE:
                    price = 100 * days;
                    break;
                case DOUBLE:
                    price = 150 * days;
                    break;
                case SUITE:
                    price = 200 * days;
                    break;
            }
            return price;
        }

    }

}
