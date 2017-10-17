package org.blogspot.diegopacheco.ws;

import javax.jws.WebService;

import org.blogspot.diegopacheco.camel.PojoMessageConsumer;
import org.blogspot.diegopacheco.camel.PojoMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;

@WebService(endpointInterface = "org.blogspot.diegopacheco.ws.BorderService")  
public class UKBorderService implements BorderService{
	
	@Autowired
	private PojoMessageProducer pmp;
	
	@Autowired
	private PojoMessageConsumer pmc;
		
	@Override
	public String enter(String ID, String name, String fromCountry) {
		
		// Send a message to JMS
		String message = "{id:" + ID +",name:" + name + ",fromCountry:" + fromCountry + "}";		 
		pmp.sendMessageIn(message);
		
		String messageResult = pmc.consumeJmsMessageOut();	
		
		return messageResult;
	}
	
}
