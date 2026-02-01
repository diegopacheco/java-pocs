package com.github.diegopacheco.javapocs.controller;

import com.github.diegopacheco.javapocs.handler.PrimeWebSocketHandler;
import com.github.diegopacheco.javapocs.model.PrimeNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrimeController {

    private final PrimeWebSocketHandler primeHandler;

    public PrimeController(PrimeWebSocketHandler primeHandler) {
        this.primeHandler = primeHandler;
    }

    @GetMapping("/primes")
    public List<PrimeNumber> getAllPrimes() {
        return primeHandler.getAllDiscoveredPrimes();
    }
}
