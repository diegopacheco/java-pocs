package com.github.diegopacheco.sandboxspring.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Currency;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NeverBinaryFloatingPointTest {

    private static final Currency USD = Currency.getInstance("USD");

    @Test
    @DisplayName("a double cannot hold the amounts a customer sees, so money never travels as one")
    void doubleCannotRepresentDecimalAmounts() {
        assertNotEquals(0.3d, 0.1d + 0.2d);
        assertNotEquals(new BigDecimal("0.1"), new BigDecimal(0.1d));
        assertEquals(0, new BigDecimal("0.1").compareTo(BigDecimal.valueOf(0.1d)));
    }

    @Test
    @DisplayName("ten dimes must be a dollar: double drifts, minor units do not")
    void minorUnitsDoNotDrift() {
        double drifting = 0.0d;
        Money exact = Money.zero(USD);
        for (int i = 0; i < 10; i++) {
            drifting += 0.1d;
            exact = exact.add(Money.of("0.10", USD));
        }
        assertNotEquals(1.0d, drifting);
        assertEquals(Money.of("1.00", USD), exact);
        assertEquals(100L, exact.minorUnits());
    }

    @Test
    @DisplayName("a payout run of ten thousand postings settles to the cent")
    void largePostingRunStaysExact() {
        double drifting = 0.0d;
        Money exact = Money.zero(USD);
        for (int i = 0; i < 10_000; i++) {
            drifting += 0.07d;
            exact = exact.add(Money.of("0.07", USD));
        }
        assertNotEquals(700.0d, drifting);
        assertEquals(Money.of("700.00", USD), exact);
    }

    @Test
    @DisplayName("no amount can enter or leave Money as binary floating point")
    void moneyApiRefusesFloatingPoint() {
        for (Method method : Money.class.getDeclaredMethods()) {
            assertTrue(isDecimalSafe(method.getReturnType()), method + " returns floating point");
            for (Class<?> parameter : method.getParameterTypes()) {
                assertTrue(isDecimalSafe(parameter), method + " accepts floating point");
            }
        }
        for (Constructor<?> constructor : Money.class.getDeclaredConstructors()) {
            for (Class<?> parameter : constructor.getParameterTypes()) {
                assertTrue(isDecimalSafe(parameter), constructor + " accepts floating point");
            }
        }
    }

    private static boolean isDecimalSafe(Class<?> type) {
        return type != double.class && type != float.class && type != Double.class && type != Float.class;
    }

    @Test
    @DisplayName("the scale of an amount belongs to its currency, not to the caller")
    void scaleComesFromTheCurrency() {
        assertEquals(100L, Money.of("1.00", USD).minorUnits());
        assertEquals(100L, Money.of("100", Currency.getInstance("JPY")).minorUnits());
        assertEquals(1000L, Money.of("1.000", Currency.getInstance("BHD")).minorUnits());
    }
}
