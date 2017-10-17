package com.github.diegopacheco.sandbox.java.gdrl.guice.logger;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.MembersInjector;

public class SLF4JMembersInjector<T> implements MembersInjector<T> {
	
    private final Field field;
    private final Logger logger;
 
    public SLF4JMembersInjector(Field field) {
        this.field = field;
        this.logger = LoggerFactory.getLogger(field.getDeclaringClass());
        field.setAccessible(true);
    }
 
    public void injectMembers(T t) {
        try {
            field.set(t, logger);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
	
}
