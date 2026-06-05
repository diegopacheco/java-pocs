package com.slackclone.realtime;

import com.slackclone.channel.ChannelMemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import tools.jackson.databind.ObjectMapper;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final RealtimeRegistry registry;
    private final ChannelMemberRepository members;
    private final ObjectMapper mapper;

    public ChatWebSocketHandler(RealtimeRegistry registry, ChannelMemberRepository members, ObjectMapper mapper) {
        this.registry = registry;
        this.members = members;
        this.mapper = mapper;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        Long userId = userId(session);
        if (userId != null) {
            registry.register(userId, session);
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Long userId = userId(session);
        InboundFrame frame = mapper.readValue(message.getPayload(), InboundFrame.class);
        if (userId == null || frame == null || frame.type() == null || frame.channelId() == null) {
            return;
        }
        switch (frame.type()) {
            case "subscribe" -> {
                if (members.existsByChannelIdAndUserId(frame.channelId(), userId)) {
                    registry.subscribe(frame.channelId(), session);
                }
            }
            case "unsubscribe" -> registry.unsubscribe(frame.channelId(), session);
            default -> {
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        registry.remove(session);
    }

    private static Long userId(WebSocketSession session) {
        Object value = session.getAttributes().get("userId");
        return value instanceof Long id ? id : null;
    }
}
