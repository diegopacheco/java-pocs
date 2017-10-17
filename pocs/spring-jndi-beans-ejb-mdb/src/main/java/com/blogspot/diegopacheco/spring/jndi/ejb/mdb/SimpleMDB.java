package com.blogspot.diegopacheco.spring.jndi.ejb.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.ejb3.annotation.ResourceAdapter;

import com.blogspot.diegopacheco.spring.jndi.service.DateService;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType"	, propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination"		, propertyValue = "spring_jndi_queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode"  , propertyValue = "Auto-acknowledge") 
		})
@ResourceAdapter("activemq-ra.rar")
public class SimpleMDB implements MessageListener {
	
	@Resource(mappedName="spring_jndi_dateService")
	private DateService ds;
	
	@Override
	public void onMessage(Message msg) {
		
		System.out.println("[ Services Avaliable ]");
		System.out.println("[ DS: " + ds);
		System.out.println("[ Date now: " + ds.getCurrentDateTime() );

		try {
			System.out.println("[ MSG:->\n" +  ((TextMessage)msg).getText() );
		} catch (JMSException e) {
			e.printStackTrace();
		}		
		
	}
	
}