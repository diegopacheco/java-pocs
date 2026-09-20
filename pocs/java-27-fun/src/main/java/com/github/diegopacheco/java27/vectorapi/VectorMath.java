package com.github.diegopacheco.java27.vectorapi;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;

public final class VectorMath {

    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    public static int lanes() {
        return SPECIES.length();
    }

    public static float[] scale(float[] values, float factor) {
        float[] result = new float[values.length];
        int bound = SPECIES.loopBound(values.length);
        int i = 0;
        for (; i < bound; i += SPECIES.length()) {
            FloatVector.fromArray(SPECIES, values, i).mul(factor).intoArray(result, i);
        }
        for (; i < values.length; i++) {
            result[i] = values[i] * factor;
        }
        return result;
    }

    public static float dot(float[] a, float[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("arrays must have the same length");
        }
        float sum = 0f;
        int bound = SPECIES.loopBound(a.length);
        int i = 0;
        for (; i < bound; i += SPECIES.length()) {
            FloatVector left = FloatVector.fromArray(SPECIES, a, i);
            FloatVector right = FloatVector.fromArray(SPECIES, b, i);
            sum += left.mul(right).reduceLanes(VectorOperators.ADD);
        }
        for (; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
}
