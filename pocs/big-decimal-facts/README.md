### Build
```bash
./mvnw clean install
```

### Money movement invariants under test
Java 25 + Spring Boot 4.1.1, `com.github.diegopacheco.sandboxspring.money`.

* `Money` is a `BigDecimal` plus a `java.util.Currency`. The constructor pins the scale to the currency (USD 2, JPY 0, BHD 3) with `RoundingMode.UNNECESSARY`, so a sub-cent amount is rejected instead of silently rounded, and two amounts written as `1.0` and `1.00` are the same value.
* No `double` or `float` can enter or leave the `Money` API, and a reflection test enforces it. `minorUnits()` is derived with `longValueExact()` for postings and storage.
* Rates and tax are `BigDecimal` built from `String`, multiplied exactly, and rounded once with an explicit `RoundingMode` when the result hits the ledger.
* `LedgerEntry` refuses postings that do not sum to zero and refuses mixed currencies.
* `MoneyMath.split` hands out the remainder cent instead of dropping it.
* `InMemoryLedgerRepository` is append only: a replayed entry id is rejected.
* Over HTTP every amount is a JSON string, never a JSON number, so no client parses it into a `double`.

### Endpoints
```
POST /ledger/transfers
POST /ledger/transfers-with-fee
POST /ledger/sales
POST /ledger/distributions
GET  /ledger/accounts/{accountId}/balance?currency=USD
GET  /ledger/journal
```

### Run
```bash
./run.sh
```

### Test
```bash
./test.sh
./test-endpoints.sh
```
