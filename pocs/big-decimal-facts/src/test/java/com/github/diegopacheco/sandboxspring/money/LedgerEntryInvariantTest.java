package com.github.diegopacheco.sandboxspring.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Currency;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LedgerEntryInvariantTest {

    private static final Currency USD = Currency.getInstance("USD");
    private static final Currency EUR = Currency.getInstance("EUR");

    @Test
    @DisplayName("money is never created or destroyed: every entry sums to zero minor units")
    void postingsMustBalance() {
        LedgerEntry entry = new LedgerEntry("e1", "transfer", List.of(
                Posting.debit("alice", Money.of("25.50", USD)),
                Posting.credit("bob", Money.of("25.50", USD))));

        assertEquals(Money.of("-25.50", USD), entry.balanceOf("alice"));
        assertEquals(Money.of("25.50", USD), entry.balanceOf("bob"));
    }

    @Test
    @DisplayName("an entry that is one cent off is refused rather than posted")
    void unbalancedEntryIsRefused() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> new LedgerEntry("e2", "off by a cent", List.of(
                Posting.debit("alice", Money.of("25.50", USD)),
                Posting.credit("bob", Money.of("25.49", USD)))));

        assertEquals("unbalanced entry e2, residual: -0.01 USD", error.getMessage());
    }

    @Test
    @DisplayName("currencies never net against each other inside one entry")
    void mixedCurrenciesAreRefused() {
        assertThrows(IllegalArgumentException.class, () -> new LedgerEntry("e3", "mixed", List.of(
                Posting.debit("alice", Money.of("10.00", USD)),
                Posting.credit("bob", Money.of("10.00", EUR)))));
    }

    @Test
    @DisplayName("a single-sided movement is not a ledger entry")
    void singlePostingIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> new LedgerEntry("e4", "one sided",
                List.of(Posting.credit("bob", Money.of("10.00", USD)))));
    }

    @Test
    @DisplayName("a fee split still balances to zero across three accounts")
    void feeSplitBalances() {
        Money gross = Money.of("100.00", USD);
        Money fee = Money.of("2.90", USD);
        LedgerEntry entry = new LedgerEntry("e5", "transfer with fee", List.of(
                Posting.debit("alice", gross),
                Posting.credit("bob", gross.subtract(fee)),
                Posting.credit("fees", fee)));

        assertEquals(Money.of("97.10", USD), entry.balanceOf("bob"));
        assertEquals(fee, entry.balanceOf("fees"));
    }
}
