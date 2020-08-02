package com.github.diegopacheco.javapocs.effectivejava3.singleton;

import java.io.Serializable;

/*
* Not the Singleton on the book because that one has several issues.
* */
public class Singleton implements Serializable {

    private volatile static Singleton INSTANCE;

    private Singleton(){}

    public static Singleton getInstance(){
        if (null==INSTANCE){
            synchronized (Singleton.class){
                if (null==INSTANCE){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

}
