export interface AuthUser {
  id: number;
  username: string;
  displayName: string;
  avatarUrl?: string | null;
}

export interface AuthResponse {
  token: string;
  user: AuthUser;
}

export type ChannelType = "PUBLIC" | "PRIVATE" | "DIRECT";

export interface Channel {
  id: number;
  name: string;
  type: ChannelType;
  createdBy: number;
  counterpart?: AuthUser | null;
  createdAt: string;
}

export type AttachmentKind = "IMAGE" | "GIF" | "YOUTUBE";

export interface Attachment {
  id: number;
  kind: AttachmentKind;
  url: string;
  mimeType?: string | null;
  sizeBytes?: number | null;
}

export interface AttachmentInput {
  kind: AttachmentKind;
  url: string;
  mimeType?: string;
  sizeBytes?: number;
}

export interface Message {
  id: number;
  channelId: number;
  author: AuthUser;
  content: string;
  createdAt: string;
  editedAt?: string | null;
  attachments: Attachment[];
}

export type NotificationKind = "MENTION" | "DIRECT_MESSAGE";

export interface Notification {
  id: number;
  kind: NotificationKind;
  isRead: boolean;
  channelId: number;
  messageId: number;
  actor?: AuthUser | null;
  snippet: string;
  createdAt: string;
}

export interface MediaResponse {
  url: string;
  kind: "IMAGE" | "GIF";
  mimeType: string;
  sizeBytes: number;
}

export interface RealtimeFrame {
  type: "message" | "notification";
  channelId?: number;
  message?: Message;
  notification?: Notification;
}
