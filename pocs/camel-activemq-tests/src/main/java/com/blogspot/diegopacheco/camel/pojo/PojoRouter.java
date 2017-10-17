package com.blogspot.diegopacheco.camel.pojo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class PojoRouter extends RouteBuilder {

	@Autowired
	private Worker worker;
	
	@Autowired
	private BeanErrorHandler error;

	@Override
	public void configure() throws Exception {
		
//		from("file:src/main/data?noop=true").
//			to("jms:amq.filaA").
//			addInterceptStrategy(new SimpleInterceptStrategy());
//		
//		from("jms:amq.filaA").
//			to("log:com.blogspot.diegopacheco.camel?showAll=true&multiline=true").
//			bean(worker);
		
//		errorHandler(deadLetterChannel("jms:queue/errors"));
//	
//		from("file://C://temp//data?noop=true").
//			doTry().
//				marshal().string("UTF-8").
//				to("jms:amq.filaA").				
//			doCatch(Exception.class).
//				bean(error).
//				to("jms:queue/errors").
//			end();	
//			
//		from("jms:amq.filaA").
//			doTry().
//				unmarshal().string("UTF-8").
//				bean(worker).
//			doCatch(Exception.class).
//				bean(error).
//				to("jms:queue/errors").				
//			end();	
		
		//errorHandler(deadLetterChannel("jms:queue/errors"));
		
		
		from("jms:drugs").to("file://C:");
		
		//from("file://C://temp//data?noop=true").
			//doTry().
			//	marshal().string("UTF-8").
				//to("jms:drugs").
			//	bean(worker);
			//doCatch(Exception.class).
				//bean(error).
				//to("jms:queue/errors").
			//end();
		
	}

}
