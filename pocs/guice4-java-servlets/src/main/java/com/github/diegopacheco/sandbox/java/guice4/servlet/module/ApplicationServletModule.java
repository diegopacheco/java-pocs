package com.github.diegopacheco.sandbox.java.guice4.servlet.module;

import com.github.diegopacheco.sandbox.java.guice4.servlet.CalcServlet;
import com.github.diegopacheco.sandbox.java.guice4.servlet.SimpleDateServlet;
import com.github.diegopacheco.sandbox.java.guice4.servlet.service.CalcService;
import com.github.diegopacheco.sandbox.java.guice4.servlet.service.DateService;
import com.google.inject.servlet.ServletModule;

public class ApplicationServletModule extends ServletModule {
 
	@Override
    protected void configureServlets() {
        bind(DateService.class).asEagerSingleton();;
        bind(CalcService.class).asEagerSingleton();;
        
        serve("/date").with(SimpleDateServlet.class);
        serve("/calc").with(CalcServlet.class);
    }
	
}