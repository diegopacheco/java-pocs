package com.ilegra.training.apache.camel.annotations;

import org.apache.camel.Consume;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.language.XPath;

public class PojoProducer {
	
	@Produce(uri = "activemq:queue:twitter.queue")
	private ProducerTemplate producerTwitter;
	
	@Consume(uri = "file://C:/tmp/twitter/in")
	public void tweetsAsFiles(@XPath("/twitter/user/text()")String user,
							  @XPath("/twitter/tweets/tweet/text()") String tweet){
		producerTwitter.sendBody(user + ": " + tweet);
	}
	
}
