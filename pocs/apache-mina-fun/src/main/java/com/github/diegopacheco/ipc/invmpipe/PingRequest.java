package com.github.diegopacheco.ipc.invmpipe;

import java.util.Objects;

public class PingRequest {

    private boolean pong = false;

    public PingRequest(){}

    public boolean isPong() {
        return pong;
    }
    public void setPong(boolean pong) {
        this.pong = pong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PingRequest that = (PingRequest) o;
        return isPong() == that.isPong();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPong());
    }

    @Override
    public String toString() {
        return "PingRequest{" +
                "pong=" + pong +
                '}';
    }

}
