package com.github.diegopacheco.algo.bloom.filter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.ToIntFunction;

public class IntObjectsHash implements ToIntFunction<Integer> {
    @Override
    public int applyAsInt(Integer value) {
        int hash = Objects.hash(value);
        return hash;
    }
    public static List<ToIntFunction<Integer>> build(){
        return Arrays.asList(new IntObjectsHash());
    }
}
