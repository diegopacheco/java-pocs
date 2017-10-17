package org.blogspot.diegopacheco.camel;

import org.apache.camel.Consume;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.component.jms.JmsQueueEndpoint;
import org.blogspot.diegopacheco.spring.UKBorderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class PojoMessageConsumer {
	
	@Autowired
	private UKBorderServiceImpl service;
	
	@Autowired
	private PojoMessageProducer pmp;
	
	@Autowired
	private ConsumerTemplate ct;
	
	@EndpointInject(uri = "activemq:queue:ws_rr_queue_out")
    private JmsQueueEndpoint jmsqe;
	
	@Consume(uri = "activemq:queue:ws_rr_queue_in")
	public void consumeJmsMessageInvokeServiceAndReponse(String msg) {
		
		System.out.println("Recived MSG: " + msg);
		
		String result = service.enter("1", "Fulano", "Cuba");
		
		pmp.sendMessageOut(result);
		
	}
	
	public String consumeJmsMessageOut() {
		// wait for a response from JMS		
		Exchange e = ct.receive(jmsqe);
		System.out.println( "queue out: " + e );
		return e.toString();
	}
	
}
