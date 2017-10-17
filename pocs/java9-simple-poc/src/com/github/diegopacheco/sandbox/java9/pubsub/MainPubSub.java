package com.github.diegopacheco.sandbox.java9.pubsub;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

public class MainPubSub {
	
	public static void main(String[] args) {
		
	    SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
	    
	    MySubscriber<String> subscriber = new MySubscriber<>();  
	    publisher.subscribe(subscriber);  
	  
	    //Publish items  
	    System.out.println("Publishing Items...");  
	    String[] items = {"1", "x", "2", "x", "3", "x"};  
	    Arrays.asList(items).stream().forEach(i -> publisher.submit(i));  
	    publisher.close(); 
		
	}
}
