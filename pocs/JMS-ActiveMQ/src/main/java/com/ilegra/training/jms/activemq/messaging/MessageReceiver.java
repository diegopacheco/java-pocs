package com.ilegra.training.jms.activemq.messaging;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.ilegra.training.jms.activemq.broker.EmbedBroker;

/**
 * Simple class to receive messages in sync and async ways.
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 03/29/2010
 *	
 */

public class MessageReceiver {
	
	private TextMessage receiveSyncMessage(Boolean queue,String destinationName,MessageListener ml){
		
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
            
            MessageConsumer comsumer = session.createConsumer(destination);		
            
            if(ml==null){
            	return (TextMessage)comsumer.receive();
            }else{
            	comsumer.setMessageListener(ml);
            	return null;
            }           
            
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			try{		
				if(ml==null){
					if (session != null){
						session.close();
					}
					if (connection != null){
						connection.close();
					}
				}								
			}catch(Exception e){
				throw new RuntimeException(e);
			}			
		}		
	}
	
	
	public TextMessage receiveSyncQueueMessage(String destinationName){		
		return receiveSyncMessage(true, destinationName,null);
	}
	
	public TextMessage receiveSyncTopicMessage(String destinationName){		
		return receiveSyncMessage(false, destinationName,null);
	}
	
	public void registerASyncMessageQueueListener(String destination,MessageListener ml){
		receiveSyncMessage(true, destination,ml);
	}
	
	public void registerASyncMessageTopicListener(String destination,MessageListener ml){
		receiveSyncMessage(false, destination,ml);
	}
	
}
