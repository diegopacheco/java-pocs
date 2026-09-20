package com.github.diegopacheco.java27.vectorapi;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VectorMathTest {

    @Test
    void theSpeciesAdaptsToTheLaneWidthOfTheHostCpu() {
        assertTrue(VectorMath.lanes() >= 1);
        assertEquals(0, VectorMath.lanes() & (VectorMath.lanes() - 1));
    }

    @Test
    void vectorizedScalingMatchesScalarScaling() {
        float[] values = new float[37];
        for (int i = 0; i < values.length; i++) {
            values[i] = i + 0.5f;
        }
        float[] expected = new float[values.length];
        for (int i = 0; i < values.length; i++) {
            expected[i] = values[i] * 3f;
        }
        assertArrayEquals(expected, VectorMath.scale(values, 3f), 0f);
    }

    @Test
    void theTailShorterThanOneVectorIsStillProcessed() {
        float[] values = new float[VectorMath.lanes() + 1];
        java.util.Arrays.fill(values, 2f);
        float[] scaled = VectorMath.scale(values, 2f);
        assertEquals(4f, scaled[scaled.length - 1]);
    }

    @Test
    void dotProductAgreesWithTheScalarDefinition() {
        float[] a = {1f, 2f, 3f, 4f, 5f};
        float[] b = {5f, 4f, 3f, 2f, 1f};
        assertEquals(35f, VectorMath.dot(a, b), 1e-5f);
    }

    @Test
    void mismatchedLengthsAreRejectedInsteadOfSilentlyTruncated() {
        assertThrows(IllegalArgumentException.class, () -> VectorMath.dot(new float[2], new float[3]));
    }
}
