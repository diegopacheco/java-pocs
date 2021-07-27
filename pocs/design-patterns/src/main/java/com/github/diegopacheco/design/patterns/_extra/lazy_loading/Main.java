package com.github.diegopacheco.design.patterns._extra.lazy_loading;

public class Main {
    public static void main(String[] args) {
        LazyLoader lazyLoader = new LazyLoader();
        Object result = lazyLoader.getHeavy().get();
        System.out.println(result);
        System.out.println(lazyLoader.getHeavy().get());
        System.out.println(lazyLoader.getHeavy().get());
    }
}
