package com.blogspot.diegopacheco.camel.cxf.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelBootstraping {
	public static void main(String[] args) {		
		try{				
			new ClassPathXmlApplicationContext(new String[] {"classpath:spring-camel-cxf-beans.xml"});			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
