package com.slackclone.config;

import com.slackclone.realtime.ChatWebSocketHandler;
import com.slackclone.realtime.HandshakeAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatWebSocketHandler handler;
    private final HandshakeAuthInterceptor interceptor;

    public WebSocketConfig(ChatWebSocketHandler handler, HandshakeAuthInterceptor interceptor) {
        this.handler = handler;
        this.interceptor = interceptor;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler, "/ws")
                .addInterceptors(interceptor)
                .setAllowedOriginPatterns("*");
    }
}
