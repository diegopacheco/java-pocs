package com.ilegra.training.jms.activemq.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.ilegra.training.jms.activemq.broker.EmbedBroker;

/**
 * Sample class to show to send and receive messages
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 03/29/2010
 *
 */
public class SendReceiveSyncASyncSample {
	
	public static void main(String[] args) throws Throwable{
		
		EmbedBroker.start();
		
		MessageSender ms = new MessageSender();
		ms.sendJMSTextQueueMessage("queueLondon", "Test message london ");
		System.out.println("Message sent");
		
		MessageReceiver mr = new MessageReceiver();
		TextMessage msg    = mr.receiveSyncQueueMessage("queueLondon");
		
		System.out.println("Message Arrived: " + msg.getText());		
	
		mr.registerASyncMessageQueueListener("queueLondon", new MessageListener() {
			@Override
			public void onMessage(Message message) {
				try {
					System.out.println("Message Arrived on listener: " + ((TextMessage)message).getText()  );
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		 });
		
		 ms.sendJMSTextQueueMessage("queueLondon", "Test message london MS");
		 System.out.println("Message sent");	
		
	}
}
