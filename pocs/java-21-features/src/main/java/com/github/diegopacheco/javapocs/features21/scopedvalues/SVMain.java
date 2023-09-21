package com.github.diegopacheco.javapocs.features21.scopedvalues;

public class SVMain {

    private static final ScopedValue<String> X = ScopedValue.newInstance();

    void foo() {
        ScopedValue.where(X, "hello").run(() -> bar());
    }

    void bar() {
        System.out.println(X.get()); // prints hello
        ScopedValue.where(X, "goodbye").run(() -> baz());
        System.out.println(X.get()); // prints hello
    }

    void baz() {
        System.out.println(X.get()); // prints goodbye
    }

    public static void main(String[] args) {
        SVMain m = new SVMain();
        m.foo();
    }
}
