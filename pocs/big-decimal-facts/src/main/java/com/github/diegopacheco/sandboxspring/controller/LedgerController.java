package com.github.diegopacheco.sandboxspring.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.diegopacheco.sandboxspring.money.LedgerEntry;
import com.github.diegopacheco.sandboxspring.money.LedgerService;
import com.github.diegopacheco.sandboxspring.money.Money;
import com.github.diegopacheco.sandboxspring.money.Posting;

@RestController
@RequestMapping("/ledger")
public class LedgerController {

    public record TransferRequest(String id, String from, String to, String amount, String currency, String description) {
    }

    public record FeeTransferRequest(String id, String from, String to, String feeAccount, String gross,
            String currency, String feeRate, String rounding) {
    }

    public record SaleRequest(String id, String customer, String revenue, String taxAccount, String net,
            String currency, String taxRate, String rounding) {
    }

    public record DistributionRequest(String id, String from, List<String> recipients, String total, String currency) {
    }

    public record MoneyView(String amount, String currency, long minorUnits) {
        static MoneyView of(Money money) {
            return new MoneyView(money.amount().toPlainString(), money.currency().getCurrencyCode(), money.minorUnits());
        }
    }

    public record PostingView(String accountId, MoneyView amount) {
    }

    public record EntryView(String id, String description, List<PostingView> postings, MoneyView residual) {
        static EntryView of(LedgerEntry entry) {
            Money residual = Money.zero(entry.postings().getFirst().amount().currency());
            for (Posting posting : entry.postings()) {
                residual = residual.add(posting.amount());
            }
            return new EntryView(entry.id(), entry.description(),
                    entry.postings().stream().map(p -> new PostingView(p.accountId(), MoneyView.of(p.amount()))).toList(),
                    MoneyView.of(residual));
        }
    }

    private final LedgerService service;

    public LedgerController(LedgerService service) {
        this.service = service;
    }

    @PostMapping("/transfers")
    public EntryView transfer(@RequestBody TransferRequest request) {
        Currency currency = Currency.getInstance(request.currency());
        return EntryView.of(service.transfer(request.id(), request.from(), request.to(),
                Money.of(request.amount(), currency), request.description()));
    }

    @PostMapping("/transfers-with-fee")
    public EntryView transferWithFee(@RequestBody FeeTransferRequest request) {
        Currency currency = Currency.getInstance(request.currency());
        return EntryView.of(service.transferWithFee(request.id(), request.from(), request.to(), request.feeAccount(),
                Money.of(request.gross(), currency), new BigDecimal(request.feeRate()), rounding(request.rounding())));
    }

    @PostMapping("/sales")
    public EntryView sale(@RequestBody SaleRequest request) {
        Currency currency = Currency.getInstance(request.currency());
        return EntryView.of(service.sale(request.id(), request.customer(), request.revenue(), request.taxAccount(),
                Money.of(request.net(), currency), new BigDecimal(request.taxRate()), rounding(request.rounding())));
    }

    @PostMapping("/distributions")
    public EntryView distribute(@RequestBody DistributionRequest request) {
        Currency currency = Currency.getInstance(request.currency());
        return EntryView.of(service.distribute(request.id(), request.from(), request.recipients(),
                Money.of(request.total(), currency)));
    }

    @GetMapping("/accounts/{accountId}/balance")
    public MoneyView balance(@PathVariable String accountId, @RequestParam String currency) {
        return MoneyView.of(service.balanceOf(accountId, Currency.getInstance(currency)));
    }

    @GetMapping("/journal")
    public List<EntryView> journal() {
        return service.journal().stream().map(EntryView::of).toList();
    }

    private static RoundingMode rounding(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("rounding mode is required");
        }
        return RoundingMode.valueOf(value);
    }

    @ExceptionHandler({ IllegalArgumentException.class, ArithmeticException.class })
    public ResponseEntity<Map<String, String>> onRejectedAmount(RuntimeException error) {
        return ResponseEntity.badRequest().body(Map.of("error", String.valueOf(error.getMessage())));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, String>> onReplayedEntry(IllegalStateException error) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", String.valueOf(error.getMessage())));
    }
}
