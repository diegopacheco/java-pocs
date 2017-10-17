package com.github.diegopacheco.sandbox.java.cxf.spring;

import java.util.Arrays;

import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.github.diegopacheco.sandbox.java.cxf.rest.DateResource;

@Configuration
public class AppConfig {
	
	@Bean(destroyMethod = "shutdown")
	public SpringBus cxf() {
		return new SpringBus();
	}

	@Bean
	@DependsOn("cxf")
	public Server jaxRsServer() {
		final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(dateRestService(),JAXRSServerFactoryBean.class);
		factory.setServiceBeans(Arrays.asList(dateRestService()));
		factory.setProviders( Arrays.asList( jsonProvider() ) );
		return factory.create();
	}

	@Bean
	public JacksonJsonProvider jsonProvider() {
		return new JacksonJsonProvider();
	}

	@Bean
	public DateResource dateRestService() {
		return new DateResource();
	}

}
