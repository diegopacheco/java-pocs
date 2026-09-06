package com.github.diegopacheco.sandboxspring.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundOnceAtLedgerBoundaryTest {

    private static final Currency USD = Currency.getInstance("USD");
    private static final BigDecimal TAX_RATE = new BigDecimal("0.075");

    @Test
    @DisplayName("tax rounded per line overcharges the customer; rounded once it matches the exact tax")
    void taxIsRoundedOnceOverTheTotal() {
        List<Money> lines = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lines.add(Money.of("0.10", USD));
        }
        Money perLineTax = Money.zero(USD);
        for (Money line : lines) {
            perLineTax = perLineTax.add(MoneyMath.applyRate(line, TAX_RATE, RoundingMode.HALF_UP));
        }
        Money onceTax = MoneyMath.applyRate(MoneyMath.sum(lines), TAX_RATE, RoundingMode.HALF_UP);

        assertEquals(Money.of("0.04", USD), perLineTax);
        assertEquals(Money.of("0.03", USD), onceTax);
        assertEquals(0, new BigDecimal("0.03").compareTo(new BigDecimal("0.40").multiply(TAX_RATE)));
    }

    @Test
    @DisplayName("a discount followed by tax is one exact calculation, not two rounded ones")
    void rateChainRoundsOnlyAtTheBoundary() {
        Money price = Money.of("19.99", USD);
        BigDecimal discount = new BigDecimal("0.90");
        BigDecimal withTax = new BigDecimal("1.0825");

        Money once = MoneyMath.applyRates(price, RoundingMode.HALF_UP, discount, withTax);
        Money stepwise = MoneyMath.applyRate(
                MoneyMath.applyRate(price, discount, RoundingMode.HALF_UP), withTax, RoundingMode.HALF_UP);

        assertEquals(Money.of("19.48", USD), once);
        assertEquals(Money.of("19.47", USD), stepwise);
        assertNotEquals(once, stepwise);
    }

    @Test
    @DisplayName("a currency conversion rounded twice loses money that a single conversion keeps")
    void conversionRoundsOnlyWhenItHitsTheLedger() {
        Currency eur = Currency.getInstance("EUR");
        Money source = Money.of("100.05", USD);
        BigDecimal usdToEur = new BigDecimal("0.8899");
        BigDecimal eurToUsd = new BigDecimal("1.1237");

        Money roundTrip = MoneyMath.convert(
                MoneyMath.convert(source, eur, usdToEur, RoundingMode.HALF_UP), USD, eurToUsd, RoundingMode.HALF_UP);
        Money single = MoneyMath.applyRates(source, RoundingMode.HALF_UP, usdToEur, eurToUsd);

        assertEquals(Money.of("100.05", USD), single);
        assertEquals(Money.of("100.04", USD), roundTrip);
    }

    @Test
    @DisplayName("the rounding mode changes the cent, so it is always chosen on purpose")
    void roundingModeIsPartOfTheContract() {
        Money half = Money.of("0.05", USD);
        BigDecimal rate = new BigDecimal("0.5");

        assertEquals(Money.of("0.03", USD), MoneyMath.applyRate(half, rate, RoundingMode.HALF_UP));
        assertEquals(Money.of("0.02", USD), MoneyMath.applyRate(half, rate, RoundingMode.HALF_EVEN));
        assertEquals(Money.of("0.02", USD), MoneyMath.applyRate(half, rate, RoundingMode.DOWN));
        assertThrows(ArithmeticException.class, () -> MoneyMath.applyRate(half, rate, RoundingMode.UNNECESSARY));
    }

    @Test
    @DisplayName("splitting a bill hands out every cent, including the remainder")
    void splitLosesNoCent() {
        Money total = Money.of("10.00", USD);
        List<Money> slices = MoneyMath.split(total, 3);

        assertEquals(List.of(Money.of("3.34", USD), Money.of("3.33", USD), Money.of("3.33", USD)), slices);
        assertEquals(total, MoneyMath.sum(slices));
        assertNotEquals(total, MoneyMath.sum(List.of(Money.of("3.33", USD), Money.of("3.33", USD), Money.of("3.33", USD))));
    }

    @Test
    @DisplayName("a refund split keeps the same total when the amount is negative")
    void splitOfNegativeAmountsStaysExact() {
        Money refund = Money.of("-0.10", USD);
        List<Money> slices = MoneyMath.split(refund, 3);

        assertEquals(List.of(Money.of("-0.04", USD), Money.of("-0.03", USD), Money.of("-0.03", USD)), slices);
        assertEquals(refund, MoneyMath.sum(slices));
    }
}
