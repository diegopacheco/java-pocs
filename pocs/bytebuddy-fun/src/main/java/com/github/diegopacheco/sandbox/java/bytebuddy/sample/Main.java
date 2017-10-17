package com.github.diegopacheco.sandbox.java.bytebuddy.sample;

import java.util.function.Function;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

class Foo {
   public String foo() { return null; };
}


class ToStringInterceptor {
	  public static String intercept() {
	    return "Hello World!";
	  }
}

public class Main {
	public static void main(String[] args) throws Throwable{
		
		DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
				.subclass(Object.class)
				.make();
		System.out.println(dynamicType);
		
		DynamicType.Unloaded<?> dynamicType2 = new ByteBuddy()
				  .subclass(Object.class)
				  .name("example.Type")
				  .make();
		System.out.println(dynamicType2);
		
		DynamicType.Unloaded<?> dynamicType3 = new ByteBuddy()
				  .with(new NamingStrategy.AbstractBase() {
					@Override
					protected String name(TypeDescription superClass) {
						return "i.love.ByteBuddy." + superClass.getSimpleName();
					}
				  })
				  .subclass(Object.class)
				  .make();
		System.out.println(dynamicType3);
		
		
		String toString = new ByteBuddy()
				  .subclass(Object.class)
				  .name("example.Type")
				  .make()
				  .load(Main.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
				  .getLoaded()
				  .newInstance() // Java reflection API
				  .toString();
		System.out.println(toString);
		
		Object dynamicType4 = new ByteBuddy()
				  .subclass(Object.class)
				  .method(ElementMatchers.named("toString"))
				  .intercept(FixedValue.value("Hello World!"))
				  .make()
				  .load(Main.class.getClassLoader(),          
				        ClassLoadingStrategy.Default.WRAPPER)
				  .getLoaded().newInstance();
		System.out.println(dynamicType4.toString());
		
		
		Function dynamicType5 = new ByteBuddy()
				  .subclass(java.util.function.Function.class)
				  .method(ElementMatchers.named("apply"))
				  .intercept(FixedValue.value("Hello World! FOO FOO !!! "))
				  .make()
				  .load(Main.class.getClassLoader(),ClassLoadingStrategy.Default.WRAPPER)
				  .getLoaded()
				  .newInstance();
		System.out.println(dynamicType5.apply("hi"));
	}
}
