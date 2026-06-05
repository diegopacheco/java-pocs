import type { ReactNode } from "react";

interface EmptyStateProps {
  icon?: string;
  title: string;
  subtitle?: string;
  children?: ReactNode;
}

export function EmptyState({ icon = "💬", title, subtitle, children }: EmptyStateProps) {
  return (
    <div className="empty-state">
      <div className="empty-icon">{icon}</div>
      <h3 className="empty-title">{title}</h3>
      {subtitle ? <p className="empty-subtitle">{subtitle}</p> : null}
      {children}
    </div>
  );
}
