package com.github.diegopacheco.pocs.seda.backpressure;

import java.util.Date;
import java.util.function.Consumer;

// https://www.geeksforgeeks.org/leaky-bucket-algorithm/
public class LeakyBucketBackpressure {

    private int numDropsInBucket = 0;
    private Date timeOfLastDropLeak = null;
    private final int DROPS = 10;
    private final long PER_SECONDS = 1000; // 2 seconds

    public static <T> void runWithBackpressure(LeakyBucketBackpressure bucket, Consumer<T> func,Consumer<T> fallback){
        if (bucket.addDropToBucket()) {
            func.accept(null);
        }else{
            fallback.accept(null);
        }
    }

    public synchronized boolean addDropToBucket() {
        Date now = new Date();
        if (timeOfLastDropLeak != null) {
            long deltaT = now.getTime() - timeOfLastDropLeak.getTime();
            long numberToLeak = deltaT / PER_SECONDS;
            if (numberToLeak > 0) {
                if (numDropsInBucket <= numberToLeak) {
                    numDropsInBucket = 0;
                } else {
                    numDropsInBucket -= (int) numberToLeak;
                }
                timeOfLastDropLeak = now;
            }
        }

        if (numDropsInBucket < DROPS) {
            numDropsInBucket++;
            return true; // drop added
        }
        return false; // overflow
    }

}
