package com.github.diegopacheco.sandbox.java.guice4.servlet.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

public class GenericCommand extends HystrixCommand<String> {

    private final String name;

    public GenericCommand(String name) {
    	super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(name)).andCommandKey(HystrixCommandKey.Factory.asKey(name)));
    	this.name = name;
    }

    @Override
    protected String run() {
        throw new RuntimeException(name + " - You need override this command and provide proper impl. ");
    }
}