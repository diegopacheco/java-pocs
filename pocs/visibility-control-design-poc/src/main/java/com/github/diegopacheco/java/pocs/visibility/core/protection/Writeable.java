package com.github.diegopacheco.java.pocs.visibility.core.protection;

interface Writeable<T> {
    default void set(String key,T value){}
}
