package com.blogspot.diegopacheco.camel.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class for test application staring up camel, spring and routes.
 * 
 * @author Diego Pacheco
 * @version 1.0
 * @since 21/02/2010
 * 
 * This implementation focus on JBoss HornetQ integration. Developed by:<br>
 * 
 * <b>Diego Pacheco</b><br>
 * <a href='http://diego-pacheco.blogspot.com'>http://diego-pacheco.blogspot.com</a>
 */
public class CamelBootstraping {
	public static void main(String[] args) {		
		try{				
			new ClassPathXmlApplicationContext(new String[] {"classpath:spring-camel-beans.xml"});			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
