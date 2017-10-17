package com.ilegra.training.jms.activemq.nothing;

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
import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.kahadaptor.KahaPersistenceAdapter;

public class EmbedBrokerAQwitter {

	public static void runAsMain() {
		BrokerService broker = new BrokerService();
		try {
			broker.setUseJmx(true);
			broker.setBrokerName("pachecoMessageBrokerAQwiter");

			broker.addConnector("tcp://localhost:80");
			broker.setPersistenceAdapter(new KahaPersistenceAdapter());

			broker.setPlugins(new BrokerPlugin[] { new AQTwitterBrokerPlugin() });
			broker.start();

			System.out.println("Broker started fine, redy to use!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void sendMessage(String msg) {
		TopicConnection connection = null;
		TopicSession session = null;

		try {
			TopicConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:80");

			connection = (TopicConnection) cf.createConnection();
			connection.setClientID("AQwitterDurSubConnclientID");
			connection.start();
			session = connection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic("AQwitterTopic");

			TopicPublisher producer = session.createPublisher(topic);

			TextMessage txtMessage = session.createTextMessage();
			txtMessage.setStringProperty("AQwitterUSER", "diego_pacheco");
			txtMessage.setText(msg);
			producer.publish(txtMessage);
			System.out.println("message sent");

			TopicSubscriber comsumer = session.createDurableSubscriber(topic,"AQwitterDurSub");
			comsumer.setMessageListener(new MessageListener() {
				public void onMessage(javax.jms.Message message) {
					try {
						System.out.println("msg: " + message);
						if (message instanceof TextMessage) {
							System.out.println(((TextMessage) message).getText() + " user: "
											 + ((TextMessage) message).getStringProperty("AQwitterUSER"));
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

	public static void main(String[] args) {
		EmbedBrokerAQwitter.runAsMain();
		EmbedBrokerAQwitter.sendMessage("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
									  + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
									  + "AAAAAAAAAAAABBBBBBBCCCCCCCDDDDDZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
	}
}
