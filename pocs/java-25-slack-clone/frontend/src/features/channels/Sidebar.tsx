import { useState } from "react";
import { Link } from "@tanstack/react-router";
import { Avatar } from "../../components/Avatar";
import { useCurrentUser, useLogout } from "../auth/useAuth";
import { NotificationBell } from "../notifications/NotificationBell";
import { CreateChannelDialog } from "./CreateChannelDialog";
import { BrowseChannelsDialog } from "./BrowseChannelsDialog";
import { StartDmDialog } from "./StartDmDialog";
import { useChannels } from "./useChannels";
import type { Channel } from "../../types/api";

type ActiveDialog = "create" | "browse" | "dm" | null;

export function Sidebar() {
  const user = useCurrentUser();
  const logout = useLogout();
  const channels = useChannels();
  const [dialog, setDialog] = useState<ActiveDialog>(null);

  const list = channels.data ?? [];
  const rooms = list.filter((channel) => channel.type !== "DIRECT");
  const dms = list.filter((channel) => channel.type === "DIRECT");

  return (
    <aside className="sidebar">
      <div className="sidebar-head">
        <div className="brand">
          <span className="brand-logo">◆</span>
          <span className="brand-name">Slack Clone</span>
        </div>
        <NotificationBell />
      </div>

      <div className="sidebar-scroll">
        <SidebarSection title="Channels" onAdd={() => setDialog("create")}>
          {rooms.map((channel) => (
            <ChannelLink key={channel.id} channel={channel} />
          ))}
          {rooms.length === 0 ? <p className="sidebar-hint">No channels yet</p> : null}
          <button className="browse-row" title="Browse channels" onClick={() => setDialog("browse")}>
            <span className="channel-prefix">⌕</span>
            <span>Browse channels</span>
          </button>
        </SidebarSection>

        <SidebarSection title="Direct Messages" onAdd={() => setDialog("dm")}>
          {dms.map((channel) => (
            <ChannelLink key={channel.id} channel={channel} direct />
          ))}
          {dms.length === 0 ? <p className="sidebar-hint">No conversations yet</p> : null}
        </SidebarSection>
      </div>

      <div className="sidebar-foot">
        {user ? (
          <>
            <Avatar user={user} size={32} />
            <div className="sidebar-foot-name">
              <strong>{user.displayName}</strong>
              <span>@{user.username}</span>
            </div>
          </>
        ) : null}
        <button className="link-button" onClick={logout}>
          Sign out
        </button>
      </div>

      {dialog === "create" ? <CreateChannelDialog onClose={() => setDialog(null)} /> : null}
      {dialog === "browse" ? <BrowseChannelsDialog onClose={() => setDialog(null)} /> : null}
      {dialog === "dm" ? <StartDmDialog onClose={() => setDialog(null)} /> : null}
    </aside>
  );
}

function SidebarSection({
  title,
  onAdd,
  children,
}: {
  title: string;
  onAdd: () => void;
  children: React.ReactNode;
}) {
  return (
    <section className="sidebar-section">
      <header className="sidebar-section-head">
        <span>{title}</span>
        <span className="sidebar-section-actions">
          <button className="icon-button" title={`Add ${title}`} onClick={onAdd}>
            +
          </button>
        </span>
      </header>
      <div className="sidebar-list">{children}</div>
    </section>
  );
}

function ChannelLink({ channel, direct = false }: { channel: Channel; direct?: boolean }) {
  return (
    <Link
      to="/c/$channelId"
      params={{ channelId: String(channel.id) }}
      className="channel-link"
      activeProps={{ className: "channel-link active" }}
    >
      <span className="channel-prefix">{direct ? "●" : channel.type === "PRIVATE" ? "🔒" : "#"}</span>
      <span className="channel-name">{channel.name}</span>
    </Link>
  );
}
