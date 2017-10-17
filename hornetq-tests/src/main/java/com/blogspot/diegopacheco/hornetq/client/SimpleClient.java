package com.blogspot.diegopacheco.hornetq.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.integration.transports.netty.NettyConnectorFactory;

/**
 * Classe cliente de testes com o HornetQ standalone
 * 
 * @author Diego Pacheco
 * @version 1.0
 * @since 20/02/2010
 *
 */
public class SimpleClient {
	public static void main(String[] args) throws Throwable {

		TransportConfiguration transportConfiguration = new TransportConfiguration(NettyConnectorFactory.class.getName());
		ConnectionFactory cf  = null; 		
		Connection connection = null; 
		Session session       = null; 
		
		try {
			
			cf 		   = HornetQJMSClient.createConnectionFactory(transportConfiguration);
			connection = cf.createConnection();			
			Queue fila = HornetQJMSClient.createQueue("filaDeTestes");			
			
			connection.setClientID("javaClientBR");
			
			session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			
			MessageProducer producer = session.createProducer(fila);
			MessageConsumer consumer = session.createConsumer(fila);
			
			connection.start();
			
			TextMessage message = session.createTextMessage("Teste Diego Pacheco MSG " + System.currentTimeMillis());
			message.setJMSPriority(9);
			message.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
			message.setStringProperty("metadataapptoken", "xapp2mda0");
			producer.send(message);
			
			TextMessage receivedMessage =(TextMessage)consumer.receive();
			System.out.println("MSG Recebida:" + receivedMessage.getText());
						
		}catch(Exception e){
			System.out.println(e.getMessage());			
		}finally{
			if(session!=null) session.close();
			if(connection!=null) connection.close();	
		}	
		
	}
}
