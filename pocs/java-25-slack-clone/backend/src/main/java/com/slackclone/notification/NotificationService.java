package com.slackclone.notification;

import com.slackclone.auth.AuthService;
import com.slackclone.auth.AuthUser;
import com.slackclone.message.Message;
import com.slackclone.message.MessageRepository;
import com.slackclone.realtime.RealtimeRegistry;
import com.slackclone.user.UserRepository;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Limit;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class NotificationService {

    private final NotificationRepository notifications;
    private final MessageRepository messages;
    private final UserRepository users;
    private final RealtimeRegistry realtime;

    public NotificationService(NotificationRepository notifications, MessageRepository messages,
            UserRepository users, RealtimeRegistry realtime) {
        this.notifications = notifications;
        this.messages = messages;
        this.users = users;
        this.realtime = realtime;
    }

    public void notify(Long recipientId, Message message, String kind, AuthUser actor) {
        Notification saved = notifications.save(
                new Notification(null, recipientId, message.id(), kind, false, Instant.now()));
        realtime.sendNotification(recipientId, toDto(saved, message, actor));
    }

    public List<NotificationDto> list(Long userId) {
        List<NotificationDto> result = new ArrayList<>();
        for (Notification notification : notifications.findByUserIdOrderByIdDesc(userId, Limit.of(50))) {
            Message message = messages.findById(notification.messageId()).orElse(null);
            if (message == null) {
                continue;
            }
            AuthUser actor = users.findById(message.userId()).map(AuthService::toAuthUser).orElse(null);
            result.add(toDto(notification, message, actor));
        }
        return result;
    }

    public void markRead(Long userId, Long id) {
        Notification notification = notifications.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "notification not found"));
        if (!notification.userId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "not your notification");
        }
        if (!notification.isRead()) {
            notifications.save(read(notification));
        }
    }

    public void markAllRead(Long userId) {
        for (Notification notification : notifications.findByUserIdAndIsReadFalse(userId)) {
            notifications.save(read(notification));
        }
    }

    private static Notification read(Notification notification) {
        return new Notification(notification.id(), notification.userId(), notification.messageId(),
                notification.kind(), true, notification.createdAt());
    }

    private static NotificationDto toDto(Notification notification, Message message, AuthUser actor) {
        return new NotificationDto(notification.id(), notification.kind(), notification.isRead(),
                message.channelId(), message.id(), actor, snippet(message), notification.createdAt());
    }

    private static String snippet(Message message) {
        String content = message.content();
        if (content == null || content.isBlank()) {
            return "[attachment]";
        }
        return content.length() <= 80 ? content : content.substring(0, 80) + "…";
    }
}
