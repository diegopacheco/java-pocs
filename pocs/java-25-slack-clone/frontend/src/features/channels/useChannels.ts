import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { useNavigate } from "@tanstack/react-router";
import { api } from "../../lib/apiClient";
import type { AuthUser, Channel } from "../../types/api";

export function useChannels() {
  return useQuery({ queryKey: ["channels"], queryFn: () => api.get<Channel[]>("/api/channels") });
}

export function usePublicChannels(enabled: boolean) {
  return useQuery({
    queryKey: ["channels", "public"],
    queryFn: () => api.get<Channel[]>("/api/channels/public"),
    enabled,
  });
}

export function useDirectory(enabled: boolean) {
  return useQuery({
    queryKey: ["users"],
    queryFn: () => api.get<AuthUser[]>("/api/users"),
    enabled,
  });
}

function goToChannel(channelId: number) {
  return { to: "/c/$channelId" as const, params: { channelId: String(channelId) } };
}

export function useCreateChannel() {
  const client = useQueryClient();
  const navigate = useNavigate();
  return useMutation({
    mutationFn: (input: { name: string; type: "PUBLIC" | "PRIVATE"; memberIds: number[] }) =>
      api.post<Channel>("/api/channels", input),
    onSuccess: (channel) => {
      client.invalidateQueries({ queryKey: ["channels"] });
      navigate(goToChannel(channel.id));
    },
  });
}

export function useJoinChannel() {
  const client = useQueryClient();
  const navigate = useNavigate();
  return useMutation({
    mutationFn: (channelId: number) => api.post<Channel>(`/api/channels/${channelId}/join`),
    onSuccess: (channel) => {
      client.invalidateQueries({ queryKey: ["channels"] });
      navigate(goToChannel(channel.id));
    },
  });
}

export function useStartDm() {
  const client = useQueryClient();
  const navigate = useNavigate();
  return useMutation({
    mutationFn: (userId: number) => api.post<Channel>(`/api/dms/${userId}`),
    onSuccess: (channel) => {
      client.invalidateQueries({ queryKey: ["channels"] });
      navigate(goToChannel(channel.id));
    },
  });
}
