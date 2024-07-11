package com.github.diegopacheco.sandboxspring.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

//@Component
public class CustomHeaderLoggingFilter implements WebFilter {
    private static final Logger logger = LogManager.getLogger(CustomHeaderLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        logger.info("CustomHeaderLoggingFilter running... ");
        ServerHttpRequest request = exchange.getRequest();
        request.getHeaders().forEach((name, values) -> {
            String value = String.join(", ", values);
            logger.info("Header '{}': {}", name, value); // Debug log to verify header
            ThreadContext.put(name, value);
        });

        return chain.filter(exchange)
                .doFinally(signalType -> ThreadContext.clearAll());
    }
}