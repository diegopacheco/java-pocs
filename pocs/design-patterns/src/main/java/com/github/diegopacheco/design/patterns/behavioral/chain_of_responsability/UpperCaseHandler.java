package com.github.diegopacheco.design.patterns.behavioral.chain_of_responsability;

import java.util.Locale;

public class UpperCaseHandler implements Handler{

    private Handler next;

    @Override
    public void add(Handler next) {
        if (null==this.next){
            this.next = next;
        }else{
            this.next.add(next);
        }
    }

    @Override
    public void run(Object context) {
        String message = context.toString().toUpperCase(Locale.ROOT);
        if(null!=next) next.run(message);
    }
}
