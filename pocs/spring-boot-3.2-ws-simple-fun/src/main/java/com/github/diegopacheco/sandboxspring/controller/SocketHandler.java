package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SocketHandler extends TextWebSocketHandler {

    private static final Map<String,WebSocketSession> users = new ConcurrentHashMap<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        System.out.println("got ws message : " + message);
        registerIfNeeded(session);

        String payload = message.getPayload();
        session.sendMessage(new TextMessage("user[" + session.getId() + "] says: " + message));
    }

    @Scheduled(cron= "0/3 * * ? * *")
    public static void serverSaysBack() throws Exception{
        Set<String> loggerUsers = users.keySet();
        int userCount = 0;
        if (!loggerUsers.isEmpty()){
            System.out.println(users.size() + " ws sessions actives now... ");
            for (String user: loggerUsers){
                users.get(user).sendMessage(new TextMessage("Server says: hey how is it going?"));
                userCount++;
            }
        }
        System.out.println(userCount + " ws users notified! ");
    }

    private static void registerIfNeeded(WebSocketSession session){
        users.put(session.getId(),session);
    }

}