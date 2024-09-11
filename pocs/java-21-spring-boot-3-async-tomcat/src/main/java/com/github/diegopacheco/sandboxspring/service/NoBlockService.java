package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NoBlockService {
    public String getDate() {
        return new Date().toString();
    }
}
