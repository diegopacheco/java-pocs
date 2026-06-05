package com.slackclone.message;

import com.slackclone.auth.AuthUser;
import com.slackclone.auth.CurrentUser;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/channels/{channelId}/messages")
public class MessageController {

    private final MessageService messages;

    public MessageController(MessageService messages) {
        this.messages = messages;
    }

    @GetMapping
    public List<MessageDto> history(@CurrentUser AuthUser user, @PathVariable Long channelId,
            @RequestParam(required = false) Long before,
            @RequestParam(defaultValue = "30") int limit) {
        return messages.history(user, channelId, before, limit);
    }

    @PostMapping
    public MessageDto send(@CurrentUser AuthUser user, @PathVariable Long channelId,
            @RequestBody SendMessageRequest request) {
        return messages.send(user, channelId, request.content(), request.attachments());
    }

    public record SendMessageRequest(String content, List<AttachmentInput> attachments) {
    }
}
