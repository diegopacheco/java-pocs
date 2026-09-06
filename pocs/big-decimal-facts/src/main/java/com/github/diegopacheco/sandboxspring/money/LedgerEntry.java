package com.github.diegopacheco.sandboxspring.money;

import java.util.Currency;
import java.util.List;
import java.util.Objects;

public record LedgerEntry(String id, String description, List<Posting> postings) {

    public LedgerEntry {
        Objects.requireNonNull(id, "id is required");
        Objects.requireNonNull(description, "description is required");
        postings = List.copyOf(Objects.requireNonNull(postings, "postings are required"));
        if (postings.size() < 2) {
            throw new IllegalArgumentException("a ledger entry needs at least two postings");
        }
        Currency currency = postings.getFirst().amount().currency();
        Money total = Money.zero(currency);
        for (Posting posting : postings) {
            if (!posting.amount().currency().equals(currency)) {
                throw new IllegalArgumentException("mixed currencies in entry " + id);
            }
            total = total.add(posting.amount());
        }
        if (!total.isZero()) {
            throw new IllegalArgumentException("unbalanced entry " + id + ", residual: " + total);
        }
    }

    public Money balanceOf(String accountId) {
        Money balance = Money.zero(postings().getFirst().amount().currency());
        for (Posting posting : postings()) {
            if (posting.accountId().equals(accountId)) {
                balance = balance.add(posting.amount());
            }
        }
        return balance;
    }
}
