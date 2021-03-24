package com.github.diegopacheco.java.pocs.api;

import java.time.LocalDate;
import java.util.List;

public interface QuoteManager {
    List<Quote> getQuotes(String baseCurrency, LocalDate date);
}
