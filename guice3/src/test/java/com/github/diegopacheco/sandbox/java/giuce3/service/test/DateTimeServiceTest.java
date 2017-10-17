package com.github.diegopacheco.sandbox.java.giuce3.service.test;

import junit.framework.Assert;

import org.junit.Test;

import com.github.diegopacheco.sandbox.java.giuce3.service.DateTimeService;
import com.github.diegopacheco.sandbox.java.giuce3.service.module.DateServiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Test Guice 3
 * @author Diego Pacheco
 *
 */
public class DateTimeServiceTest {
	
	@Test
	public void testShowDateAndTime(){
		
		Injector injector   = Guice.createInjector(new DateServiceModule());
		DateTimeService dts = injector.getInstance(DateTimeService.class);
		
		Assert.assertNotNull("Google Guice Ibjector could not be null",injector);
		Assert.assertNotNull("DateTimeService could not be null",dts);
		
		System.out.println(dts.showDateAndTime());		
	}
	
	@Test
	public void testShowDateAndTimeLogging(){
		
		Injector injector   = Guice.createInjector(new DateServiceModule());
		DateTimeService dts = injector.getInstance(DateTimeService.class);
		
		Assert.assertNotNull("Google Guice Ibjector could not be null",injector);
		Assert.assertNotNull("DateTimeService could not be null",dts);
		
		System.out.println(dts.showDateAndTimeLogged());		
	}	
	
}
