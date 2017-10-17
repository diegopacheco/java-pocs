package com.blogspot.diegopacheco.hornetq.client;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.integration.transports.netty.NettyConnectorFactory;

public class TopicMessageListernerClient {
	public static void main(String[] args) throws Throwable {

		TransportConfiguration transportConfiguration = new TransportConfiguration(NettyConnectorFactory.class.getName());
		ConnectionFactory cf = null;
		Connection connection = null;
		Session session = null;

		try {

			cf = HornetQJMSClient.createConnectionFactory(transportConfiguration);
			connection = cf.createConnection();

			Topic topico = HornetQJMSClient.createTopic("topicoDeTestes");

			session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

			MessageConsumer consumer = session.createConsumer(topico);

			connection.start();

			consumer.setMessageListener(new MessageListener() {
				
				@SuppressWarnings("unchecked")
				public void onMessage(Message notif) {
				
					System.out.println("------------------------");
					System.out.println("Receivednotification:");
					
					try {
					
						Enumeration propertyNames = notif.getPropertyNames();
						while (propertyNames.hasMoreElements()) {
							String propertyName = (String) propertyNames.nextElement();
							System.out.format("%s:%s\n", propertyName, notif.getObjectProperty(propertyName));
						}
					} catch (JMSException e) { 
						e.printStackTrace();
					}
					System.out.println("------------------------");
				}
			});

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