package com.github.diegopacheco.j22.jeps;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

public class VectorApi {

    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    static void vectorComputation(float[] a, float[] b, float[] c) {
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

    public static void run(){
        System.out.println("460: Vector API (Seventh Incubator)");

        var f1 = new float[]{1,2,3,4,5,76,87};
        var f2 = new float[]{1,2,3,4,5,76,87};
        var f3 = new float[]{1,2,3,4,5,76,87};

        vectorComputation(f1,f2,f3);
    }

}
