package com.ilegra.training.apache.camel.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotations {
	public static void main(String[] args) {		
		try{				
			new ClassPathXmlApplicationContext(new String[] {"classpath:spring-camel-annotations-beans.xml"});			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
