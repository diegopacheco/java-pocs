package com.github.diegopacheco.fp;

/**
 *
 * Monoid
 *
 * A monoid is an algebraic structure with a single associative binary operation
 * and an identity element.
 *
 * In simpler terms, a monoid consists of:
 *  1. empty -> a function that returns the identity element of the monoid.
 *  2. combine -> a binary operation that takes two elements of the monoid and
 *   combines them to produce another element of the same monoid.
 *
 */
public class Monoids {

    interface Monoid<T> {
        T empty();
        T combine(T a, T b);
        static Monoid<Integer> intSum(){
            return new Monoid<>() {
                public Integer empty(){ return 0; }
                public Integer combine(Integer a, Integer b){ return a + b; }
            };
        }
    }

    public Integer sumAll(){
        Integer[] values = new Integer[]{1,2,3,4,5};
        Monoid<Integer> m = Monoid.intSum();
        Integer result = m.empty();
        for (Integer v : values){
            result = m.combine(result, v);
        }
        return result;
    }

}
