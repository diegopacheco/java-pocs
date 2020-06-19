package com.github.diegopacheco.serdebenchs.lz4;

import java.util.Arrays;
import java.util.Objects;

public class Lz4Result {

    private byte[] compressed;
    private int originalLength;

    public Lz4Result(){}

    public Lz4Result(byte[] compressed, int originalLength) {
        this.compressed = compressed;
        this.originalLength = originalLength;
    }

    public byte[] getCompressed() {
        return compressed;
    }
    public void setCompressed(byte[] compressed) {
        this.compressed = compressed;
    }

    public int getOriginalLength() {
        return originalLength;
    }
    public void setOriginalLength(int originalLength) {
        this.originalLength = originalLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lz4Result lz4Result = (Lz4Result) o;
        return getOriginalLength() == lz4Result.getOriginalLength() &&
                Arrays.equals(getCompressed(), lz4Result.getCompressed());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getOriginalLength());
        result = 31 * result + Arrays.hashCode(getCompressed());
        return result;
    }

    @Override
    public String toString() {
        return "Lz4Result{" +
                "compressed=" + Arrays.toString(compressed) +
                ", originalLength=" + originalLength +
                '}';
    }
}
