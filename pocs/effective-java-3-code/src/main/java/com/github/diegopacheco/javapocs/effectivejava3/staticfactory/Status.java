package com.github.diegopacheco.javapocs.effectivejava3.staticfactory;

import java.util.Objects;

public class Status {

    private boolean status;

    private Status(){}

    private Status(boolean status){
        this.status = status;
    }

    public static Status from(String status){
        Objects.requireNonNull(status);
        switch (status.toLowerCase()){
            case "off":
                return new Status(false);
            case "on" :
                return new Status(true);
        }
        throw new IllegalArgumentException("Invalid state: " + status);
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return isStatus() == status1.isStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isStatus());
    }

    @Override
    public String toString() {
        return "Status{" +
                "status=" + status +
                '}';
    }
}
