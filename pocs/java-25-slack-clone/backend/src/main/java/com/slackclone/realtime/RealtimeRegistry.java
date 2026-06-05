package com.slackclone.realtime;

import com.slackclone.message.MessageDto;
import com.slackclone.notification.NotificationDto;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import tools.jackson.databind.ObjectMapper;

@Component
public class RealtimeRegistry {

    private final ObjectMapper mapper;
    private final Map<Long, Set<WebSocketSession>> userSessions = new ConcurrentHashMap<>();
    private final Map<Long, Set<WebSocketSession>> channelSessions = new ConcurrentHashMap<>();

    public RealtimeRegistry(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void register(Long userId, WebSocketSession session) {
        userSessions.computeIfAbsent(userId, key -> ConcurrentHashMap.newKeySet()).add(session);
    }

    public void subscribe(Long channelId, WebSocketSession session) {
        channelSessions.computeIfAbsent(channelId, key -> ConcurrentHashMap.newKeySet()).add(session);
    }

    public void unsubscribe(Long channelId, WebSocketSession session) {
        Set<WebSocketSession> sessions = channelSessions.get(channelId);
        if (sessions != null) {
            sessions.remove(session);
        }
    }

    public void remove(WebSocketSession session) {
        userSessions.values().forEach(set -> set.remove(session));
        channelSessions.values().forEach(set -> set.remove(session));
    }

    public void broadcastMessage(Long channelId, MessageDto message) {
        send(channelSessions.get(channelId), OutboundFrame.message(channelId, message));
    }

    public void sendNotification(Long userId, NotificationDto notification) {
        send(userSessions.get(userId), OutboundFrame.notification(notification));
    }

    private void send(Set<WebSocketSession> sessions, OutboundFrame frame) {
        if (sessions == null || sessions.isEmpty()) {
            return;
        }
        TextMessage text = new TextMessage(mapper.writeValueAsString(frame));
        for (WebSocketSession session : sessions) {
            if (!session.isOpen()) {
                continue;
            }
            try {
                synchronized (session) {
                    session.sendMessage(text);
                }
            } catch (IOException ignored) {
                sessions.remove(session);
            }
        }
    }
}
