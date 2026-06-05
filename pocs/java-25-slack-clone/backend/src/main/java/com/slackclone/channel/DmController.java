package com.slackclone.channel;

import com.slackclone.auth.AuthUser;
import com.slackclone.auth.CurrentUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dms")
public class DmController {

    private final ChannelService channels;

    public DmController(ChannelService channels) {
        this.channels = channels;
    }

    @PostMapping("/{userId}")
    public ChannelDto open(@CurrentUser AuthUser user, @PathVariable Long userId) {
        return channels.openDirect(user, userId);
    }
}
