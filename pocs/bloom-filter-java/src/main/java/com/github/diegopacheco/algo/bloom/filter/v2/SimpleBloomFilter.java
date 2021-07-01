package com.github.diegopacheco.algo.bloom.filter.v2;

import com.github.diegopacheco.algo.bloom.filter.BloomFilter;

import java.util.List;
import java.util.function.ToIntFunction;

/**
 * Huge time and memory savings compared with Trees, Tries, HashTables, Arrays, Sets.
 *
 * SimpleBloomFilter will do: First insert them item them(add) them check(mightContain).
 *
 * A HASH will be MAPPED to a POSITION into a BIT Array(which will have):
 *  BIG NUMBER meaning the value might be present
 *  0 meaning the value for sure is not present
 */
public class SimpleBloomFilter<T> implements BloomFilter<T> {

    // a bit array of m(size) bits
    private final long[] array;

    /*
    * size need to be 1,2,4,8,16,32,64,128,256,512,1024,2048,4096...
    **/
    private final int size;

    // Hash Functions
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
            if (Integer.bitCount(size) != 1){
                throw new IllegalArgumentException("Consider size being " +
                        "1,2,4,8,16,32,64,128,256,512,1024,2048,4096... Where Integer.bitCount(size) == 1 ");
            }
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

    //
    // >>> bitwise unsigned right shift - Shifts the bits of the number to the right and fills 0 on voids left as a result.
    // The leftmost bit is set to 0. (>>>) is unsigned-shift; it’ll insert 0. (>>) is signed, and will extend the sign bit.
    //
    // <<  bitwise left shift - Shifts the bits of the number to the left and fills 0 on voids left as a result.
    // Similar effect as of multiplying the number with some power of two.
    //
    // |=  bitwise or (a |= b; same as a = (a | b);) - Bitwise OR (|) This operator is a binary operator,
    // denoted by ‘|’. It returns bit by bit OR of input values, i.e,
    // if either of the bits is 1, it gives 1, else it gives 0.
    //
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
}
