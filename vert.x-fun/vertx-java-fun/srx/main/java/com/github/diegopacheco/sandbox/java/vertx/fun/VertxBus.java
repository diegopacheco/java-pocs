package com.github.diegopacheco.sandbox.java.vertx.fun;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.platform.Verticle;

@SuppressWarnings("rawtypes")
public class VertxBus extends Verticle {
	
	@Override
	public void start() {
		EventBus eb = vertx.eventBus();

		Handler<Message> myHandler = new Handler<Message>() {
		    public void handle(Message message) {
		        System.out.println("I received a message " + message.body());
		    }
		};

		eb.registerHandler("test.address", myHandler);
		
		eb.publish("test.address", "hello world");
		eb.publish("test.address", "hello world");
		eb.publish("test.address", "hello world");
		eb.publish("test.address", "hello world");
	}
}
