package com.github.diegopacheco.sandbox.java.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicSendApps {
	public static void main(String[] args) throws Throwable{
		
		String EXCHANGE_NAME = "topic_logs";
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.99.4.17");
		factory.setPort(5672);
		factory.setTopologyRecoveryEnabled(true);
		factory.setUsername("admin");
		factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String routingKey = "#";
        String message = "1#2#3";

        channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
        System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

        connection.close();
	}
}
