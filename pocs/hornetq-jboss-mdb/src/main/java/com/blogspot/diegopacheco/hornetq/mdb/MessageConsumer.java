package com.blogspot.diegopacheco.hornetq.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.jboss.ejb3.annotation.ResourceAdapter;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/testQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
@ResourceAdapter("hornetq-ra.rar")
public class MessageConsumer implements MessageListener {

	public void onMessage(Message msg) {
		System.out.println("----------------");
		System.out.println("Received message pelo MDB com RA para o HornetQ: " + msg);
		System.out.println("----------------");
	}

}