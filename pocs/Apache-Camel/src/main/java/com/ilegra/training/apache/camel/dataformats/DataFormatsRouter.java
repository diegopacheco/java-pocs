package com.ilegra.training.apache.camel.dataformats;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class DataFormatsRouter extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		// XML 
		
		from("file://C:/tmp/dataformats/in?delete=true").
			to("activemq:queue:dtfmts.queue");			
		
		from("activemq:queue:dtfmts.queue").
		 	unmarshal().xstream().
		 	bean( new SimpleHandler(), "handlePojo" ).
		 	marshal().xstream().
		 	to("file://C:/tmp/dataformats/out");
		
		// JSON 
		
		from("file://C:/tmp/dataformats-json/in?delete=true").
			to("activemq:queue:dtfmts-json.queue");			
		
		from("activemq:queue:dtfmts-json.queue").
			unmarshal().json(JsonLibrary.XStream).
		 	bean( new SimpleHandler(), "handlePojo" ).
		 	marshal().json(JsonLibrary.XStream).
		 	to("file://C:/tmp/dataformats-json/out");
		
	}

}
