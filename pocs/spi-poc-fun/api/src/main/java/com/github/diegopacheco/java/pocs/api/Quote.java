package com.github.diegopacheco.java.pocs.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Quote {
    private String currency;
    private BigDecimal ask;
    private BigDecimal bid;
    private LocalDate date;

    public Quote() {}

    public Quote(String currency, BigDecimal ask, BigDecimal bid, LocalDate date) {
        this.currency = currency;
        this.ask = ask;
        this.bid = bid;
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAsk() {
        return ask;
    }
    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public BigDecimal getBid() {
        return bid;
    }
    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(currency, quote.currency) && Objects.equals(ask, quote.ask) && Objects.equals(bid, quote.bid) && Objects.equals(date, quote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, ask, bid, date);
    }

    @Override
    public String toString() {
        return "com.github.diegopacheco.java.pocs.spi.Quote{" +
                "currency='" + currency + '\'' +
                ", ask=" + ask +
                ", bid=" + bid +
                ", date=" + date +
                '}';
    }
}