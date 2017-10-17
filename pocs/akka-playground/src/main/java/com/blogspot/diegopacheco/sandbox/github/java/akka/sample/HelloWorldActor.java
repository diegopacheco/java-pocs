package com.blogspot.diegopacheco.sandbox.github.java.akka.sample;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

/**
 * 
 * @author pacheco 
 * @since  12/12/2010
 * @version 1.0
 * 
 */
@SuppressWarnings("unchecked")
class HelloWorldActor extends UntypedActor {
	
	public void onReceive(Object msg) {
		if (msg instanceof String){
			
			logger().info("Akka Received String message: " + msg);

		}
	}
	
	public static void main(String[] args) {
		
		ActorRef actor = UntypedActor.actorOf(HelloWorldActor.class);
		actor.start(); 
		
		actor.sendOneWay("Hello Akka Kicks Ass");
		
	}
	
}
