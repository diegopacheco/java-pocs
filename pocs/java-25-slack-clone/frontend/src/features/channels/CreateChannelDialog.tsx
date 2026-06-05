import { useState } from "react";
import { Dialog } from "../../components/Dialog";
import { Button } from "../../components/Button";
import { Avatar } from "../../components/Avatar";
import { useCreateChannel, useDirectory } from "./useChannels";

export function CreateChannelDialog({ onClose }: { onClose: () => void }) {
  const [name, setName] = useState("");
  const [type, setType] = useState<"PUBLIC" | "PRIVATE">("PUBLIC");
  const [memberIds, setMemberIds] = useState<number[]>([]);
  const directory = useDirectory(type === "PRIVATE");
  const create = useCreateChannel();

  const toggleMember = (id: number) => {
    setMemberIds((current) =>
      current.includes(id) ? current.filter((value) => value !== id) : [...current, id],
    );
  };

  const submit = () => {
    if (!name.trim()) {
      return;
    }
    create.mutate({ name: name.trim(), type, memberIds }, { onSuccess: onClose });
  };

  return (
    <Dialog title="Create a channel" onClose={onClose}>
      <label className="field">
        <span>Name</span>
        <input value={name} onChange={(event) => setName(event.target.value)} placeholder="marketing" autoFocus />
      </label>

      <div className="field">
        <span>Visibility</span>
        <div className="segmented">
          <button
            className={type === "PUBLIC" ? "segmented-item active" : "segmented-item"}
            onClick={() => setType("PUBLIC")}
          >
            # Public
          </button>
          <button
            className={type === "PRIVATE" ? "segmented-item active" : "segmented-item"}
            onClick={() => setType("PRIVATE")}
          >
            🔒 Private
          </button>
        </div>
      </div>

      {type === "PRIVATE" ? (
        <div className="field">
          <span>Invite members</span>
          <div className="member-picker">
            {(directory.data ?? []).map((person) => (
              <label key={person.id} className="member-row">
                <input
                  type="checkbox"
                  checked={memberIds.includes(person.id)}
                  onChange={() => toggleMember(person.id)}
                />
                <Avatar user={person} size={28} />
                <span>{person.displayName}</span>
              </label>
            ))}
            {(directory.data ?? []).length === 0 ? <p className="sidebar-hint">No other users yet</p> : null}
          </div>
        </div>
      ) : null}

      <div className="dialog-actions">
        <Button variant="ghost" onClick={onClose}>
          Cancel
        </Button>
        <Button onClick={submit} disabled={create.isPending || !name.trim()}>
          {create.isPending ? "Creating…" : "Create"}
        </Button>
      </div>
    </Dialog>
  );
}
