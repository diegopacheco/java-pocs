package com.github.diegopacheco.sandbox.java.props;

import java.util.Properties;

public class ThreadLocalProp {

    private ThreadLocal<Properties> threadLocal = new ThreadLocal<Properties>(){
        @Override
        protected Properties initialValue() {
            return System.getProperties();
        }
    };

    public void set(String key,String value){
        threadLocal.get().setProperty(key,value);
    }

    public String get(String key){
        return threadLocal.get().getProperty(key);
    }

}
