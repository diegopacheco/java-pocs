package com.github.diegopacheco.java25.features;

import jdk.incubator.vector.*;

/**
 * JEP 508: Vector API (Tenth Incubator)
 * https://openjdk.org/jeps/508
 *
 * Vector API to perform vector computations that compile
 * at runtime to optimal vector instructions on supported CPU architectures.
 */
public class VectorAPI {
    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    public static void main(String[] args) {
        System.out.println("Vector API Test Starting...");
        System.out.println("Species length: " + SPECIES.length());

        float[] a = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f};
        float[] b = {2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f};
        float[] result = new float[a.length];

        System.out.println("Input a: " + java.util.Arrays.toString(a));
        System.out.println("Input b: " + java.util.Arrays.toString(b));

        for (int i = 0; i < SPECIES.loopBound(a.length); i += SPECIES.length()) {
            var va = FloatVector.fromArray(SPECIES, a, i);
            var vb = FloatVector.fromArray(SPECIES, b, i);
            va.add(vb).mul(2.0f).intoArray(result, i);
        }

        System.out.println("Result: " + java.util.Arrays.toString(result));
    }
}
