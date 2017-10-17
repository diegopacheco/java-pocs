package com.ilegra.training.jms.activemq.messaging;

import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.ilegra.training.jms.activemq.broker.EmbedBroker;

public class SendReceiveTopicMessages {
	public static void main(String[] args) {
		
		EmbedBroker.start();
		
		TopicConnection connection = null;
		TopicSession session = null;

		try {
			TopicConnectionFactory cf = new ActiveMQConnectionFactory(EmbedBroker.getBrokerURL());

			connection = (TopicConnection) cf.createConnection();
			connection.setClientID("LondonDurSubConID");
			connection.start();
			session = connection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic("londonTopic");

			TopicPublisher producer = session.createPublisher(topic);

			TextMessage txtMessage = session.createTextMessage();
			txtMessage.setText("teste message topic.");
			producer.publish(txtMessage);
			System.out.println("message sent");

			TopicSubscriber comsumer = session.createDurableSubscriber(topic,"londonTopicDurSub");
			comsumer.setMessageListener(new MessageListener() {
				public void onMessage(javax.jms.Message message) {
					try {
						System.out.println("msg: " + message);
						if (message instanceof TextMessage) {
							System.out.println(((TextMessage) message).getText() );
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}	
