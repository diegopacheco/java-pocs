import { Dialog } from "../../components/Dialog";
import { Avatar } from "../../components/Avatar";
import { EmptyState } from "../../components/EmptyState";
import { useDirectory, useStartDm } from "./useChannels";

export function StartDmDialog({ onClose }: { onClose: () => void }) {
  const directory = useDirectory(true);
  const startDm = useStartDm();

  const people = directory.data ?? [];

  return (
    <Dialog title="Start a direct message" onClose={onClose}>
      {people.length === 0 ? (
        <EmptyState icon="👋" title="No one else here yet" subtitle="Invite a teammate to register first." />
      ) : (
        <ul className="people-list">
          {people.map((person) => (
            <li key={person.id}>
              <button
                className="people-row"
                onClick={() => startDm.mutate(person.id, { onSuccess: onClose })}
                disabled={startDm.isPending}
              >
                <Avatar user={person} size={34} />
                <div className="people-meta">
                  <strong>{person.displayName}</strong>
                  <span>@{person.username}</span>
                </div>
              </button>
            </li>
          ))}
        </ul>
      )}
    </Dialog>
  );
}
