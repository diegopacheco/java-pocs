import { Outlet } from "@tanstack/react-router";
import { Sidebar } from "../features/channels/Sidebar";
import { useRealtime } from "../features/messages/useRealtime";

export function AppLayout() {
  useRealtime();
  return (
    <div className="app-shell">
      <Sidebar />
      <div className="app-content">
        <Outlet />
      </div>
    </div>
  );
}
