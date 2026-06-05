const PATTERNS = [
  /youtu\.be\/([\w-]{11})/,
  /[?&]v=([\w-]{11})/,
  /youtube\.com\/embed\/([\w-]{11})/,
  /youtube\.com\/shorts\/([\w-]{11})/,
];

export function youtubeId(value: string): string | null {
  const trimmed = value.trim();
  if (/^[\w-]{11}$/.test(trimmed)) {
    return trimmed;
  }
  for (const pattern of PATTERNS) {
    const match = trimmed.match(pattern);
    if (match) {
      return match[1];
    }
  }
  return null;
}

export function isYoutubeUrl(value: string): boolean {
  return /youtu\.?be/.test(value) && youtubeId(value) !== null;
}
