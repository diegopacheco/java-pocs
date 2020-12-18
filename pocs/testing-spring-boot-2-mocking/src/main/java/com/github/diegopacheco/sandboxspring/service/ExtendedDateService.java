package com.github.diegopacheco.sandboxspring.service;

import java.util.Objects;

public class ExtendedDateService implements DateService {

    private DateService ds;

    ExtendedDateService(DateService ds){
        this.ds = ds;
    }

    @Override
    public String getCurrentDate() {
        return "*** " + ds.getCurrentDate();
    }

    public DateService getDs() {
        return ds;
    }
    public void setDs(DateService ds) {
        this.ds = ds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtendedDateService that = (ExtendedDateService) o;
        return Objects.equals(ds, that.ds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ds);
    }

    @Override
    public String toString() {
        return "ExtendedDateService{" +
                "ds=" + ds +
                '}';
    }

}
