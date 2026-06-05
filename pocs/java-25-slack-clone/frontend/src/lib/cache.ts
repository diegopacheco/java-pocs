import type { InfiniteData, QueryClient } from "@tanstack/react-query";
import type { Message } from "../types/api";

export type MessagePages = InfiniteData<Message[], number | undefined>;

export async function addMessageToCache(
  client: QueryClient,
  channelId: number,
  message: Message,
): Promise<void> {
  await client.cancelQueries({ queryKey: ["messages", channelId] });
  client.setQueryData<MessagePages>(["messages", channelId], (current) => {
    if (!current) {
      return { pages: [[message]], pageParams: [undefined] };
    }
    const exists = current.pages.some((page) => page.some((item) => item.id === message.id));
    if (exists) {
      return current;
    }
    const pages = current.pages.slice();
    pages[0] = [message, ...pages[0]];
    return { ...current, pages };
  });
}
