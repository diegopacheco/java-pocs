package com.github.diegopacheco.design.patterns.creational.singleton;

import java.util.Date;

public class DateLoggerSingleton {

    private static DateLoggerSingleton INSTANCE;

    private DateLoggerSingleton(){}

    public static DateLoggerSingleton getInstance(){
        if (null==INSTANCE){
            synchronized (DateLoggerSingleton.class){
                if (null==INSTANCE){
                    INSTANCE=new DateLoggerSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public void log(String message){
        System.out.println(new Date() + " - " + message);
    }

}
