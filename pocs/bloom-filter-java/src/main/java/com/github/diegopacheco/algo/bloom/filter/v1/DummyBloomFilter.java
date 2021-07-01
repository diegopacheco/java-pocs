package com.github.diegopacheco.algo.bloom.filter.v1;

import com.github.diegopacheco.algo.bloom.filter.BloomFilter;

import java.util.List;
import java.util.function.ToIntFunction;

/**
 * DummyBloomFilter bit arrays (0 || 1) add elements and them check(mightContain) them.
 *
 * add:
 *  calculate h1(x) = x mod 5 and add 1 to this position on the array.
 *  calculate h2(x) = (2x+3) mod 5 and add 1 to this position on the array.
 *
 * mightContain:
 *  calculate h1(x)==1 && h2(x)==1 if both 1 we might found it.
 *
 *  */
public class DummyBloomFilter implements BloomFilter<Integer> {

    private final int[] array;
    private final int size;
    private final List<ToIntFunction<Integer>> hashFunctions = H1H2IntHash.build();

    public DummyBloomFilter(int size){
        if (Integer.bitCount(size) != 1){
            throw new IllegalArgumentException("Consider size being " +
                    "1,2,4,8,16,32,64,128,256,512,1024,2048,4096... Where Integer.bitCount(size) == 1 ");
        }
        this.size=size;
        this.array = new int[size];
    }

    @Override
    public void add(Integer value) {
        for (ToIntFunction<Integer> function : hashFunctions) {
            int hashPosition = function.applyAsInt(value);
            array[hashPosition] = 1;
        }
    }

    @Override
    public boolean mightContain(Integer value) {
        int h1h2[] = new int[2];
        int i=0;
        for (ToIntFunction<Integer> function : hashFunctions) {
            int hashPosition = function.applyAsInt(value);
            h1h2[i]=array[hashPosition];
            i++;
        }
        return (h1h2[0]==1 && h1h2[1]==1);
    }
}
