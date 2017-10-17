package com.blogspot.diegopacheco.ejb.interceptor;

import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class SpringBeanAutowiringInterceptorMod extends SpringBeanAutowiringInterceptor{
	
	@Override
	protected String getBeanFactoryLocatorKey(Object target) {
		return "sac";
	}
	
}
