package com.blogspot.diegopacheco.hornetq.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.integration.transports.netty.NettyConnectorFactory;

public class QueueSenderClient {
	public static void main(String[] args) throws Throwable {

		TransportConfiguration transportConfiguration = new TransportConfiguration(NettyConnectorFactory.class.getName());
		ConnectionFactory cf = null;
		Connection connection = null;
		Session session = null;

		try {

			cf = HornetQJMSClient.createConnectionFactory(transportConfiguration);
			connection = cf.createConnection();

			Queue fila = HornetQJMSClient.createQueue("testQueue");

			session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			
			MessageProducer producer = session.createProducer(fila);			
			
			connection.start();
			
			TextMessage message = session.createTextMessage("Teste Diego Pacheco MSG " + System.currentTimeMillis());
			producer.send(message);
			
			System.out.println("Menssagem enviada para fila com sucesso.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null)
				session.close();
			if (connection != null)
				connection.close();
		}
	}
}
