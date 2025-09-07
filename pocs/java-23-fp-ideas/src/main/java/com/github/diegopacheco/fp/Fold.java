package com.github.diegopacheco.fp;

import java.util.function.BiFunction;

/**
 * Foldable
 *
 * foldable is a structure that can be reduced to a single value
 * foldLeft is a common operation that takes an initial value and a binary function
 * and applies the function to the initial value and the first element of the structure,
 * then takes the result and applies the function to it and the second element, and so on
 * until all elements have been processed.
 *
 */
public class Fold {

    static <A,B> B foldLeft(Iterable<A> it, B init, BiFunction<B,A,B> f){
        B acc = init;
        for(A a: it) acc = f.apply(acc,a);
        return acc;
    }

    public Integer sumAll(){
        Iterable<Integer> it = java.util.Arrays.asList(1,2,3,4,5);
        return foldLeft(it,0, Integer::sum);
    }

}
