package com.ilegra.training.spring.integration.jms;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Simple twitter service using Spring integration annotations
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 04/05/2010
 * 
 */
@MessageEndpoint
public class TwitterService {
	
	@ServiceActivator
	public String tweet(String msg140chars){
		if (msg140chars==null || "".equals(msg140chars) || msg140chars.length()>=141){
			throw new RuntimeException("You can not use more than 140 characters! ");
		}
		return "[foo] tweets-> " + msg140chars;		
	}
	
}
