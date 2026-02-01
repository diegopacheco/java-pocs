package com.github.diegopacheco.javapocs.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.javapocs.model.ChatMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final CopyOnWriteArraySet<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        ChatMessage incoming = objectMapper.readValue(message.getPayload(), ChatMessage.class);
        ChatMessage outgoing = new ChatMessage(incoming.nickname(), incoming.content(), System.currentTimeMillis());
        String json = objectMapper.writeValueAsString(outgoing);
        TextMessage response = new TextMessage(json);
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(response);
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }
}
