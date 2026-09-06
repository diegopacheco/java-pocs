package com.github.diegopacheco.sandboxspring.money;

import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryLedgerRepository implements LedgerRepository {

    private final Map<String, LedgerEntry> byId = new ConcurrentHashMap<>();
    private final ConcurrentLinkedQueue<LedgerEntry> journal = new ConcurrentLinkedQueue<>();

    @Override
    public LedgerEntry save(LedgerEntry entry) {
        if (byId.putIfAbsent(entry.id(), entry) != null) {
            throw new IllegalStateException("ledger entry already posted: " + entry.id());
        }
        journal.add(entry);
        return entry;
    }

    @Override
    public Optional<LedgerEntry> findById(String id) {
        return Optional.ofNullable(byId.get(id));
    }

    @Override
    public List<LedgerEntry> findAll() {
        return List.copyOf(journal);
    }

    @Override
    public Money balanceOf(String accountId, Currency currency) {
        Money balance = Money.zero(currency);
        for (LedgerEntry entry : journal) {
            for (Posting posting : entry.postings()) {
                if (posting.accountId().equals(accountId)) {
                    if (!posting.amount().currency().equals(currency)) {
                        throw new IllegalArgumentException("account " + accountId + " holds " + posting.amount().currency());
                    }
                    balance = balance.add(posting.amount());
                }
            }
        }
        return balance;
    }
}
