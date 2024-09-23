package com.github.diegopacheco.java23.features.JEP_469;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

/**
 * JEP 469: Vector API (Eighth Incubator)
 * https://openjdk.org/jeps/469
 *
 */
public class FeatureJEP469 {

    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    void vectorComputation(float[] a, float[] b, float[] c) {
        int i = 0;
        int upperBound = SPECIES.loopBound(a.length);
        for (; i < upperBound; i += SPECIES.length()) {
            // FloatVector va, vb, vc;
            var va = FloatVector.fromArray(SPECIES, a, i);
            var vb = FloatVector.fromArray(SPECIES, b, i);
            var vc = va.mul(va)
                    .add(vb.mul(vb))
                    .neg();
            vc.intoArray(c, i);
        }
        for (; i < a.length; i++) {
            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
        }
    }

    public static void main(String[] args) {
        FeatureJEP469 featureJEP469 = new FeatureJEP469();
        float[] a = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] b = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] c = new float[4];
        featureJEP469.vectorComputation(a, b, c);
        for (float v : c) {
            System.out.println(v);
        }
    }
}
