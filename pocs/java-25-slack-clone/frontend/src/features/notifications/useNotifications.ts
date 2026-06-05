import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { api } from "../../lib/apiClient";
import type { Notification } from "../../types/api";

export function useNotifications() {
  return useQuery({ queryKey: ["notifications"], queryFn: () => api.get<Notification[]>("/api/notifications") });
}

export function useMarkRead() {
  const client = useQueryClient();
  return useMutation({
    mutationFn: (id: number) => api.post<void>(`/api/notifications/${id}/read`),
    onSuccess: (_data, id) =>
      client.setQueryData<Notification[]>(["notifications"], (current) =>
        (current ?? []).map((item) => (item.id === id ? { ...item, isRead: true } : item)),
      ),
  });
}

export function useMarkAllRead() {
  const client = useQueryClient();
  return useMutation({
    mutationFn: () => api.post<void>("/api/notifications/read-all"),
    onSuccess: () =>
      client.setQueryData<Notification[]>(["notifications"], (current) =>
        (current ?? []).map((item) => ({ ...item, isRead: true })),
      ),
  });
}
