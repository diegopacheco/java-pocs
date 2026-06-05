import { useNavigate } from "@tanstack/react-router";
import { Avatar } from "../../components/Avatar";
import { EmptyState } from "../../components/EmptyState";
import { clockTime } from "../../lib/time";
import { useMarkAllRead, useMarkRead, useNotifications } from "./useNotifications";

export function NotificationPanel({ onClose }: { onClose: () => void }) {
  const notifications = useNotifications();
  const markRead = useMarkRead();
  const markAll = useMarkAllRead();
  const navigate = useNavigate();

  const list = notifications.data ?? [];

  const open = (channelId: number, id: number) => {
    markRead.mutate(id);
    navigate({ to: "/c/$channelId", params: { channelId: String(channelId) } });
    onClose();
  };

  return (
    <div className="notif-panel" onClick={(event) => event.stopPropagation()}>
      <header className="notif-head">
        <strong>Notifications</strong>
        <button className="link-button" onClick={() => markAll.mutate()}>
          Mark all read
        </button>
      </header>
      <div className="notif-list">
        {list.length === 0 ? (
          <EmptyState icon="🔔" title="All caught up" subtitle="No notifications yet." />
        ) : (
          list.map((notification) => (
            <button
              key={notification.id}
              className={notification.isRead ? "notif-row" : "notif-row unread"}
              onClick={() => open(notification.channelId, notification.id)}
            >
              {notification.actor ? <Avatar user={notification.actor} size={30} /> : null}
              <div className="notif-meta">
                <span className="notif-kind">
                  {notification.kind === "MENTION" ? "Mention" : "Direct message"}
                </span>
                <span className="notif-snippet">
                  <strong>{notification.actor?.displayName ?? "Someone"}</strong> · {notification.snippet}
                </span>
              </div>
              <span className="notif-time">{clockTime(notification.createdAt)}</span>
            </button>
          ))
        )}
      </div>
    </div>
  );
}
