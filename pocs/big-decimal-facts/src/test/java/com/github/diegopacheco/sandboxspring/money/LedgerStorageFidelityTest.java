package com.github.diegopacheco.sandboxspring.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LedgerStorageFidelityTest {

    private static final Currency USD = Currency.getInstance("USD");

    @Test
    @DisplayName("a float column cannot even hold seven cents, an exact column round trips unchanged")
    void amountsSurviveStorageOnlyAsExactValues() {
        BigDecimal amount = new BigDecimal("0.07");
        double asFloatColumn = amount.doubleValue();

        assertNotEquals(amount, new BigDecimal(asFloatColumn));
        assertEquals(amount, Money.of("0.07", USD).amount());
        assertEquals(7L, Money.of("0.07", USD).minorUnits());
    }

    @Test
    @DisplayName("a large balance stored as a float comes back wrong; minor units come back exact")
    void largeBalancesSurviveStorage() {
        BigDecimal amount = new BigDecimal("12345678901234.56");
        double asFloatColumn = amount.doubleValue();

        assertNotEquals(amount, new BigDecimal(asFloatColumn));
        assertEquals(amount, Money.of("12345678901234.56", USD).amount());
    }

    @Test
    @DisplayName("summing a float column over a thousand postings drifts; summing minor units does not")
    void aggregatingStoredAmountsStaysExact() {
        LedgerService service = new LedgerService(new InMemoryLedgerRepository());
        double asFloatColumn = 0.0d;
        for (int i = 0; i < 1_000; i++) {
            service.transfer("t" + i, "pool", "bob", Money.of("0.07", USD), "payout");
            asFloatColumn += 0.07d;
        }

        assertNotEquals(70.0d, asFloatColumn);
        assertEquals(Money.of("70.00", USD), service.balanceOf("bob", USD));
    }
}
