const COLORS = ["#7C6AED", "#E8888B", "#3FB68B", "#F5A65B", "#5BA8F5", "#C77DD6", "#E0A458", "#4ECDC4"];

function initials(name: string): string {
  return name
    .split(/\s+/)
    .map((part) => part[0])
    .filter(Boolean)
    .slice(0, 2)
    .join("")
    .toUpperCase();
}

interface AvatarProps {
  user: { id: number; displayName: string; avatarUrl?: string | null };
  size?: number;
}

export function Avatar({ user, size = 36 }: AvatarProps) {
  const color = COLORS[user.id % COLORS.length];
  if (user.avatarUrl) {
    return (
      <img
        className="avatar"
        src={user.avatarUrl}
        alt={user.displayName}
        style={{ width: size, height: size }}
      />
    );
  }
  return (
    <div
      className="avatar avatar-initials"
      style={{ width: size, height: size, background: color, fontSize: size * 0.4 }}
    >
      {initials(user.displayName)}
    </div>
  );
}
