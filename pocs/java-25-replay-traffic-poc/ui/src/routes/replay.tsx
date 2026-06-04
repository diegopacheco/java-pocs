import { useMutation, useQuery } from '@tanstack/react-query'
import { getStats, replay } from '../lib/api'
import { Bars, StatusBadge } from '../components'

function Counter({ label, value, accent }: { label: string; value: number; accent?: string }) {
  return (
    <div className={`counter ${accent ?? ''}`}>
      <span className="counter-num">{value}</span>
      <span className="counter-label">{label}</span>
    </div>
  )
}

export default function Replay() {
  const stats = useQuery({ queryKey: ['stats'], queryFn: getStats, refetchInterval: 2000 })
  const run = useMutation({ mutationFn: replay })
  const r = run.data

  return (
    <div className="replay">
      <section className="card replay-run">
        <h2>Replay captured traffic</h2>
        <p className="muted">
          Reads <code>traffic.log</code> and re-issues each request to the backend. Only <strong>GET</strong> is
          replayed — writes (PUT and DELETE) are skipped so a replay never mutates data.
        </p>
        <div className="replay-actions">
          <button className="primary big" disabled={run.isPending} onClick={() => run.mutate()}>
            {run.isPending ? 'replaying…' : 'Replay GET traffic'}
          </button>
          <span className="muted">{stats.data?.logEntries ?? 0} entries available in the log</span>
        </div>
        {run.isError && <p className="pill fail">replay failed — is the backend up?</p>}
      </section>

      {r && (
        <>
          <section className="counters">
            <Counter label="in log" value={r.totalInLog} />
            <Counter label="replayed (GET)" value={r.replayed} accent="blue" />
            <Counter label="succeeded" value={r.succeeded} accent="green" />
            <Counter label="failed" value={r.failed} accent="red" />
            <Counter label="writes skipped" value={r.skippedWrites} accent="amber" />
          </section>
          <section className="card">
            <h4>replayed responses by status</h4>
            <Bars data={r.byStatus} kind="status" />
          </section>
          {r.failures.length > 0 && (
            <section className="card">
              <h4>failures ({r.failed})</h4>
              <ul className="failures">
                {r.failures.map((f, i) => (
                  <li key={i}>
                    <StatusBadge status={f.status} />
                    <code className="cell-path">GET {f.path}</code>
                    <span className="cell-body">{f.detail}</span>
                  </li>
                ))}
              </ul>
              {r.failed > r.failures.length && (
                <p className="muted">…and {r.failed - r.failures.length} more</p>
              )}
            </section>
          )}
        </>
      )}
    </div>
  )
}
