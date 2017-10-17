package com.github.diegopacheco.sandbox.java.netflixoss.governator.poc.exs;

import javax.inject.Inject;

import com.netflix.governator.annotations.AutoBind;

public class ExampleObjectB{
    
	private final String value;

    @Inject
    public ExampleObjectB(@AutoBind("letter B")String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}