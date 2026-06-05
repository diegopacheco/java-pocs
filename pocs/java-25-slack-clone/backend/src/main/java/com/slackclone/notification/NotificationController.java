package com.slackclone.notification;

import com.slackclone.auth.AuthUser;
import com.slackclone.auth.CurrentUser;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notifications;

    public NotificationController(NotificationService notifications) {
        this.notifications = notifications;
    }

    @GetMapping
    public List<NotificationDto> list(@CurrentUser AuthUser user) {
        return notifications.list(user.id());
    }

    @PostMapping("/{id}/read")
    public void read(@CurrentUser AuthUser user, @PathVariable Long id) {
        notifications.markRead(user.id(), id);
    }

    @PostMapping("/read-all")
    public void readAll(@CurrentUser AuthUser user) {
        notifications.markAllRead(user.id());
    }
}
