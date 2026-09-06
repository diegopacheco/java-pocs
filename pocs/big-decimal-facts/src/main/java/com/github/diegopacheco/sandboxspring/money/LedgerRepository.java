package com.github.diegopacheco.sandboxspring.money;

import java.util.Currency;
import java.util.List;
import java.util.Optional;

public interface LedgerRepository {

    LedgerEntry save(LedgerEntry entry);

    Optional<LedgerEntry> findById(String id);

    List<LedgerEntry> findAll();

    Money balanceOf(String accountId, Currency currency);
}
