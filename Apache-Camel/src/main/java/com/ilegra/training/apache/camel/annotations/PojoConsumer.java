package com.ilegra.training.apache.camel.annotations;

import org.apache.camel.Consume;

public class PojoConsumer {
	
	@Consume(uri = "activemq:queue:twitter.queue")
	public void consumeTweets(String msg){
		System.out.println("You Tweet: " + msg);
	}
}
