package com.github.diegopacheco.design.patterns.structural.proxy;

public class IDGeneratorFactory {

    public IDGenerator create(){
        IDGenerator generator = new DatabaseIDGenerator();
        IDGenerator proxy = new Proxy(generator);
        return proxy;
    }

}
