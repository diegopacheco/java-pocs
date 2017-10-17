package com.github.diegopacheco.sandbox.java.giuce3.service.module;

import com.github.diegopacheco.sandbox.java.giuce3.service.DateService;
import com.github.diegopacheco.sandbox.java.giuce3.service.DateServiceImpl;
import com.github.diegopacheco.sandbox.java.giuce3.service.DateTimeService;
import com.github.diegopacheco.sandbox.java.giuce3.service.LoggingDateService;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Guice Module for DataService
 * @author Diego Pacheco
 *
 */
public class DateServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(DateService.class).to(DateServiceImpl.class);
		bind(DateTimeService.class);		
		bind(LoggingDateService.class).annotatedWith(Names.named("lds")).to(LoggingDateService.class);
		bind(String.class).annotatedWith(Names.named("JH")).toInstance(System.getProperty("JAVA_HOME","D:\\"));
	}

}
