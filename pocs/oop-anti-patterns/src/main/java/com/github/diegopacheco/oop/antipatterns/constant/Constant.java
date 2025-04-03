package com.github.diegopacheco.oop.antipatterns.constant;

/**
 *  Constants
 *
 *  - Force logic to be somewhere else.
 *  - Can easy lead to code duplication.
 *  - Are not proper abstractions.
 *
 */
public class Constant {

    // provider
    public class Constants {
        public static final int MAX_VALUE = 100;
        public static final int MIN_VALUE = 20;
    }

    // consumer
    public class HotelService{

        public void checkIn(String guestName,int numberOfNights, int roomNumber) {
            if (numberOfNights > Constants.MAX_VALUE) {
                System.out.println("Number of nights exceeds maximum limit.");
            } else if (numberOfNights < Constants.MIN_VALUE) {
                System.out.println("Number of nights is below minimum limit.");
            } else {
                // Check-in logic
                System.out.println("Guest " + guestName + " checked in for " + numberOfNights + " nights.");
            }
        }

        public void checkOut(String guestName) {
            // Check-out logic
            System.out.println("Guest " + guestName + " checked out.");
        }

    }
}
