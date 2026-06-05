import { useEffect, useMemo } from "react";
import { useParams } from "@tanstack/react-router";
import { wsClient } from "../../lib/wsClient";
import { useChannels } from "../channels/useChannels";
import { MessageList } from "./MessageList";
import { MessageComposer } from "./MessageComposer";

function prefixFor(type: string | undefined): string {
  if (type === "DIRECT") {
    return "●";
  }
  if (type === "PRIVATE") {
    return "🔒";
  }
  return "#";
}

export function ChannelView() {
  const params = useParams({ strict: false }) as { channelId?: string };
  const channelId = Number(params.channelId);
  const channels = useChannels();
  const channel = useMemo(
    () => channels.data?.find((item) => item.id === channelId),
    [channels.data, channelId],
  );

  useEffect(() => {
    if (!Number.isNaN(channelId)) {
      wsClient.subscribe(channelId);
      return () => wsClient.unsubscribe(channelId);
    }
    return undefined;
  }, [channelId]);

  return (
    <div className="channel-view">
      <header className="channel-header">
        <div className="channel-title">
          <span className="channel-title-prefix">{prefixFor(channel?.type)}</span>
          <h1>{channel?.name ?? "…"}</h1>
        </div>
        {channel?.type ? <span className="channel-tag">{channel.type.toLowerCase()}</span> : null}
      </header>
      <MessageList channelId={channelId} />
      <MessageComposer channelId={channelId} channelName={channel?.name ?? ""} />
    </div>
  );
}
