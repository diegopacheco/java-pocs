package com.ilegra.training.spring.integration.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class to run this sample
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 04/05/2010
 * 
 */
public class Main {
	public static void main(String[] args) {
		
		new ClassPathXmlApplicationContext(new String[] {
						"classpath:spring-integration-jms-base.xml",
						"classpath:spring-integration-gateway-jms.xml" 
					}
		);
		
	}
}