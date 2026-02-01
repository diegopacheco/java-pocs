package com.github.diegopacheco.javapocs.config;

import com.github.diegopacheco.javapocs.handler.ChatWebSocketHandler;
import com.github.diegopacheco.javapocs.handler.PrimeWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatWebSocketHandler chatHandler;
    private final PrimeWebSocketHandler primeHandler;

    public WebSocketConfig(ChatWebSocketHandler chatHandler, PrimeWebSocketHandler primeHandler) {
        this.chatHandler = chatHandler;
        this.primeHandler = primeHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/ws/chat").setAllowedOrigins("*");
        registry.addHandler(primeHandler, "/ws/primes").setAllowedOrigins("*");
    }
}
