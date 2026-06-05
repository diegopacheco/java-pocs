import type { RealtimeFrame } from "../types/api";

type Handler = (frame: RealtimeFrame) => void;

class WsClient {
  private ws: WebSocket | null = null;
  private token: string | null = null;
  private readonly handlers = new Set<Handler>();
  private readonly subscriptions = new Set<number>();
  private reconnectTimer: number | null = null;

  connect(token: string): void {
    if (this.token === token && this.ws) {
      return;
    }
    this.token = token;
    this.open();
  }

  disconnect(): void {
    this.token = null;
    this.subscriptions.clear();
    if (this.reconnectTimer) {
      window.clearTimeout(this.reconnectTimer);
      this.reconnectTimer = null;
    }
    this.ws?.close();
    this.ws = null;
  }

  on(handler: Handler): () => void {
    this.handlers.add(handler);
    return () => {
      this.handlers.delete(handler);
    };
  }

  subscribe(channelId: number): void {
    this.subscriptions.add(channelId);
    this.send({ type: "subscribe", channelId });
  }

  unsubscribe(channelId: number): void {
    this.subscriptions.delete(channelId);
    this.send({ type: "unsubscribe", channelId });
  }

  private open(): void {
    if (!this.token) {
      return;
    }
    const protocol = location.protocol === "https:" ? "wss" : "ws";
    const socket = new WebSocket(`${protocol}://${location.host}/ws?token=${encodeURIComponent(this.token)}`);
    this.ws = socket;
    socket.onopen = () => {
      this.subscriptions.forEach((channelId) => this.send({ type: "subscribe", channelId }));
    };
    socket.onmessage = (event) => {
      try {
        const frame = JSON.parse(event.data) as RealtimeFrame;
        this.handlers.forEach((handler) => handler(frame));
      } catch {
        return;
      }
    };
    socket.onclose = () => {
      this.ws = null;
      this.scheduleReconnect();
    };
    socket.onerror = () => {
      socket.close();
    };
  }

  private scheduleReconnect(): void {
    if (this.reconnectTimer || !this.token) {
      return;
    }
    this.reconnectTimer = window.setTimeout(() => {
      this.reconnectTimer = null;
      this.open();
    }, 1500);
  }

  private send(payload: unknown): void {
    if (this.ws && this.ws.readyState === WebSocket.OPEN) {
      this.ws.send(JSON.stringify(payload));
    }
  }
}

export const wsClient = new WsClient();
