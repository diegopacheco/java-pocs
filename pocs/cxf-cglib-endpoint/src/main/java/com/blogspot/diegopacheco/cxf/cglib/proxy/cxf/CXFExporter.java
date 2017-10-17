package com.blogspot.diegopacheco.cxf.cglib.proxy.cxf;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.blogspot.diegopacheco.cxf.cglib.proxy.CXFCGLibEnhancer;
import com.blogspot.diegopacheco.cxf.cglib.proxy.OperationCallback;

/**
 * 
 * @author Diego Pacheco
 *
 */
@SuppressWarnings("unchecked")
public class CXFExporter {
	
	private String serviceUrl;
	private Class contractClass;
	private CXFCGLibEnhancer cxfCglib;
	
	public void export(){
		
		Object endpointImplementor = cxfCglib.newInstance( contractClass ,						
				new OperationCallback() {							
					
					@Override
					public boolean isHandleable(String operationName) {
						return true;
					}							
					
					@Override
					public Object execute(String operationName, Object args) {
						return new String("ok");
					}
				}						
		);	
		
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(contractClass);
		svrFactory.setAddress("/" + serviceUrl);
		svrFactory.setServiceBean(endpointImplementor);
		svrFactory.create();
		
	}

	public void setContractClass(Class contractClass) {
		this.contractClass = contractClass;
	}
	public void setCxfCglib(CXFCGLibEnhancer cxfCglib) {
		this.cxfCglib = cxfCglib;
	}
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}	
	
}
