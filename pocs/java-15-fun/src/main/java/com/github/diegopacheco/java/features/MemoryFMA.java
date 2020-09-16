package com.github.diegopacheco.java.features;

import jdk.incubator.foreign.MemorySegment;

public class MemoryFMA {
    public static void main(String[] args) {
        MemorySegment segmentA = MemorySegment.allocateNative(10);
        System.out.println(segmentA);
        System.out.println(segmentA.asByteBuffer());
        System.out.println(segmentA.baseAddress().toString());
        segmentA.close();
    }
}
