package com.github.diegopacheco.java27.primitivepatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.diegopacheco.java27.primitivepatterns.PrimitivePatterns.Json;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PrimitivePatternsTest {

    @Test
    void aPrimitiveTypePatternReplacesTheDefaultClauseAndBindsTheValue() {
        assertEquals("okay", PrimitivePatterns.status(0));
        assertEquals("error", PrimitivePatterns.status(2));
        assertEquals("unknown status: 42", PrimitivePatterns.status(42));
    }

    @Test
    void aGuardCanInspectTheValueBoundByAPrimitivePattern() {
        assertEquals("invalid status: -3", PrimitivePatterns.status(-3));
    }

    @Test
    void instanceofOnPrimitivesTestsForExactRepresentationNotJustRange() {
        assertEquals("byte 7", PrimitivePatterns.narrowest(7.0));
        assertEquals("int 100000", PrimitivePatterns.narrowest(100000.0));
        assertEquals("float 1.5", PrimitivePatterns.narrowest(1.5));
        assertEquals("double 0.1", PrimitivePatterns.narrowest(0.1));
    }

    @Test
    void aRecordPatternCanNarrowADoubleComponentToIntWhenItIsExact() {
        Json exact = new Json.Obj(Map.of("age", new Json.Num(30)));
        assertEquals(30, PrimitivePatterns.ageOf(exact));

        Json notExact = new Json.Obj(Map.of("age", new Json.Num(30.5)));
        assertEquals(-1, PrimitivePatterns.ageOf(notExact));
    }

    @Test
    void referencePatternsKeepWorkingAlongsidePrimitiveOnes() {
        assertEquals("big int 500", PrimitivePatterns.label(500));
        assertEquals("int 7", PrimitivePatterns.label(7));
        assertEquals("char a", PrimitivePatterns.label('a'));
        assertEquals("text hi", PrimitivePatterns.label("hi"));
        assertEquals("nothing", PrimitivePatterns.label(null));
        assertEquals("other", PrimitivePatterns.label(1.0d));
    }
}
