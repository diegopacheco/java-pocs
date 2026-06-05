package com.slackclone.channel;

import com.slackclone.auth.AuthService;
import com.slackclone.auth.AuthUser;
import com.slackclone.user.User;
import com.slackclone.user.UserRepository;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ChannelService {

    private final ChannelRepository channels;
    private final ChannelMemberRepository members;
    private final UserRepository users;

    public ChannelService(ChannelRepository channels, ChannelMemberRepository members, UserRepository users) {
        this.channels = channels;
        this.members = members;
        this.users = users;
    }

    public ChannelDto create(AuthUser creator, String name, String type, List<Long> memberIds) {
        String normalized = type == null ? "" : type.toUpperCase();
        if (!normalized.equals(Channel.PUBLIC) && !normalized.equals(Channel.PRIVATE)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid channel type");
        }
        if (name == null || name.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name required");
        }
        Channel saved = channels.save(new Channel(null, name.trim(), normalized, creator.id(), Instant.now()));
        members.save(new ChannelMember(null, saved.id(), creator.id(), ChannelMember.OWNER, Instant.now()));
        if (memberIds != null) {
            for (Long id : new LinkedHashSet<>(memberIds)) {
                if (!id.equals(creator.id()) && users.existsById(id)
                        && !members.existsByChannelIdAndUserId(saved.id(), id)) {
                    members.save(new ChannelMember(null, saved.id(), id, ChannelMember.MEMBER, Instant.now()));
                }
            }
        }
        return toDto(saved, creator.id());
    }

    public List<ChannelDto> listForUser(AuthUser user) {
        List<ChannelDto> result = new ArrayList<>();
        for (Channel channel : channels.findByMember(user.id())) {
            result.add(toDto(channel, user.id()));
        }
        return result;
    }

    public List<ChannelDto> listPublic(AuthUser user) {
        List<ChannelDto> result = new ArrayList<>();
        for (Channel channel : channels.findPublicNotJoined(user.id())) {
            result.add(toDto(channel, user.id()));
        }
        return result;
    }

    public ChannelDto join(AuthUser user, Long channelId) {
        Channel channel = channels.findById(channelId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "channel not found"));
        if (!Channel.PUBLIC.equals(channel.type())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "channel is not public");
        }
        if (!members.existsByChannelIdAndUserId(channelId, user.id())) {
            members.save(new ChannelMember(null, channelId, user.id(), ChannelMember.MEMBER, Instant.now()));
        }
        return toDto(channel, user.id());
    }

    public void invite(AuthUser inviter, Long channelId, Long userId) {
        Channel channel = channels.findById(channelId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "channel not found"));
        if (Channel.DIRECT.equals(channel.type())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cannot invite to a direct message");
        }
        if (!members.existsByChannelIdAndUserId(channelId, inviter.id())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "not a member");
        }
        if (!users.existsById(userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }
        if (!members.existsByChannelIdAndUserId(channelId, userId)) {
            members.save(new ChannelMember(null, channelId, userId, ChannelMember.MEMBER, Instant.now()));
        }
    }

    public ChannelDto openDirect(AuthUser user, Long otherId) {
        if (user.id().equals(otherId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cannot message yourself");
        }
        User other = users.findById(otherId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        Channel channel = channels.findDirect(user.id(), otherId).orElseGet(() -> {
            Channel created = channels.save(
                    new Channel(null, directName(user, other), Channel.DIRECT, user.id(), Instant.now()));
            members.save(new ChannelMember(null, created.id(), user.id(), ChannelMember.MEMBER, Instant.now()));
            members.save(new ChannelMember(null, created.id(), otherId, ChannelMember.MEMBER, Instant.now()));
            return created;
        });
        return toDto(channel, user.id());
    }

    public ChannelDto toDto(Channel channel, Long viewerId) {
        if (!Channel.DIRECT.equals(channel.type())) {
            return new ChannelDto(channel.id(), channel.name(), channel.type(),
                    channel.createdBy(), null, channel.createdAt());
        }
        AuthUser counterpart = null;
        for (ChannelMember member : members.findByChannelId(channel.id())) {
            if (!member.userId().equals(viewerId)) {
                counterpart = users.findById(member.userId()).map(AuthService::toAuthUser).orElse(null);
                break;
            }
        }
        String name = counterpart != null ? counterpart.displayName() : channel.name();
        return new ChannelDto(channel.id(), name, channel.type(), channel.createdBy(), counterpart, channel.createdAt());
    }

    private static String directName(AuthUser a, User b) {
        return a.displayName() + " · " + b.displayName();
    }
}
