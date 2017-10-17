package com.github.diegopacheco.sandbox.java.netflixoss.governator.poc;

import java.util.concurrent.atomic.AtomicInteger;
import com.google.inject.Binder;
import com.netflix.governator.annotations.AutoBind;
import com.netflix.governator.guice.AutoBindProvider;

public class ExampleAutoBindProvider implements AutoBindProvider<AutoBind>{
    
	private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void configure(Binder binder, AutoBind annotation){
        String value = annotation.value() + " - " + counter.incrementAndGet();
        binder.bind(String.class).annotatedWith(annotation).toInstance(value);
    }
}