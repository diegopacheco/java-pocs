import { Avatar } from "../../components/Avatar";
import { AttachmentView } from "../media/AttachmentView";
import { renderContent } from "../../lib/mentions";
import { clockTime } from "../../lib/time";
import type { Message } from "../../types/api";

export function MessageItem({ message, showHeader }: { message: Message; showHeader: boolean }) {
  return (
    <div className={showHeader ? "message message-lead" : "message"}>
      <div className="message-aside">
        {showHeader ? (
          <Avatar user={message.author} size={38} />
        ) : (
          <span className="message-time-hover">{clockTime(message.createdAt)}</span>
        )}
      </div>
      <div className="message-body">
        {showHeader ? (
          <div className="message-meta">
            <strong>{message.author.displayName}</strong>
            <span className="message-time">{clockTime(message.createdAt)}</span>
          </div>
        ) : null}
        {message.content ? <div className="message-text">{renderContent(message.content)}</div> : null}
        {message.attachments.length > 0 ? (
          <div className="attachments">
            {message.attachments.map((attachment) => (
              <AttachmentView key={attachment.id} attachment={attachment} />
            ))}
          </div>
        ) : null}
      </div>
    </div>
  );
}
