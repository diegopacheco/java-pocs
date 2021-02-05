package com.githubdiegopacheco.java.arrow.vector;

import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;

public class VectorMain {
    public static void main(String[] args) {
        try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE);
             BigIntVector vector = new BigIntVector("vector", allocator)) {
            vector.allocateNew(8);
            vector.set(0, 1);
            vector.set(1, 2);
            vector.set(2, 3);
            vector.setNull(3);
            vector.set(4, 5);
            vector.set(5, 6);
            vector.set(6, 7);
            vector.set(7, 8);
            vector.setValueCount(8);
            System.out.println(vector);
        }
    }
}
