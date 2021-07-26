package com.github.diegopacheco.design.patterns.behavioral.chain_of_responsability;

public class LogHandler implements Handler{

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
        System.out.println("Logging: " + context);
        if(null!=next) next.run(context);
    }
}
