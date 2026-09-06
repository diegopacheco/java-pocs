package com.github.diegopacheco.sandboxspring.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LedgerServiceTest {

    private static final Currency USD = Currency.getInstance("USD");

    private LedgerRepository repository;
    private LedgerService service;

    @BeforeEach
    void setUp() {
        repository = new InMemoryLedgerRepository();
        service = new LedgerService(repository);
    }

    @Test
    @DisplayName("what leaves one account is exactly what reaches the other")
    void transferMovesTheExactAmount() {
        service.transfer("t1", "alice", "bob", Money.of("25.50", USD), "rent");

        assertEquals(Money.of("-25.50", USD), service.balanceOf("alice", USD));
        assertEquals(Money.of("25.50", USD), service.balanceOf("bob", USD));
    }

    @Test
    @DisplayName("a thousand small postings leave a balance to the cent, not close to it")
    void manyPostingsKeepTheBalanceExact() {
        for (int i = 0; i < 1_000; i++) {
            service.transfer("t" + i, "alice", "bob", Money.of("0.01", USD), "micro payment");
        }

        assertEquals(Money.of("10.00", USD), service.balanceOf("bob", USD));
        assertEquals(Money.of("-10.00", USD), service.balanceOf("alice", USD));
    }

    @Test
    @DisplayName("the fee is rounded once and the three sides of the transfer still net to zero")
    void feeIsRoundedOnceAndTheEntryBalances() {
        LedgerEntry entry = service.transferWithFee("t1", "alice", "bob", "fees",
                Money.of("100.00", USD), new BigDecimal("0.029"), RoundingMode.HALF_UP);

        assertEquals(Money.of("2.90", USD), service.balanceOf("fees", USD));
        assertEquals(Money.of("97.10", USD), service.balanceOf("bob", USD));
        assertEquals(Money.of("-100.00", USD), service.balanceOf("alice", USD));
        assertTrue(MoneyMath.sum(entry.postings().stream().map(Posting::amount).toList()).isZero());
    }

    @Test
    @DisplayName("tax is computed on the exact net and rounded once, so revenue plus tax is what the customer owes")
    void saleSplitsRevenueAndTax() {
        service.sale("s1", "customer", "revenue", "tax-payable",
                Money.of("19.99", USD), new BigDecimal("0.0825"), RoundingMode.HALF_UP);

        assertEquals(Money.of("1.65", USD), service.balanceOf("tax-payable", USD));
        assertEquals(Money.of("19.99", USD), service.balanceOf("revenue", USD));
        assertEquals(Money.of("-21.64", USD), service.balanceOf("customer", USD));
    }

    @Test
    @DisplayName("a payout to three recipients hands out the remainder cent instead of dropping it")
    void distributionKeepsEveryCent() {
        service.distribute("d1", "pool", List.of("alice", "bob", "carol"), Money.of("10.00", USD));

        assertEquals(Money.of("3.34", USD), service.balanceOf("alice", USD));
        assertEquals(Money.of("3.33", USD), service.balanceOf("bob", USD));
        assertEquals(Money.of("3.33", USD), service.balanceOf("carol", USD));
        assertEquals(Money.of("-10.00", USD), service.balanceOf("pool", USD));
    }

    @Test
    @DisplayName("a replayed entry id cannot post the same movement twice")
    void journalIsAppendOnly() {
        service.transfer("t1", "alice", "bob", Money.of("25.50", USD), "rent");

        assertThrows(IllegalStateException.class,
                () -> service.transfer("t1", "alice", "bob", Money.of("25.50", USD), "rent"));
        assertEquals(1, service.journal().size());
        assertEquals(Money.of("25.50", USD), service.balanceOf("bob", USD));
    }

    @Test
    @DisplayName("a zero or negative transfer is a bug, not a movement")
    void nonPositiveTransfersAreRefused() {
        assertThrows(IllegalArgumentException.class,
                () -> service.transfer("t1", "alice", "bob", Money.zero(USD), "nothing"));
        assertThrows(IllegalArgumentException.class,
                () -> service.transfer("t2", "alice", "bob", Money.of("-1.00", USD), "reversed"));
        assertTrue(service.journal().isEmpty());
    }

    @Test
    @DisplayName("reading a balance in the wrong currency fails instead of adding cents to yen")
    void balanceInAnotherCurrencyIsRefused() {
        service.transfer("t1", "alice", "bob", Money.of("25.50", USD), "rent");

        assertThrows(IllegalArgumentException.class, () -> service.balanceOf("bob", Currency.getInstance("JPY")));
    }

    @Test
    @DisplayName("the journal keeps the posted entry as it was written")
    void savedEntryIsReadBackUnchanged() {
        LedgerEntry posted = service.transfer("t1", "alice", "bob", Money.of("25.50", USD), "rent");

        assertEquals(posted, repository.findById("t1").orElseThrow());
        assertThrows(UnsupportedOperationException.class,
                () -> posted.postings().add(Posting.credit("mallory", Money.of("1.00", USD))));
    }
}
