import { useInfiniteQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { api } from "../../lib/apiClient";
import { addMessageToCache } from "../../lib/cache";
import type { AttachmentInput, Message } from "../../types/api";

const PAGE_SIZE = 30;

export function useMessages(channelId: number) {
  return useInfiniteQuery({
    queryKey: ["messages", channelId],
    queryFn: ({ pageParam, signal }) =>
      api.get<Message[]>(
        `/api/channels/${channelId}/messages?limit=${PAGE_SIZE}${pageParam ? `&before=${pageParam}` : ""}`,
        signal,
      ),
    initialPageParam: undefined as number | undefined,
    getNextPageParam: (lastPage) =>
      lastPage.length === PAGE_SIZE ? lastPage[lastPage.length - 1].id : undefined,
  });
}

export function useSendMessage(channelId: number) {
  const client = useQueryClient();
  return useMutation({
    mutationFn: (input: { content: string; attachments: AttachmentInput[] }) =>
      api.post<Message>(`/api/channels/${channelId}/messages`, input),
    onSuccess: (message) => addMessageToCache(client, channelId, message),
  });
}
