package com.blogspot.diegopacheco.camel.bean;

/**
 * This bean recive the messages from the hornetq topics and queues.
 * 
 * @author Diego Pacheco
 * @version 1.0
 * @since 21/02/2010
 * 
 * This implementation focus on JBoss HornetQ integration. Developed by:<br>
 * 
 * <b>Diego Pacheco</b><br>
 * <a href='http://diego-pacheco.blogspot.com'>http://diego-pacheco.blogspot.com</a>
 *
 */
public class BeanConsumer {
	public void handle(String msg){
		System.out.println("Message Recived: " + msg);
	}
}
