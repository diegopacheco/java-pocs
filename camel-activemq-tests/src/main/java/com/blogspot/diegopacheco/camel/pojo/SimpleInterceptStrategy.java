package com.blogspot.diegopacheco.camel.pojo;

import org.apache.camel.CamelContext;
import org.apache.camel.Processor;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.spi.InterceptStrategy;

public class SimpleInterceptStrategy implements InterceptStrategy {

	@Override
	public Processor wrapProcessorInInterceptors(CamelContext context,
			ProcessorDefinition<?> definition, Processor target,
			Processor nextTarget) throws Exception {
		return nextTarget;
	}
}
