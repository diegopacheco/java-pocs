import { useState } from "react";
import { useNotifications } from "./useNotifications";
import { NotificationPanel } from "./NotificationPanel";

export function NotificationBell() {
  const [open, setOpen] = useState(false);
  const notifications = useNotifications();
  const unread = (notifications.data ?? []).filter((item) => !item.isRead).length;

  return (
    <div className="bell-wrap">
      <button className="icon-button bell" title="Notifications" onClick={() => setOpen((value) => !value)}>
        🔔
        {unread > 0 ? <span className="badge">{unread > 9 ? "9+" : unread}</span> : null}
      </button>
      {open ? <NotificationPanel onClose={() => setOpen(false)} /> : null}
    </div>
  );
}
