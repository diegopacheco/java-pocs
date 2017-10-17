package com.blogspot.diegopacheco.sandbox.github.java.akka.typed;

import akka.actor.TypedActor;
import akka.dispatch.Future;

/**
 * 
 * MainTest 
 *
 * @author pacheco
 * @version 1.0
 * @since 13/12/2010
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
		
		HotelBook hotel = (HotelBook) TypedActor.newInstance(HotelBook.class, ChickHotel.class, 1000);
		
		// One-way message send
		
		hotel.register("Diego Pacheco");
		
		// Request-reply message send
		
		People p = hotel.checkOut("Diego Pacheco");
		System.out.println(p);
		
		// Request-reply-with-future message send
		
		hotel.register("Ozzy");
		Future<People> f = hotel.cleanRoonAndCheckOut("Ozzy");
		
		f.await();
		People r = f.result().get();
		
		System.out.println("Resultado: " + r);
	}
	
}
