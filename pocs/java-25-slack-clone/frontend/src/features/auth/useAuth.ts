import { useNavigate } from "@tanstack/react-router";
import { clearSession, getStoredUser } from "../../lib/auth";
import { queryClient } from "../../lib/queryClient";
import { wsClient } from "../../lib/wsClient";

export function useCurrentUser() {
  return getStoredUser();
}

export function useLogout() {
  const navigate = useNavigate();
  return () => {
    wsClient.disconnect();
    clearSession();
    queryClient.clear();
    navigate({ to: "/login" });
  };
}
