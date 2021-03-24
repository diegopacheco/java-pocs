package com.github.diegopacheco.java.pocs.impl;

import com.github.diegopacheco.java.pocs.api.ExchangeRateProvider;
import com.github.diegopacheco.java.pocs.api.QuoteManager;

public class YahooFinanceExchangeRateProvider implements ExchangeRateProvider {

    @Override
    public QuoteManager create() {
        return new YahooQuoteManagerImpl();
    }

}