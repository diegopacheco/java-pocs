import { useRef, useState } from "react";
import { Button } from "../../components/Button";
import { useSendMessage } from "./useMessages";
import { useUploadMedia } from "../media/useMedia";
import { isYoutubeUrl, youtubeId } from "../../lib/youtube";
import type { AttachmentInput } from "../../types/api";

export function MessageComposer({ channelId, channelName }: { channelId: number; channelName: string }) {
  const [text, setText] = useState("");
  const [pending, setPending] = useState<AttachmentInput[]>([]);
  const fileRef = useRef<HTMLInputElement>(null);
  const send = useSendMessage(channelId);
  const upload = useUploadMedia();

  const onPickFile = async (event: React.ChangeEvent<HTMLInputElement>) => {
    const file = event.target.files?.[0];
    event.target.value = "";
    if (!file) {
      return;
    }
    const media = await upload.mutateAsync(file);
    setPending((current) => [
      ...current,
      { kind: media.kind, url: media.url, mimeType: media.mimeType, sizeBytes: media.sizeBytes },
    ]);
  };

  const removePending = (index: number) => {
    setPending((current) => current.filter((_, position) => position !== index));
  };

  const submit = () => {
    const attachments = [...pending];
    const words = text.trim().split(/\s+/);
    const kept: string[] = [];
    for (const word of words) {
      if (isYoutubeUrl(word)) {
        const id = youtubeId(word);
        if (id) {
          attachments.push({ kind: "YOUTUBE", url: id });
          continue;
        }
      }
      kept.push(word);
    }
    const content = kept.join(" ").trim();
    if (!content && attachments.length === 0) {
      return;
    }
    send.mutate(
      { content, attachments },
      {
        onSuccess: () => {
          setText("");
          setPending([]);
        },
      },
    );
  };

  const onKeyDown = (event: React.KeyboardEvent<HTMLTextAreaElement>) => {
    if (event.key === "Enter" && !event.shiftKey) {
      event.preventDefault();
      submit();
    }
  };

  return (
    <div className="composer">
      {pending.length > 0 ? (
        <div className="composer-attachments">
          {pending.map((attachment, index) => (
            <div key={`${attachment.url}-${index}`} className="composer-chip">
              <img src={attachment.url} alt="upload preview" />
              <button onClick={() => removePending(index)} aria-label="Remove">
                ×
              </button>
            </div>
          ))}
        </div>
      ) : null}
      <div className="composer-row">
        <button
          className="icon-button composer-attach"
          title="Attach image or GIF"
          onClick={() => fileRef.current?.click()}
          disabled={upload.isPending}
        >
          {upload.isPending ? "…" : "📎"}
        </button>
        <input
          ref={fileRef}
          type="file"
          accept="image/png,image/jpeg,image/gif,image/webp"
          hidden
          onChange={onPickFile}
        />
        <textarea
          className="composer-input"
          value={text}
          placeholder={`Message ${channelName || "channel"}`}
          onChange={(event) => setText(event.target.value)}
          onKeyDown={onKeyDown}
          rows={1}
        />
        <Button onClick={submit} disabled={send.isPending}>
          Send
        </Button>
      </div>
      <p className="composer-hint">Enter to send · Shift+Enter for a new line · paste a YouTube link to embed</p>
    </div>
  );
}
