package com.ilegra.training.apache.camel.routing.xml;


public class JavaSimpleFilter {
	
	public boolean isTweet(String body){
		boolean result = (body.contains("twitter") && body.contains("tweet"));
		System.out.println("filtering based on message body. Message: " + body + " is: " + result);		
		return result;
	}
	
}
