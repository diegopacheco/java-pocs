package org.blogspot.diegopacheco.camel;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;

public class PojoMessageProducer {

	@Produce(uri = "activemq:queue:ws_rr_queue_in")
	private ProducerTemplate jmsProducerIn;

	@Produce(uri = "activemq:queue:ws_rr_queue_out")
	private ProducerTemplate jmsProducerOut;
	
	public void sendMessageIn(String body) {
		jmsProducerIn.sendBody(body);
	}

	public void sendMessageOut(String body) {
		jmsProducerOut.sendBody(body);
	}

}
