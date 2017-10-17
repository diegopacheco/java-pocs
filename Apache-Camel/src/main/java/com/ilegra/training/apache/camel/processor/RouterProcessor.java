package com.ilegra.training.apache.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class RouterProcessor extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("file://C:/tmp/processor/in?delete=true").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				String payload = exchange.getIn().getBody(String.class);
				exchange.getIn().setBody("Body Changed. Original: " + payload);
			}
		}).to("file://C:/tmp/processor/out");

	}

}
