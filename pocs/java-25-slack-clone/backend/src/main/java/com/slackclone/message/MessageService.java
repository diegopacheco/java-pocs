package com.slackclone.message;

import com.slackclone.auth.AuthService;
import com.slackclone.auth.AuthUser;
import com.slackclone.channel.Channel;
import com.slackclone.channel.ChannelMember;
import com.slackclone.channel.ChannelMemberRepository;
import com.slackclone.channel.ChannelRepository;
import com.slackclone.notification.Notification;
import com.slackclone.notification.NotificationService;
import com.slackclone.realtime.RealtimeRegistry;
import com.slackclone.user.User;
import com.slackclone.user.UserRepository;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.data.domain.Limit;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MessageService {

    private static final Pattern MENTION = Pattern.compile("@([a-zA-Z0-9_]+)");
    private static final Set<String> ALLOWED_KINDS = Set.of(Attachment.IMAGE, Attachment.GIF, Attachment.YOUTUBE);

    private final MessageRepository messages;
    private final ChannelRepository channels;
    private final ChannelMemberRepository members;
    private final UserRepository users;
    private final NotificationService notificationService;
    private final RealtimeRegistry realtime;

    public MessageService(MessageRepository messages, ChannelRepository channels, ChannelMemberRepository members,
            UserRepository users, NotificationService notificationService, RealtimeRegistry realtime) {
        this.messages = messages;
        this.channels = channels;
        this.members = members;
        this.users = users;
        this.notificationService = notificationService;
        this.realtime = realtime;
    }

    public MessageDto send(AuthUser author, Long channelId, String content, List<AttachmentInput> attachments) {
        Channel channel = channels.findById(channelId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "channel not found"));
        requireMember(channelId, author.id());
        String text = content == null ? "" : content.trim();
        Set<Attachment> built = toAttachments(attachments);
        if (text.isEmpty() && built.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "empty message");
        }
        Message saved = messages.save(new Message(null, channelId, author.id(), text, Instant.now(), null, built));
        MessageDto dto = toDto(saved, author);
        realtime.broadcastMessage(channelId, dto);
        fanOutNotifications(channel, saved, author);
        return dto;
    }

    public List<MessageDto> history(AuthUser viewer, Long channelId, Long before, int limit) {
        requireMember(channelId, viewer.id());
        Limit capped = Limit.of(Math.max(1, Math.min(limit, 100)));
        List<Message> page = before == null
                ? messages.findByChannelIdOrderByIdDesc(channelId, capped)
                : messages.findByChannelIdAndIdLessThanOrderByIdDesc(channelId, before, capped);
        Map<Long, AuthUser> authors = loadAuthors(page);
        List<MessageDto> result = new ArrayList<>();
        for (Message message : page) {
            result.add(toDto(message, authors.get(message.userId())));
        }
        return result;
    }

    private void fanOutNotifications(Channel channel, Message message, AuthUser author) {
        if (Channel.DIRECT.equals(channel.type())) {
            for (ChannelMember member : members.findByChannelId(channel.id())) {
                if (!member.userId().equals(author.id())) {
                    notificationService.notify(member.userId(), message, Notification.DIRECT_MESSAGE, author);
                }
            }
            return;
        }
        Matcher matcher = MENTION.matcher(message.content());
        Set<String> seen = new HashSet<>();
        while (matcher.find()) {
            String username = matcher.group(1);
            if (!seen.add(username.toLowerCase())) {
                continue;
            }
            users.findByUsername(username).ifPresent(user -> {
                if (!user.id().equals(author.id()) && members.existsByChannelIdAndUserId(channel.id(), user.id())) {
                    notificationService.notify(user.id(), message, Notification.MENTION, author);
                }
            });
        }
    }

    private Set<Attachment> toAttachments(List<AttachmentInput> inputs) {
        if (inputs == null || inputs.isEmpty()) {
            return Set.of();
        }
        Set<Attachment> result = new LinkedHashSet<>();
        for (AttachmentInput input : inputs) {
            if (input == null || input.kind() == null || input.url() == null || input.url().isBlank()) {
                continue;
            }
            String kind = input.kind().toUpperCase();
            if (!ALLOWED_KINDS.contains(kind)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid attachment kind");
            }
            result.add(new Attachment(null, kind, input.url(), input.mimeType(), input.sizeBytes()));
        }
        return result;
    }

    private Map<Long, AuthUser> loadAuthors(List<Message> page) {
        Set<Long> ids = new HashSet<>();
        for (Message message : page) {
            ids.add(message.userId());
        }
        Map<Long, AuthUser> map = new HashMap<>();
        for (User user : users.findAllById(ids)) {
            map.put(user.id(), AuthService.toAuthUser(user));
        }
        return map;
    }

    private MessageDto toDto(Message message, AuthUser author) {
        List<AttachmentDto> attachments = new ArrayList<>();
        if (message.attachments() != null) {
            for (Attachment attachment : message.attachments()) {
                attachments.add(new AttachmentDto(attachment.id(), attachment.kind(), attachment.url(),
                        attachment.mimeType(), attachment.sizeBytes()));
            }
        }
        return new MessageDto(message.id(), message.channelId(), author, message.content(),
                message.createdAt(), message.editedAt(), attachments);
    }

    private void requireMember(Long channelId, Long userId) {
        if (!members.existsByChannelIdAndUserId(channelId, userId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "not a member");
        }
    }
}
