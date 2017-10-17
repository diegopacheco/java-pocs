package com.blogspot.diegopacheco.spring.reflections.caller;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanReflectionCaller implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	public Object invokeSpring(String beanID,String beanMethod,Object args){
		
		Object result = null;
		Object serviceImpl  =  null;
		Method method = null;
		
		serviceImpl  = applicationContext.getBean(beanID);
		System.out.println("Spring real bean: " + serviceImpl);
		
		try {
			 method = serviceImpl.getClass().getDeclaredMethod(beanMethod, args.getClass());
		} catch (Exception e) {
			throw new RuntimeException("Method named: " + beanMethod + " not found! Ex: " + e.getMessage());
		}
		
		try {
			result = method.invoke(serviceImpl, args);
		} catch (Exception e) {
			throw new RuntimeException("Service invocation error. Service name: " + beanID  + 
										"Method named: " + beanMethod + " not found or Error to invoke! EX: " + e.getMessage());
		}
		
		System.out.println("Result Object from Spring Bean: " + result);
		return result;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
