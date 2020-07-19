package com.github.diegopacheco.javapocs.jquik.test;

import net.jqwik.api.*;

public class ParameterProviderMethodsTest {

    @Property
    public boolean concatenatingStringWithInt(@ForAll("shortStrings") String aShortString,@ForAll("10 to 99") int aNumber) {
        String concatenated = aShortString + aNumber;
        return concatenated.length() > 2 && concatenated.length() < 11;
    }

    @Provide
    public Arbitrary<String> shortStrings() {
        return Arbitraries.strings().withCharRange('a', 'z').ofMinLength(1).ofMaxLength(8);
    }

    @Provide("10 to 99")
    public Arbitrary<Integer> numbers() {
        return Arbitraries.integers().between(10, 99);
    }

}
