package com.github.diegopacheco.java23.features.JEP_471;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * JEP 471: Deprecate the Memory-Access Methods in sun.misc.Unsafe for Removal
 * https://openjdk.org/jeps/471
 */
public class FeatureJEP471 {

    static class FooOffHeap {

        private static final VarHandle X_VH;

        static {
            try {
                X_VH = MethodHandles.lookup().findVarHandle(FooOffHeap.class, "x", int.class);
            } catch (Exception ex) { throw new AssertionError(ex); }
        }

        private int x;

        public boolean tryAtomicallyDoubleX() {
            int oldValue = x;
            return X_VH.compareAndSet(this, oldValue, oldValue * 2);
        }

    }

    public static void main(String[] args) {
        FooOffHeap foo = new FooOffHeap();
        foo.x = 42;
        System.out.println(foo.tryAtomicallyDoubleX());
        System.out.println(foo.x);
    }
}
