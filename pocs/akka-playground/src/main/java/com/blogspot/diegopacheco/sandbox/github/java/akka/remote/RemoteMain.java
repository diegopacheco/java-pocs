package com.blogspot.diegopacheco.sandbox.github.java.akka.remote;

import akka.actor.TypedActor;
import akka.remote.RemoteClient;
import akka.remote.RemoteServer;

/**
 * 
 * RemoteMain 
 *
 * @author pacheco
 * @version 1.0
 * @since 13/12/2010
 *
 */
public class RemoteMain {
	
	public static void main(String[] args) {
		
		// Server
		
		RemoteServer server = new RemoteServer();
		server.start("localhost", 2552);
		 
		DateActor typedActor = TypedActor.newInstance(DateActor.class, SystemDate.class, 2000);
		server.registerTypedActor("date-service", typedActor);

		//Client
		
		DateActor actor = RemoteClient.typedActorFor(DateActor.class, "date-service", 5000L, "localhost", 2552);
		String res =  actor.currentDate();
		
		System.out.println("Current Date: " + res);
		
	}
	
}
