package com.github.diegopacheco.design.patterns._extra.marker;

public class CodeV1 implements Code {

    @Override
    public void run(){
        System.out.println("running code v1");
    }

    @Override
    public String toString() {
        return "CodeV1{}";
    }

}
