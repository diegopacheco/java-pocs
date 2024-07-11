package com.github.diegopacheco.sandboxspring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

//@Component
public class CustomHeaderLoggingFilter implements WebFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomHeaderLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String xForwardedForHeader = request.getHeaders().getFirst("X-FORWARDED-FOR");

        if (xForwardedForHeader != null) {
            logger.info("X-FORWARDED-FOR: {}", xForwardedForHeader);
        }
        return chain.filter(exchange);
    }
}