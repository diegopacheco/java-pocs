package com.github.diegopacheco.fp;

import java.util.function.Function;

/**
 * Either Monad
 *
 * An Either is a type that represents a value of one of two possible types
 * (a disjoint union). An instance of Either is either an instance of Left or Right.
 *
 */
public class Monads {

    sealed interface Either<L,R> permits Left, Right {
        <T> T fold(Function<L,T> fl, Function<R,T> fr);

        static <L,R> Either<L,R> left(L v){
            return new Left<>(v);
        }
        static <L,R> Either<L,R> right(R v){
            return new Right<>(v);
        }
    }

    static final class Left<L,R> implements Either<L,R> {
        final L value;
        Left(L v){ value = v; }
        public <T> T fold(Function<L,T> fl, Function<R,T> fr){
            return fl.apply(value);
        }
        public String toString(){ return "Left(" + value + ")"; }
    }

    static final class Right<L,R> implements Either<L,R> {
        final R value;
        Right(R v){ value = v; }
        public <T> T fold(Function<L,T> fl, Function<R,T> fr){
            return fr.apply(value);
        }
        public String toString(){ return "Right(" + value + ")"; }
    }

    public int result(){
        Either<String,Integer> e = Either.right(42);
        return e.fold(l -> 0, r -> r);
    }


}
