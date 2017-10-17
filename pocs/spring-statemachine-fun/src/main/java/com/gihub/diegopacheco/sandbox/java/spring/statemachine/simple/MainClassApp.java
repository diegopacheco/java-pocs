package com.gihub.diegopacheco.sandbox.java.spring.statemachine.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClassApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		  ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		  MyApp app = context.getBean(MyApp.class);
		  app.doSignals();
	}
}
