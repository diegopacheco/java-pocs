package com.github.diegopacheco.sandboxspring.client;

public class Client implements Contract{

    private static volatile Client INSTANCE;
    private static Contract implementation = new ProxyImpl();

    private Client(){}

    public static Client getInstance(){
        if (null==INSTANCE){
            synchronized (Client.class){
                if (null==INSTANCE){
                    INSTANCE = new Client();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Double sum(Double va, Double vb) {
        return implementation.sum(va,vb);
    }

    @Override
    public Double mul(Double va, Double vb) {
        return implementation.mul(va,vb);
    }

}
