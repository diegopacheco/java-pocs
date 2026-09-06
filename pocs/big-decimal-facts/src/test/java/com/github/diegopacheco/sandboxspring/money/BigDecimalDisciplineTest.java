package com.github.diegopacheco.sandboxspring.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BigDecimalDisciplineTest {

    private static final Currency USD = Currency.getInstance("USD");

    @Test
    @DisplayName("new BigDecimal(double) copies the binary error it was meant to avoid")
    void constructFromStringNeverFromDouble() {
        assertTrue(new BigDecimal(0.1d).toPlainString().startsWith("0.1000000000000000055"));
        assertEquals("0.1", new BigDecimal("0.1").toPlainString());
        assertEquals("0.1", BigDecimal.valueOf(0.1d).toPlainString());
    }

    @Test
    @DisplayName("equals sees scale, so amounts are compared with compareTo")
    void compareToNotEquals() {
        BigDecimal oneDollar = new BigDecimal("1.0");
        BigDecimal oneDollarTwoPlaces = new BigDecimal("1.00");
        assertNotEquals(oneDollar, oneDollarTwoPlaces);
        assertEquals(0, oneDollar.compareTo(oneDollarTwoPlaces));
        assertEquals(Money.of("1.0", USD), Money.of("1.00", USD));
        assertEquals(0, Money.of("1.0", USD).compareTo(Money.of("1.00", USD)));
    }

    @Test
    @DisplayName("Money pins the scale on the way in, which is what makes comparing two amounts safe")
    void moneyNormalisesScaleOnConstruction() {
        assertEquals(new BigDecimal("1.00"), Money.of("1.0", USD).amount());
        assertEquals(new BigDecimal("1.00"), Money.of("1", USD).amount());
        assertEquals(2, Money.of("1", USD).amount().scale());
        assertEquals(0, Money.of("100", Currency.getInstance("JPY")).amount().scale());
    }

    @Test
    @DisplayName("rounding is a decision: without a RoundingMode the arithmetic fails instead of guessing")
    void roundingModeIsAlwaysExplicit() {
        assertThrows(ArithmeticException.class, () -> new BigDecimal("1.005").setScale(2, RoundingMode.UNNECESSARY));
        assertThrows(ArithmeticException.class, () -> BigDecimal.ONE.divide(new BigDecimal("3")));
        assertEquals("1.01", new BigDecimal("1.005").setScale(2, RoundingMode.HALF_UP).toPlainString());
        assertEquals("1.00", new BigDecimal("1.005").setScale(2, RoundingMode.HALF_EVEN).toPlainString());
        assertEquals("0.333", BigDecimal.ONE.divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP).toPlainString());
    }

    @Test
    @DisplayName("sub-cent input is rejected at the door instead of being silently rounded")
    void subMinorUnitPrecisionIsRefused() {
        assertThrows(ArithmeticException.class, () -> Money.of("1.005", USD));
        assertEquals(1005L, Money.of("10.05", USD).minorUnits());
    }

    @Test
    @DisplayName("a stored amount keeps its scale, so a balance prints as 10.00 and not as 10")
    void amountKeepsCurrencyScale() {
        assertEquals("10.00", Money.of("10", USD).amount().toPlainString());
        assertEquals(2, Money.of("10", USD).amount().scale());
        assertEquals("10.00 USD", Money.of("10", USD).toString());
    }
}
