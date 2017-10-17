package com.github.diegopacheco.sandbox.java.gdrl.guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class NamedDefaultConfigsModule extends AbstractModule {
  
  @Override 
  protected void configure() {
	  bind(String.class).annotatedWith(Names.named("locale")).toInstance("en_GB");
  }
  
}
