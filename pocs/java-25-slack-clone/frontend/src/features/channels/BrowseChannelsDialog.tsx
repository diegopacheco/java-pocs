import { Dialog } from "../../components/Dialog";
import { Button } from "../../components/Button";
import { EmptyState } from "../../components/EmptyState";
import { usePublicChannels, useJoinChannel } from "./useChannels";

export function BrowseChannelsDialog({ onClose }: { onClose: () => void }) {
  const channels = usePublicChannels(true);
  const join = useJoinChannel();

  const list = channels.data ?? [];

  return (
    <Dialog title="Browse public channels" onClose={onClose}>
      {list.length === 0 ? (
        <EmptyState icon="🧭" title="Nothing to browse" subtitle="You have joined every public channel." />
      ) : (
        <ul className="browse-list">
          {list.map((channel) => (
            <li key={channel.id} className="browse-row">
              <div>
                <strong># {channel.name}</strong>
              </div>
              <Button
                variant="subtle"
                onClick={() => join.mutate(channel.id, { onSuccess: onClose })}
                disabled={join.isPending}
              >
                Join
              </Button>
            </li>
          ))}
        </ul>
      )}
    </Dialog>
  );
}
