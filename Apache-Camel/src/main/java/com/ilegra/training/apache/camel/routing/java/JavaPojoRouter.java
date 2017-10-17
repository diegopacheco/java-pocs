package com.ilegra.training.apache.camel.routing.java;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class JavaPojoRouter extends RouteBuilder {

	@Autowired
	private JavaSimpleFilter jsf;
	
	@Override
	public void configure() throws Exception {

		from("file://C:/tmp/twitter/in?delete=true").		
			to("log:com.ilegra.training.apache.camel?showAll=true&multiline=true").
			to("activemq:queue:twitter.queue");			
		
		from("activemq:queue:twitter.queue").
			filter().method(jsf, "isTweet").		
		    to("file://C:/tmp/twitter/out").
		    to("bean:javaBeanHandler?method=handle");
		
	}
	
}
