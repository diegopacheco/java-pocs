package com.ilegra.training.jms.activemq.messaging;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.ilegra.training.jms.activemq.broker.EmbedBroker;

/**
 * Sample class to send messages to ActiveMQ using JMS.
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 03/29/2010
 *
 */
public class MessageSender {
	
	public void sendJMSTextQueueMessage(String destinationName,String message){		
		sendMessage(true, destinationName, message);
	}
	
	public void sendJMSTextTopicMessage(String destinationName,String message){		
		sendMessage(false, destinationName, message);
	}
	
	private void sendMessage(Boolean queue,String destinationName,String message){
		
		Connection connection = null;
		Session    session    = null;
		
		try{
			ConnectionFactory cf  = new ActiveMQConnectionFactory(EmbedBroker.getBrokerURL());
			
			connection = cf.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            Destination destination = null; 
            if(queue==true)
            	destination = session.createQueue(destinationName);
            else
            	destination = session.createTopic(destinationName);            
            
            MessageProducer producer = session.createProducer(null);			
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			TextMessage txtMessage = session.createTextMessage();
			txtMessage.setText( message );
			
			producer.send(destination,txtMessage);            
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			try{				
				if (session != null){
					session.close();
				}
				if (connection != null){
					connection.close();
				}				
			}catch(Exception e){
				throw new RuntimeException(e);
			}			
		}
		
	}
	
}
