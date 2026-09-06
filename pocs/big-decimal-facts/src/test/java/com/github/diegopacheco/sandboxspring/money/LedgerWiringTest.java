package com.github.diegopacheco.sandboxspring.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.Currency;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class LedgerWiringTest {

    private static final Currency USD = Currency.getInstance("USD");

    @Autowired
    private LedgerService service;

    @Autowired
    private LedgerRepository repository;

    @Test
    @DisplayName("the ledger the application boots with is the exact one the unit tests exercise")
    void ledgerIsWiredAndPostsExactAmounts() {
        assertInstanceOf(InMemoryLedgerRepository.class, repository);

        service.transfer("w1", "alice", "bob", Money.of("0.07", USD), "payout");

        assertEquals(Money.of("0.07", USD), service.balanceOf("bob", USD));
    }
}
