package com.blogspot.diegopacheco.camel.pojo;

import org.apache.camel.Consume;
import org.apache.camel.RecipientList;
import org.apache.camel.language.XPath;

public class DataConsumer {

	@Consume(uri = "activemq:queue:QDados")
	@RecipientList
	public String[] route(@XPath("/person/city/text()") String city) {
		if (city.equals("London")) {
			return new String[] { "file:target/messages/londrinos" };
		} else {
			return new String[] { "file:target/messages/outros" };
		}
	}

}
