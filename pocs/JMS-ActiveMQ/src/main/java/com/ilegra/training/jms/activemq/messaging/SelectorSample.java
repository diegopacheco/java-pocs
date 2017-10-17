package com.ilegra.training.jms.activemq.messaging;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.ilegra.training.jms.activemq.broker.EmbedBroker;

public class SelectorSample {
	public static void main(String[] args) {
		
		EmbedBroker.start();
		
		Connection connection = null;
		Session    session    = null;
		
		try{
			ConnectionFactory cf  = new ActiveMQConnectionFactory(EmbedBroker.getBrokerURL());
			
			connection = cf.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 
            Destination destination  = session.createQueue("queueSelectorLondon");
            
            MessageProducer producer = session.createProducer(destination);
            
            TextMessage txtMessage = session.createTextMessage();
			txtMessage.setText( "MSG 1 - London" );	
			txtMessage.setJMSType("London");
			producer.send(destination,txtMessage);
			
			txtMessage = session.createTextMessage();
			txtMessage.setText( "MSG 2 - Italy " );
			txtMessage.setJMSType("Italy");
			producer.send(destination,txtMessage);
			
			txtMessage = session.createTextMessage();
			txtMessage.setText( "MSG 3 - Brazil " );
			txtMessage.setJMSType("Brazil");
			txtMessage.setStringProperty("superMSG", "YES");
			txtMessage.setJMSPriority(2);
			producer.send(destination,txtMessage);		
				
		    // JMSType = 'London' OR superMSG = 'YES'
			// supportJMSPriority="true"
			MessageConsumer comsumer = session.createConsumer(destination," JMSPriority = 2 ");			
			TextMessage msgReceived = null;
			for(;;){
				msgReceived = (TextMessage) comsumer.receive(3000);
				if (msgReceived!=null)
					System.out.println("Message Received: " + msgReceived.getText() + " JMSType: " + msgReceived.getJMSType() +
									   " superMSG: " + msgReceived.getStringProperty("superMSG"));
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
