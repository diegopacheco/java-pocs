package com.github.diegopacheco.sandbox.java.gdrl.guice.module;

import com.github.diegopacheco.sandbox.java.gdrl.guice.logger.SLF4JTypeListener;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class LoggingModule extends AbstractModule {
   @Override 
   protected void configure() {
 	  bindListener(Matchers.any(), new SLF4JTypeListener());
   }
}

