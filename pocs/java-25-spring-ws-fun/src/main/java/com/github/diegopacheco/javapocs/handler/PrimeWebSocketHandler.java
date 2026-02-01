package com.github.diegopacheco.javapocs.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.javapocs.model.PrimeNumber;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class PrimeWebSocketHandler extends TextWebSocketHandler {

    private final CopyOnWriteArraySet<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<PrimeNumber> discoveredPrimes = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong currentNumber = new AtomicLong(2);
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public PrimeWebSocketHandler() {
        scheduler.scheduleWithFixedDelay(this::discoverNextPrime, 0, 500, TimeUnit.MILLISECONDS);
    }

    private void discoverNextPrime() {
        long num = currentNumber.getAndIncrement();
        if (isPrime(num)) {
            PrimeNumber prime = new PrimeNumber(num, System.currentTimeMillis());
            discoveredPrimes.add(prime);
            broadcast(prime);
        }
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void broadcast(PrimeNumber prime) {
        try {
            String json = objectMapper.writeValueAsString(prime);
            TextMessage message = new TextMessage(json);
            for (WebSocketSession s : sessions) {
                if (s.isOpen()) {
                    s.sendMessage(message);
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        String json = objectMapper.writeValueAsString(discoveredPrimes);
        session.sendMessage(new TextMessage("{\"type\":\"history\",\"primes\":" + json + "}"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }

    public List<PrimeNumber> getAllDiscoveredPrimes() {
        return new ArrayList<>(discoveredPrimes);
    }
}
