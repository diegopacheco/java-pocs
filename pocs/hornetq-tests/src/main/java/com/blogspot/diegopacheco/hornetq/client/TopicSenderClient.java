package com.blogspot.diegopacheco.hornetq.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.integration.transports.netty.NettyConnectorFactory;

public class TopicSenderClient {
	public static void main(String[] args) throws Throwable {

		TransportConfiguration transportConfiguration = new TransportConfiguration(	NettyConnectorFactory.class.getName());
		ConnectionFactory cf = null;
		Connection connection = null;
		Session session = null;

		try {

			cf = HornetQJMSClient.createConnectionFactory(transportConfiguration);
			connection = cf.createConnection();

			Topic topico = HornetQJMSClient.createTopic("topicoDeTestes");

			session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

			MessageProducer producer = session.createProducer(topico);

			connection.start();

			TextMessage message = session.createTextMessage("Teste Diego Pacheco MSG " + System.currentTimeMillis() + " Tipico!");
			producer.send(message);			
	
			System.out.println("Messagem enviado com sucesso ao topic");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null)    session.close();
			if (connection != null)	connection.close();
		}
	}
}
