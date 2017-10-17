package com.github.diegopacheco.sandbox.java.junit.runner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

import com.github.diegopacheco.sandbox.java.junit.test.runner.DateLogger;

public class SimpleRunner extends BlockJUnit4ClassRunner{

	private Map<String, String> actions;
	
	public SimpleRunner(Class<?> klass) throws InitializationError {
		super(klass);
		System.out.println(klass);
	}
	
	@Override
	protected TestClass createTestClass(Class<?> testClass) {
		actions = new HashMap<>();
		TestClass tc = super.createTestClass(testClass); 
		System.out.println("TC: => " + tc);
		for(Method m :  tc.getJavaClass().getDeclaredMethods()){
			if (containsAnnotation(DateLogger.class, m.getDeclaredAnnotations())){
				actions.put(m.getName(), m.getDeclaredAnnotation(DateLogger.class).message());
			}
		}
		return tc;
	}
	
	private boolean containsAnnotation(Class<?> annotation,Annotation[] array){
		 for(Annotation a: array){
			 if (annotation.isAssignableFrom(a.getClass())) return true;
		 }
		 return false;
	}
	
	@Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
		System.out.println("OBJ: " + test);
		System.out.println("Before: " + method.getName());
		
		if (actions.get(method.getName())!=null)
			System.out.println(new Date().toString() + " -> "  + actions.get(method.getName()));
		
		Statement s = super.methodInvoker(method, test);
		System.out.println("After: " + method.getName());
		return s;
	}
	
}
