package com.github.diegopacheco.java.pocs.impl;

import com.github.diegopacheco.java.pocs.api.Quote;
import com.github.diegopacheco.java.pocs.api.QuoteManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class YahooQuoteManagerImpl implements QuoteManager {
    @Override
    public List<Quote> getQuotes(String baseCurrency, LocalDate date) {
        return Arrays.asList(new Quote("USA", BigDecimal.ONE,BigDecimal.TEN,LocalDate.now()));
    }
}
