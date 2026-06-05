import type { ReactNode } from "react";

const SPLIT = /(@[a-zA-Z0-9_]+)/g;
const IS_MENTION = /^@[a-zA-Z0-9_]+$/;

export function renderContent(text: string): ReactNode[] {
  return text.split(SPLIT).map((part, index) =>
    IS_MENTION.test(part) ? (
      <span key={index} className="mention">
        {part}
      </span>
    ) : (
      <span key={index}>{part}</span>
    ),
  );
}
