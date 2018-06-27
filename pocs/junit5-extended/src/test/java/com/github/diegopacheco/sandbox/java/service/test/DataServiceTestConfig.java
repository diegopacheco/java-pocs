package com.github.diegopacheco.sandbox.java.service.test;

import com.github.diegopacheco.sandbox.java.service.DataService;
import com.github.diegopacheco.sandbox.java.service.DataServiceImpl;

/**
 * Everything that needs to be reused goes here. No Asserts here.
 * Right now Junit 5 dont have order like junit 4 -> https://github.com/junit-team/junit5/issues/48
 * So thats why I had to make sure it run just once.
 * 
 * @author diego
 *
 */
public final class DataServiceTestConfig {
		
	  private static boolean setup    = false;
	  private static boolean tearDown = false;
	
		public static DataService getDataService() {
			 return new DataServiceImpl();
		}
		
		public synchronized static void setUp() {
			if (!setup) {
				System.out.println("Creating all dependencies needed just 1 time. ");
				setup = true;
			}
		}
		
		public synchronized static void tearDown() {
			if (!tearDown) {
				System.out.println("Shutting down all dependencies needed just 1 time. ");
				tearDown = true;
			}
		}
}
