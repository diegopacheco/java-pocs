package com.slackclone.channel;

import com.slackclone.auth.AuthUser;
import com.slackclone.auth.CurrentUser;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/channels")
public class ChannelController {

    private final ChannelService channels;

    public ChannelController(ChannelService channels) {
        this.channels = channels;
    }

    @GetMapping
    public List<ChannelDto> mine(@CurrentUser AuthUser user) {
        return channels.listForUser(user);
    }

    @GetMapping("/public")
    public List<ChannelDto> browsable(@CurrentUser AuthUser user) {
        return channels.listPublic(user);
    }

    @PostMapping
    public ChannelDto create(@CurrentUser AuthUser user, @RequestBody CreateChannelRequest request) {
        return channels.create(user, request.name(), request.type(), request.memberIds());
    }

    @PostMapping("/{id}/join")
    public ChannelDto join(@CurrentUser AuthUser user, @PathVariable Long id) {
        return channels.join(user, id);
    }

    @PostMapping("/{id}/members")
    public void invite(@CurrentUser AuthUser user, @PathVariable Long id, @RequestBody InviteRequest request) {
        channels.invite(user, id, request.userId());
    }

    public record CreateChannelRequest(String name, String type, List<Long> memberIds) {
    }

    public record InviteRequest(Long userId) {
    }
}
