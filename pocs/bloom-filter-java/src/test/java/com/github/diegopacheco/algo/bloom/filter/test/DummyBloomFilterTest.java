package com.github.diegopacheco.algo.bloom.filter.test;

import com.github.diegopacheco.algo.bloom.filter.BloomFilter;
import com.github.diegopacheco.algo.bloom.filter.v1.DummyBloomFilter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DummyBloomFilterTest {

    @Test
    public void testBasicOP4mightContains(){
        BloomFilter<Integer> bloom = new DummyBloomFilter(1024);
        bloom.add(4);
        System.out.println("is 4 present ? == "+bloom.mightContain(4));
        assertEquals(true,bloom.mightContain(4));
    }

    @Test
    public void testBasicOP4mightContainsHas1to10(){
        BloomFilter<Integer> bloom = new DummyBloomFilter(1024);
        for(int i=1;i<=10;i++){
            bloom.add(i);
        }
        for(int i=1;i<=10;i++){
            assertEquals(true,bloom.mightContain(i));
        }
    }

    @Test
    public void testBasicOP4mightContainsNotHas6(){
        BloomFilter<Integer> bloom = new DummyBloomFilter(1024);
        bloom.add(5);
        System.out.println("is 6 present ? == "+bloom.mightContain(6));
        assertEquals(false,bloom.mightContain(6));
    }

    @Test
    public void testBasicOP4NotHave100(){
        BloomFilter<Integer> bloom = new DummyBloomFilter(1024);
        for(int i=0;i<99;i++){
            assertEquals(false,bloom.mightContain(i));
        }
    }

    @Test
    public void testRightSizes() {
        List<Integer> rightSizes = Arrays.asList(1,2,4,8,16,32,64,128,256,512,1024,4096);
        for(int i : rightSizes){
            new DummyBloomFilter(i);
        }
    }

    @Test
    public void testWrongSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DummyBloomFilter(65);
        });
    }

}
