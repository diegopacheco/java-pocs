package com.slackclone.realtime;

import com.slackclone.auth.SessionRepository;
import java.util.Map;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Component
public class HandshakeAuthInterceptor implements HandshakeInterceptor {

    private final SessionRepository sessions;

    public HandshakeAuthInterceptor(SessionRepository sessions) {
        this.sessions = sessions;
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
            WebSocketHandler wsHandler, Map<String, Object> attributes) {
        String token = tokenFromQuery(request.getURI().getQuery());
        if (token != null) {
            sessions.findByToken(token).ifPresent(session -> attributes.put("userId", session.userId()));
        }
        return attributes.containsKey("userId");
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
            WebSocketHandler wsHandler, Exception exception) {
    }

    private static String tokenFromQuery(String query) {
        if (query == null) {
            return null;
        }
        for (String pair : query.split("&")) {
            int eq = pair.indexOf('=');
            if (eq > 0 && pair.substring(0, eq).equals("token")) {
                return pair.substring(eq + 1);
            }
        }
        return null;
    }
}
