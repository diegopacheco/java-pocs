package com.blogspot.diegopacheco.cglib.playground.command.ws;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BaseCGLibEnhacer implements MethodInterceptor {

	private static BaseCGLibEnhacer callback = new BaseCGLibEnhacer(); 
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {

		Object retVal = null;
		String name = method.getName();
		if (name.equals("execute")) {
			System.out.println("Proxy tela: " + obj);
			retVal = "sente essa poletto!";
		}
		return retVal;
	}

	@SuppressWarnings("unchecked")
	public static Object newInstance(Class clazz) {
		try {
			Enhancer e = new Enhancer();
			e.setSuperclass(clazz);
			e.setCallback(callback);
			return e.create();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

	}

}