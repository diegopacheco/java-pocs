package com.github.diegopacheco.functional.interfaces.highorderfunctions;

import java.util.function.Function;

public class HighOrderApp {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Function<Integer, Integer> square = t -> t * t;
        Function<Integer, Integer> cube = t -> t * t * t;

        System.out.println("square *****");
        for(int i = 0; i < array.length; i++){
            print(square, array[i]);
        }
        System.out.println("cube *****");
        for(int i = 0; i < array.length; i++){
            print(cube, array[i]);
        }
    }

    private static <T, R> void print(Function<T, R> function, T t ) {
        System.out.println(function.apply(t));
    }
}
