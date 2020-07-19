package com.github.diegopacheco.javapocs.jquik.test;

import com.github.diegopacheco.javapocs.jquik.BagOfCatsUtils;
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Property
    public void uniqueInList(@ForAll @Size(5) List<@IntRange(min = 0, max = 10) @Unique Integer> aList) {
        Assertions.assertThat(aList).doesNotHaveDuplicates();
        Assertions.assertThat(aList).allMatch(anInt -> anInt >= 0 && anInt <= 10);
    }
}