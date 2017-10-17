package com.ilegra.training.jms.activemq.messaging.features;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;
import org.apache.activemq.command.ActiveMQBlobMessage;

import com.ilegra.training.jms.activemq.broker.EmbedBroker;

public class BlobMessagesSample {

	public static void main(String[] args) {

		EmbedBroker.start();

		ActiveMQConnection connection = null;
		ActiveMQSession session = null;

		try {
			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(EmbedBroker.getBrokerURL());

			connection = (ActiveMQConnection) cf.createConnection();
			connection.start();
			session = (ActiveMQSession) connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("queueBlobLondon");

			MessageProducer producer = session.createProducer(destination);
			BlobMessage message = session.createBlobMessage(new URL("http://www.ilegra.com"));
			producer.send(message);

			MessageConsumer comsumer = session.createConsumer(destination);
			comsumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					System.out.println("ops here cames the message!");
					if (message instanceof ActiveMQBlobMessage) {
						BlobMessage blobMessage = (BlobMessage) message;
						InputStream in = null;
						try {
							in = blobMessage.getInputStream();
							System.out.println(convertStreamToString(in));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String convertStreamToString(InputStream is) throws IOException {
		if (is != null) {
			StringBuilder sb = new StringBuilder();
			String line;
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "UTF-8"));
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n");
				}
			} finally {
				is.close();
			}
			return sb.toString();
		} else {
			return "";
		}
	}

}
