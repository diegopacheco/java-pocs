package com.github.diegopacheco.algo.bloom.filter.test;

import com.github.diegopacheco.algo.bloom.filter.BloomFilter;
import com.github.diegopacheco.algo.bloom.filter.IntObjectsHash;
import com.github.diegopacheco.algo.bloom.filter.SimpleBloomFilter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleBloomFilterTest {

    @Test
    public void testBasicOpsMightContain4(){
        SimpleBloomFilter<Integer> bf = new SimpleBloomFilter.Builder<Integer>()
                .withSize(2048)
                .withHashFunctions(IntObjectsHash.build())
                .build();
        bf.add(1);
        bf.add(2);
        bf.add(3);
        bf.add(4);
        bf.add(5);
        System.out.println("is 4 present? == " + bf.mightContain(4));
        assertEquals(true,bf.mightContain(4));
    }

    @Test
    public void testBasicOpsMightContain6False(){
        SimpleBloomFilter<Integer> bf = new SimpleBloomFilter.Builder<Integer>()
                .withSize(2048)
                .withHashFunctions(IntObjectsHash.build())
                .build();
        bf.add(1);
        bf.add(2);
        bf.add(3);
        bf.add(4);
        bf.add(5);
        System.out.println("is 6 present? == " + bf.mightContain(6));
        assertEquals(false,bf.mightContain(6));
    }

    @Test
    public void testRightSizes() {
        List<Integer> rightSizes = Arrays.asList(1,2,4,8,16,32,64,128,256,512,1024,4096);
        for(int i : rightSizes){
            new SimpleBloomFilter.Builder<Integer>()
                    .withSize(i)
                    .withHashFunctions(IntObjectsHash.build())
                    .build();
        }
    }

    @Test
    public void testWrongSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            SimpleBloomFilter<Integer> bf = new SimpleBloomFilter.Builder<Integer>()
                    .withSize(65)
                    .withHashFunctions(IntObjectsHash.build())
                    .build();
        });
    }

    @Test
    // proof no false negatives
    public void test100ValuesNotThere() {
        BloomFilter<Integer> bloom = new SimpleBloomFilter.Builder<Integer>()
                    .withSize(2048)
                    .withHashFunctions(IntObjectsHash.build())
                    .build();
        for(int i=0;i<=99;i++){
            assertEquals(false,bloom.mightContain(i));
        }
    }

}
