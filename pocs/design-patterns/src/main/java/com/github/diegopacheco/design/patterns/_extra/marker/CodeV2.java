package com.github.diegopacheco.design.patterns._extra.marker;

public class CodeV2 implements Code, Active{

    @Override
    public void run(){
        System.out.println("running code v2");
    }

    @Override
    public String toString() {
        return "CodeV2{}";
    }

}
