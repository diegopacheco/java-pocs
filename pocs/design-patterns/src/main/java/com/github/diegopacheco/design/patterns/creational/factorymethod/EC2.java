package com.github.diegopacheco.design.patterns.creational.factorymethod;

public class EC2 extends CloudService{
    @Override
    Double getHourCost() {
        return 12.2;
    }
}
