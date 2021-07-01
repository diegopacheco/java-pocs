package com.github.diegopacheco.algo.bloom.filter.v1;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class H1H2IntHash {

    private static class H1Hash implements ToIntFunction<Integer> {
        @Override
        public int applyAsInt(Integer value) {
            int hash = value % 5;
            return hash;
        }
    }

    private static class H2Hash implements ToIntFunction<Integer> {
        @Override
        public int applyAsInt(Integer value) {
            int hash = ((2 * value) + 3) % 5;
            return hash;
        }
    }

    public static List<ToIntFunction<Integer>> build() {
        return Arrays.asList(new H1Hash(), new H2Hash());
    }

}