package com.github.diegopacheco.design.patterns._extra.lazy_loading;

public class HeavyWeightDAO {

    public Object loadExpensive(){
        try{
            Thread.sleep(5000L);
            return new Object();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
