package com.github.diegopacheco.sandbox.java.gdrl.guice.logger;

import java.lang.reflect.Field;
import org.slf4j.Logger;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
 
public class SLF4JTypeListener implements TypeListener {
    public <T> void hear(TypeLiteral<T> typeLiteral, TypeEncounter<T> typeEncounter) {
        for (Field field : typeLiteral.getRawType().getDeclaredFields()) {
            if (field.getType() == Logger.class && field.isAnnotationPresent(Log.class)) {
                typeEncounter.register(new SLF4JMembersInjector<T>(field));
            }
        }
    }
}