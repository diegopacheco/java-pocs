package com.github.diegopacheco.java.sandbox.pocs.mina.tcp;

import java.util.Date;
import java.util.Objects;

public class DateResponse {

    private Date date;

    public DateResponse() { }

    public DateResponse(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateResponse that = (DateResponse) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "DateResponse{" +
                "date=" + date +
                '}';
    }
}
