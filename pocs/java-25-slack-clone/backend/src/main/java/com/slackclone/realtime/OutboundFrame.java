package com.slackclone.realtime;

import com.slackclone.message.MessageDto;
import com.slackclone.notification.NotificationDto;

public record OutboundFrame(
        String type,
        Long channelId,
        MessageDto message,
        NotificationDto notification) {

    public static OutboundFrame message(Long channelId, MessageDto message) {
        return new OutboundFrame("message", channelId, message, null);
    }

    public static OutboundFrame notification(NotificationDto notification) {
        return new OutboundFrame("notification", null, null, notification);
    }
}
