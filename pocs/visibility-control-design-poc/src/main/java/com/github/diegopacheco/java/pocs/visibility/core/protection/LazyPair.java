package com.github.diegopacheco.java.pocs.visibility.core.protection;

class LazyPair<T>{
    private String key;
    private T value;

    public LazyPair(String key,T value){
        this.key=key;
        this.value=value;
    }
    public String getKey() {
        return key;
    }
    public T getValue() {
        return value;
    }
}