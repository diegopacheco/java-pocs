package com.blogspot.diegopacheco.cxf.cglib.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class CXFCGLibEnhancer {

	@SuppressWarnings("unchecked")
	public Object newInstance(Class clazz,final OperationCallback operationCallback) {

		try {
			Enhancer e = new Enhancer();
			e.setInterfaces(new Class[]{clazz});
			e.setSuperclass(clazz);
			
			e.setCallback(new MethodInterceptor() {				
				@Override
				public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
					
					if (operationCallback.isHandleable(method.getName())) {
						return operationCallback.execute(method.getName(),args);
					}
					throw new RuntimeException("[$CGLIB$] The operation[" + method.getName() + "] is not supported. ");					
				}
			});
			return e.create();
			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

	}

}