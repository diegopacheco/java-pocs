package com.ilegra.training.jms.activemq.jms.priority;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.ilegra.training.jms.activemq.broker.EmbedBroker;

public class MainJMSPriority {
	public static void main(String[] args) {
		
		Connection connection = null;
		Session    session    = null;
		
		try{
			
			EmbedBroker.start();
			
			ConnectionFactory cf  = new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			connection = cf.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 
            Destination destination  = session.createQueue("selectorPriorizationQueue");
            
            MessageProducer producer = session.createProducer(destination);
            
            TextMessage txtMessage = session.createTextMessage();
			txtMessage.setText( "MSG 1 - London" );
			//txtMessage.setJMSPriority(6);
			producer.send(destination,txtMessage,0,6,9000);
			System.out.println("London message sent ");
			
			TextMessage txtMessage2 = session.createTextMessage();
			txtMessage2.setText( "MSG 2 - Italy " );
			//txtMessage2.setJMSPriority(4);
			producer.send(destination,txtMessage2,0,4,9000);
			System.out.println("Italy message sent ");
			
			TextMessage txtMessage3 = session.createTextMessage();
			txtMessage3.setText( "MSG 3 - Brazil " );
			txtMessage3.setStringProperty("Barcelona", "true");
			//txtMessage3.setJMSPriority(3);
			producer.send(destination,txtMessage3,0,3,9000);			
			System.out.println("Brazil message sent ");
			
			
			/**
			 * WARNING:
			 * --------
			 * 
			 *  You must send the JMSPriority at the moment that you send the message
			 *  The message.setJMSPriority dosent works.
			 * 
			 */			
			
			MessageConsumer comsumer = session.createConsumer(destination," JMSPriority >= 4 ");			
			TextMessage msgReceived = null;
			for(;;){
				msgReceived = (TextMessage) comsumer.receive(3000);
				if (msgReceived!=null)
					System.out.println("Message Received: " + msgReceived.getText() + " JMSPriority: " + msgReceived.getJMSPriority() );
				else
					System.out.println("no messages");
			}
						            
            
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
