package com.slackclone.realtime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InboundFrame(String type, Long channelId) {
}
