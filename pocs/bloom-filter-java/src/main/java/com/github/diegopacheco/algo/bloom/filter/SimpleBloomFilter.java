package com.github.diegopacheco.algo.bloom.filter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.ToIntFunction;

public class SimpleBloomFilter<T> implements BloomFilter<T> {

    private final long[] array;
    private final int size;
    private final List<ToIntFunction<T>> hashFunctions;

    public SimpleBloomFilter(long[] array, int logicalSize, List<ToIntFunction<T>> hashFunctions) {
        this.array = array;
        this.size = logicalSize;
        this.hashFunctions = hashFunctions;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private int size;
        private List<ToIntFunction<T>> hashFunctions;

        public Builder<T> withSize(int size) {
            assert Integer.bitCount(size) == 1;
            this.size = size;
            return this;
        }

        public Builder<T> withHashFunctions(List<ToIntFunction<T>> hashFunctions) {
            this.hashFunctions = hashFunctions;
            return this;
        }

        public SimpleBloomFilter<T> build() {
            return new SimpleBloomFilter<>(new long[size >>> 6], size, hashFunctions);
        }
    }

    private int mapHash(int hash) {
        return hash & (size - 1);
    }

    @Override
    public void add(T value) {
        for (ToIntFunction<T> function : hashFunctions) {
            int hash = mapHash(function.applyAsInt(value));
            array[hash >>> 6] |= 1L << hash;
        }
    }

    @Override
    public boolean mightContain(T value) {
        for (ToIntFunction<T> function : hashFunctions) {
            int hash = mapHash(function.applyAsInt(value));
            if ((array[hash >>> 6] & (1L << hash)) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SimpleBloomFilter<Integer> bf = new Builder<Integer>()
                .withSize(2000) // need to be bigger enough because of >>> 6
                .withHashFunctions(Arrays.asList(new ToIntFunction(){
                    @Override
                    public int applyAsInt(Object value) {
                        int hash = Objects.hash(value);
                        return hash;
                    }
                })).build();

        bf.add(1);
        bf.add(2);
        bf.add(3);
        bf.add(4);
        bf.add(5);
        System.out.println("is 4 present? == " + bf.mightContain(4));
        System.out.println("is 6 present? == " + bf.mightContain(6));
    }

}
