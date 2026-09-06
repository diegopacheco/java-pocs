package com.github.diegopacheco.sandboxspring.money;

import java.util.Objects;

public record Posting(String accountId, Money amount) {

    public Posting {
        Objects.requireNonNull(accountId, "accountId is required");
        Objects.requireNonNull(amount, "amount is required");
    }

    public static Posting debit(String accountId, Money amount) {
        return new Posting(accountId, amount.negate());
    }

    public static Posting credit(String accountId, Money amount) {
        return new Posting(accountId, amount);
    }
}
