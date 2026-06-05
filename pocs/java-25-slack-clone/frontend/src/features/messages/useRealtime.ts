import { useEffect } from "react";
import { useQueryClient } from "@tanstack/react-query";
import { getToken } from "../../lib/auth";
import { addMessageToCache } from "../../lib/cache";
import { wsClient } from "../../lib/wsClient";
import type { Notification } from "../../types/api";

export function useRealtime() {
  const client = useQueryClient();
  useEffect(() => {
    const token = getToken();
    if (token) {
      wsClient.connect(token);
    }
    return wsClient.on((frame) => {
      if (frame.type === "message" && frame.message && frame.channelId != null) {
        addMessageToCache(client, frame.channelId, frame.message);
      } else if (frame.type === "notification" && frame.notification) {
        const incoming = frame.notification;
        client.setQueryData<Notification[]>(["notifications"], (current) => {
          const list = current ?? [];
          if (list.some((item) => item.id === incoming.id)) {
            return list;
          }
          return [incoming, ...list];
        });
      }
    });
  }, [client]);
}
