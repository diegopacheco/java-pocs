package com.blogspot.diegopacheco.camel.pojo;

import org.apache.camel.Consume;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;

public class DataBean {
	
    @Produce(uri = "activemq:queue:QDados")
    ProducerTemplate producer;

    @Consume(uri = "file:src/main/data?noop=true")
    public void onFileSendToQueue(String body) {
        producer.sendBody(body);       
    }
	
}
