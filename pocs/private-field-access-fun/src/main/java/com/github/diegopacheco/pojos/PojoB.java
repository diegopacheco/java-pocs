package com.github.diegopacheco.pojos;

public class PojoB {

    private int value = 42;
    private PojoC pojoc = new PojoC();

    @Override
    public String toString() {
        return "PojoB{" +
                "value=" + value +
                ", pojoc=" + pojoc +
                '}';
    }
}
