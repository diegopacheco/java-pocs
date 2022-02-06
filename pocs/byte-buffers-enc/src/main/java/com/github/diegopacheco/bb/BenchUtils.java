package com.github.diegopacheco.bb;

import java.util.function.Supplier;

public class BenchUtils {

     public static <T> T bench(Supplier<T> supplier){
        long init = System.currentTimeMillis();
        T result = supplier.get();
        long end = System.currentTimeMillis();
        System.out.println((end-init) + " ms");
        return result;
    }

}
