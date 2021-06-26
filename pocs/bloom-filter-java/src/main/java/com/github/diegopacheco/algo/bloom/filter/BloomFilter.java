package com.github.diegopacheco.algo.bloom.filter;

public interface BloomFilter<T> {
    void add(T value);
    boolean mightContain(T value);
}
