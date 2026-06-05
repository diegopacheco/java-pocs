import { EmptyState } from "../../components/EmptyState";
import { useCurrentUser } from "../auth/useAuth";

export function WelcomeView() {
  const user = useCurrentUser();
  return (
    <div className="welcome">
      <EmptyState
        icon="◆"
        title={`Hi ${user?.displayName ?? "there"} 👋`}
        subtitle="Pick a channel on the left, browse public ones, or start a direct message to begin chatting."
      />
    </div>
  );
}
