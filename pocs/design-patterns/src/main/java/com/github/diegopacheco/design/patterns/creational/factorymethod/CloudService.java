package com.github.diegopacheco.design.patterns.creational.factorymethod;

public abstract class CloudService {
    abstract Double getHourCost();

    public Double calculateBill(int hours){
        return hours*getHourCost();
    }
}
