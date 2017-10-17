package com.github.diegopacheco.sandbox.java.giuce3.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Using @Inject from java to inject via guice 
 * 
 * @author Diego Pacheco
 *
 */
@Singleton
public class DateTimeService {
	
	private DateService ds;
	private LoggingDateService lds;
	private String javahome;
	
	@Inject
	public DateTimeService(DateService ds, @Named("lds") LoggingDateService lds){
		this.ds = ds;
		this.lds = lds;
	}
	
	@Inject
	public void setJavahome(@Named("JH") String javahome) {
		this.javahome = javahome;
	}
	
	public String showDateAndTime(){
		return ds.currentDate();
	}
	
	public String showDateAndTimeLogged(){		
		System.out.println("BTW: JAVA HOME is " + javahome);
		return lds.currentDate();		
	}
	
}
