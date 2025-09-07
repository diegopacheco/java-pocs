package com.github.diegopacheco.fp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HighOrderFunctions {

    @FunctionalInterface
    static interface Fn<A,B> {
        B apply(A a);

        default <C> HighOrderFunctions.Fn<A,C> andThen(HighOrderFunctions.Fn<B,C> next){
            return a -> next.apply(apply(a));
        }

        static <T> HighOrderFunctions.Fn<T,T> identity(){
            return x -> x;
        }
    }

    static <A,R> Fn<A,R> memoize(Fn<A,R> f){
        Map<A,R> cache = new ConcurrentHashMap<>();
        return a -> cache.computeIfAbsent(a, f::apply);
    }

    public int factorial6(){
        Fn<Integer,Integer> fact = memoize(new Fn<Integer,Integer>() {
            @Override
            public Integer apply(Integer n) {
                if (n == 0) return 1;
                return n * this.apply(n - 1);
            }
        });
          return fact.apply(6);
    }

}
