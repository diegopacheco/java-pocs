package com.github.diegopacheco.sandboxspring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

@Component
public class MDCHeaderLoggingFilter implements WebFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomHeaderLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String xForwardedForHeader = request.getHeaders().getFirst("X-FORWARDED-FOR");
        if (xForwardedForHeader != null) {
            logger.info("adding X-FORWARDED-FOR to MDC: {}", xForwardedForHeader.trim());
            MDC.put("X-FORWARDED-FOR", xForwardedForHeader.trim());
        }
        return chain.
            filter(exchange).
            contextWrite(Context.of("X-FORWARDED-FOR", xForwardedForHeader.trim())).
            doFinally(signalType -> {
                MDC.put("X-FORWARDED-FOR", xForwardedForHeader.trim());
            });
    }
}