package com.github.diegopacheco.design.patterns.behavioral.chain_of_responsability;

public class ProfanityHandler implements Handler{

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
        String message = context.toString().replaceAll("dammit","****");
        if(null!=next) next.run(message);
    }
}
