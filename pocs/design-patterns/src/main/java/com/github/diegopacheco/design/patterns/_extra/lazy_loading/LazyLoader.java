package com.github.diegopacheco.design.patterns._extra.lazy_loading;

import java.util.function.Supplier;

public class LazyLoader {

    private Supplier<Object> heavy = this::createAndCacheHeavy;

    private synchronized Object createAndCacheHeavy() {

        class HeavyFactory implements Supplier<Object> {
            private final HeavyWeightDAO instance = new HeavyWeightDAO();
            private Object cache;

            @Override
            public Object get() {
                if (null==cache){
                    synchronized (instance){
                        if (null==cache){
                            cache=instance.loadExpensive();
                        }
                    }
                }
                return cache;
            }
        }

        if (!(heavy instanceof HeavyFactory)) {
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }

    public Supplier<Object>  getHeavy() {
        return heavy;
    }


}
