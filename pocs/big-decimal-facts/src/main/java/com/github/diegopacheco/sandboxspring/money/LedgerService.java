package com.github.diegopacheco.sandboxspring.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LedgerService {

    private final LedgerRepository repository;

    public LedgerService(LedgerRepository repository) {
        this.repository = repository;
    }

    public LedgerEntry transfer(String id, String from, String to, Money amount, String description) {
        requirePositive(amount);
        return repository.save(new LedgerEntry(id, description, List.of(
                Posting.debit(from, amount),
                Posting.credit(to, amount))));
    }

    public LedgerEntry transferWithFee(String id, String from, String to, String feeAccount, Money gross,
            BigDecimal feeRate, RoundingMode rounding) {
        requirePositive(gross);
        Money fee = MoneyMath.applyRate(gross, feeRate, rounding);
        Money net = gross.subtract(fee);
        return repository.save(new LedgerEntry(id, "transfer with fee", List.of(
                Posting.debit(from, gross),
                Posting.credit(to, net),
                Posting.credit(feeAccount, fee))));
    }

    public LedgerEntry sale(String id, String customer, String revenue, String taxAccount, Money net,
            BigDecimal taxRate, RoundingMode rounding) {
        requirePositive(net);
        Money tax = MoneyMath.applyRate(net, taxRate, rounding);
        Money gross = net.add(tax);
        return repository.save(new LedgerEntry(id, "sale", List.of(
                Posting.debit(customer, gross),
                Posting.credit(revenue, net),
                Posting.credit(taxAccount, tax))));
    }

    public LedgerEntry distribute(String id, String from, List<String> recipients, Money total) {
        requirePositive(total);
        List<Money> slices = MoneyMath.split(total, recipients.size());
        List<Posting> postings = new ArrayList<>(recipients.size() + 1);
        postings.add(Posting.debit(from, total));
        for (int i = 0; i < recipients.size(); i++) {
            postings.add(Posting.credit(recipients.get(i), slices.get(i)));
        }
        return repository.save(new LedgerEntry(id, "distribution", postings));
    }

    public Money balanceOf(String accountId, Currency currency) {
        return repository.balanceOf(accountId, currency);
    }

    public List<LedgerEntry> journal() {
        return repository.findAll();
    }

    private static void requirePositive(Money amount) {
        if (amount.isZero() || amount.isNegative()) {
            throw new IllegalArgumentException("amount must be positive: " + amount);
        }
    }
}
