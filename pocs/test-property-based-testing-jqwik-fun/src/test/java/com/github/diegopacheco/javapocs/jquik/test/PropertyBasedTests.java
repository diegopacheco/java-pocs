package com.github.diegopacheco.javapocs.jquik.test;

import com.github.diegopacheco.javapocs.jquik.BagOfCatsUtils;
import net.jqwik.api.*;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.NotEmpty;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PropertyBasedTests {

    @Property
    public boolean absoluteValueOfAllNumbersIsPositive(@ForAll @Positive int anInteger) {
        int abs = BagOfCatsUtils.abs(anInteger);
        boolean result = abs > 0;
        return result;
    }

    @Property
    public void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(@ForAll @AlphaChars @NotEmpty String string1, @ForAll @AlphaChars @NotEmpty String string2) {
        String conc = BagOfCatsUtils.concat(string1,string2);
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }
}