import { useEffect, useMemo, useRef } from "react";
import { Spinner } from "../../components/Spinner";
import { EmptyState } from "../../components/EmptyState";
import { MessageItem } from "./MessageItem";
import { useMessages } from "./useMessages";
import { minutesBetween } from "../../lib/time";

export function MessageList({ channelId }: { channelId: number }) {
  const query = useMessages(channelId);
  const scrollRef = useRef<HTMLDivElement>(null);

  const messages = useMemo(() => {
    const pages = query.data?.pages ?? [];
    return pages.flat().slice().reverse();
  }, [query.data]);

  const lastId = messages.length > 0 ? messages[messages.length - 1].id : 0;

  useEffect(() => {
    const element = scrollRef.current;
    if (element) {
      element.scrollTop = element.scrollHeight;
    }
  }, [lastId]);

  if (query.isLoading) {
    return (
      <div className="message-scroll">
        <Spinner label="Loading messages" />
      </div>
    );
  }

  return (
    <div className="message-scroll" ref={scrollRef}>
      {query.hasNextPage ? (
        <button
          className="load-older"
          onClick={() => query.fetchNextPage()}
          disabled={query.isFetchingNextPage}
        >
          {query.isFetchingNextPage ? "Loading…" : "Load older messages"}
        </button>
      ) : messages.length > 0 ? (
        <div className="history-start">This is the very beginning.</div>
      ) : null}

      {messages.length === 0 ? (
        <EmptyState icon="✨" title="No messages yet" subtitle="Say hello and start the conversation." />
      ) : null}

      {messages.map((message, index) => {
        const previous = messages[index - 1];
        const showHeader =
          !previous ||
          previous.author.id !== message.author.id ||
          minutesBetween(previous.createdAt, message.createdAt) > 5;
        return <MessageItem key={message.id} message={message} showHeader={showHeader} />;
      })}
    </div>
  );
}
