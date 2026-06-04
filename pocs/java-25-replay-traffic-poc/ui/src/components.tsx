export function MethodBadge({ method }: { method: string }) {
  return <span className={`badge method ${method.toLowerCase()}`}>{method}</span>
}

export function StatusBadge({ status }: { status: number | string }) {
  const n = Number(status)
  const cls = Number.isNaN(n)
    ? 'err'
    : n < 300
      ? 'ok'
      : n < 400
        ? 'redirect'
        : n < 500
          ? 'warn'
          : 'err'
  return <span className={`badge status ${cls}`}>{status}</span>
}

export function Bars({ data, kind }: { data: Record<string, number>; kind: 'method' | 'status' }) {
  const entries = Object.entries(data).sort((a, b) => a[0].localeCompare(b[0]))
  const max = Math.max(1, ...entries.map(([, v]) => v))
  if (entries.length === 0) {
    return <span className="muted">no traffic yet</span>
  }
  return (
    <div className="bars">
      {entries.map(([key, value]) => (
        <div className="bar-row" key={key}>
          <span className={`bar-label ${kind} ${key.toLowerCase()}`}>{key}</span>
          <div className="bar-track">
            <div className={`bar-fill ${kind} ${key.toLowerCase()}`} style={{ width: `${(value / max) * 100}%` }} />
          </div>
          <span className="bar-value">{value}</span>
        </div>
      ))}
    </div>
  )
}
