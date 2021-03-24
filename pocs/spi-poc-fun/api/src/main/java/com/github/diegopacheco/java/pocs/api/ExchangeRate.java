package com.github.diegopacheco.java.pocs.api;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public class ExchangeRate {

    private static final String DEFAULT_PROVIDER = "com.github.diegopacheco.java.pocs.impl.YahooFinanceExchangeRateProvider";

    //All providers
    public static List<ExchangeRateProvider> providers() {
        List<ExchangeRateProvider> services = new ArrayList<>();
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);
        loader.forEach(exchangeRateProvider -> {
            services.add(exchangeRateProvider);
        });
        return services;
    }

    //Default provider
    public static ExchangeRateProvider provider() {
        return provider(DEFAULT_PROVIDER);
    }

    //provider by name
    public static ExchangeRateProvider provider(String providerName) {
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);
        Iterator<ExchangeRateProvider> it = loader.iterator();
        while (it.hasNext()) {
            ExchangeRateProvider provider = it.next();
            if (providerName.equals(provider.getClass().getName())) {
                return provider;
            }
        }
        throw new ProviderNotFoundException("Exchange Rate provider " + providerName + " not found");
    }

}
