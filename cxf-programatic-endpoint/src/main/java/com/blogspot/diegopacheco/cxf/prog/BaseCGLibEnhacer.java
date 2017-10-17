package com.blogspot.diegopacheco.cxf.prog;

import java.lang.reflect.Method;
import java.util.Date;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BaseCGLibEnhacer implements MethodInterceptor {

	private static BaseCGLibEnhacer callback = new BaseCGLibEnhacer(); 
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
		Object retVal = null;
		String name = method.getName();
		if (name.equals("checkCurrentDate")) {
			retVal = new Date().toString() + " CGLIB added.";
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