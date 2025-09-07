package com.github.diegopacheco.fp;

/**
 * Curry / Partial application
 *
 * Currying is the technique of translating the evaluation of a function
 * that takes multiple arguments into evaluating a sequence of functions,
 * each with a single argument.
 *
 * Curry allow partial application of functions. Which is a way of doing function composition.
 *
 */
public class Curry {

    @FunctionalInterface
    static interface Fn<A,B> {
        B apply(A a);

        default <C> Fn<A,C> andThen(Fn<B,C> next){
            return a -> next.apply(apply(a));
        }

        static <T> Fn<T,T> identity(){
            return x -> x;
        }
    }

    static Fn<Integer, Fn<Integer, Integer>> add() {
        return x -> y -> x + y;
    }

    public int sum(){
        Fn<Integer,Integer> inc = x -> x + 1;
        Fn<Integer,Integer> dbl = x -> x * 2;
        int r = inc.andThen(dbl).apply(5);     // (5+1)*2 = 12
        int curried = add().apply(2).apply(3); // 5
        return r + curried;
    }


}
