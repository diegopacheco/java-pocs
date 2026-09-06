package com.github.diegopacheco.sandboxspring.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

public final class MoneyMath {

    private MoneyMath() {
    }

    public static Money applyRate(Money base, BigDecimal rate, RoundingMode rounding) {
        return applyRates(base, rounding, rate);
    }

    public static Money applyRates(Money base, RoundingMode rounding, BigDecimal... rates) {
        Objects.requireNonNull(rounding, "rounding mode is required");
        BigDecimal factor = BigDecimal.ONE;
        for (BigDecimal rate : rates) {
            factor = factor.multiply(Objects.requireNonNull(rate, "rate is required"));
        }
        BigDecimal exact = base.amount().multiply(factor);
        return new Money(exact.setScale(base.currency().getDefaultFractionDigits(), rounding), base.currency());
    }

    public static Money convert(Money base, Currency target, BigDecimal rate, RoundingMode rounding) {
        Objects.requireNonNull(rounding, "rounding mode is required");
        BigDecimal exact = base.amount().multiply(rate);
        return new Money(exact.setScale(target.getDefaultFractionDigits(), rounding), target);
    }

    public static List<Money> split(Money total, int parts) {
        if (parts <= 0) {
            throw new IllegalArgumentException("parts must be positive: " + parts);
        }
        long units = total.minorUnits();
        long base = units / parts;
        long remainder = Math.abs(units % parts);
        long step = total.isNegative() ? -1L : 1L;
        List<Money> slices = new ArrayList<>(parts);
        for (int i = 0; i < parts; i++) {
            slices.add(Money.ofMinorUnits(i < remainder ? base + step : base, total.currency()));
        }
        return List.copyOf(slices);
    }

    public static Money sum(List<Money> amounts) {
        if (amounts.isEmpty()) {
            throw new IllegalArgumentException("cannot sum an empty list");
        }
        Money acc = Money.zero(amounts.getFirst().currency());
        for (Money amount : amounts) {
            acc = acc.add(amount);
        }
        return acc;
    }
}
