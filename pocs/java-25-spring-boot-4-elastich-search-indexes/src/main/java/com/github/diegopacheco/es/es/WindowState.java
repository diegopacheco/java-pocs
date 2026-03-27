package com.github.diegopacheco.es.es;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class WindowState {

    private final AtomicReference<LocalDate> windowEnd = new AtomicReference<>(LocalDate.now());

    public LocalDate getWindowEnd() {
        return windowEnd.get();
    }

    public void setWindowEnd(LocalDate date) {
        windowEnd.set(date);
    }
}
