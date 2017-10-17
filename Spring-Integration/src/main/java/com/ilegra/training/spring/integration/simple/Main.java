package com.ilegra.training.spring.integration.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.BeanFactoryChannelResolver;
import org.springframework.integration.channel.ChannelResolver;
import org.springframework.integration.channel.PollableChannel;
import org.springframework.integration.core.MessageChannel;
import org.springframework.integration.message.StringMessage;

/**
 * Main class to run this sample
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 04/05/2010
 * 
 */
public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-integration.xml");	
		main.performDemo(applicationContext);
		applicationContext.stop();
	}


	public void performDemo(ApplicationContext applicationContext) {
		ChannelResolver channelResolver = new BeanFactoryChannelResolver(applicationContext);
		
		MessageChannel  inputChannel  = channelResolver.resolveChannelName("inputChannel");
		PollableChannel outputChannel = (PollableChannel) channelResolver.resolveChannelName("outputChannel");
		
		inputChannel.send(new StringMessage("World"));
		inputChannel.send(new StringMessage("ilegra"));
		
		System.out.println("==> Message Received: " + outputChannel.receive(0).getPayload());
		System.out.println("==> Message Received: " + outputChannel.receive(0).getPayload());
	}

	
}
