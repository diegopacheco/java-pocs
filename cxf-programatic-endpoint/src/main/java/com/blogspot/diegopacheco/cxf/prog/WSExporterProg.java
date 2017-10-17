package com.blogspot.diegopacheco.cxf.prog;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class WSExporterProg {
	
	public void export(){		
	
//      Works... but dont list the services in webbrowser.
		
		DateServiceImpl implementor = new DateServiceImpl();
		
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(DateService.class);
		svrFactory.setServiceBean(implementor);
		svrFactory.setBus(BusFactory.getDefaultBus());
		svrFactory.getInInterceptors().add(new LoggingInInterceptor());
		svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
		svrFactory.create();
		svrFactory.getFeatures();
		Endpoint.publish("/ds", implementor);
		
//		DateServiceImpl implementor = new DateServiceImpl();
//		
//		System.out.println("Publishing WS by code... ");
//		
//		Bus bus =  BusFactory.getDefaultBus();
//		BusFactory.setDefaultBus(bus); 
//		Endpoint.publish("/ds", implementor);
//		
//		System.out.println("WS Publishing done. ");
		
	}
	
}
