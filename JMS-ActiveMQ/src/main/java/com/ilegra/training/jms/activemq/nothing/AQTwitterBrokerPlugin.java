package com.ilegra.training.jms.activemq.nothing;

import javax.jms.TextMessage;

import org.apache.activemq.broker.BrokerPluginSupport;
import org.apache.activemq.broker.ProducerBrokerExchange;
import org.apache.activemq.command.Message;

/**
 * Broker Plugin for AQwitter apllication.<BR>
 * This brokker plugin shorts the messages end assure that all messages will have at maximun 140 characters.
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 03/31/2009
 *
 */
public class AQTwitterBrokerPlugin extends BrokerPluginSupport{	
	
	@Override
	public void send(ProducerBrokerExchange producerExchange,Message messageSend) throws Exception {
		if ("AQwitterTopic".equals(messageSend.getDestination().getPhysicalName())){
			if (messageSend instanceof TextMessage){
				String newTextMessage = ((TextMessage)messageSend).getText().substring(0,139) + "\nBTW " +
										((TextMessage)messageSend).getStringProperty("AQwitterUSER")  + " loves Brazil and ilegra!";
				((TextMessage)messageSend).setText( newTextMessage );
			}
		}		
		super.send(producerExchange, messageSend);				
	} 
}
