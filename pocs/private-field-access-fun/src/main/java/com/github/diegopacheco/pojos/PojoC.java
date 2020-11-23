package com.github.diegopacheco.pojos;

import java.util.Date;

public class PojoC {

    private Date date = new Date();

    private void dontCallMeNow(){
        System.out.println("dammit!");
    }

    @Override
    public String toString() {
        return "PojoC{" +
                "date=" + date +
                '}';
    }
}
