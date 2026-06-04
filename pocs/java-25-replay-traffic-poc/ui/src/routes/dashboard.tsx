import { useState } from 'react'
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query'
import { generate, getStats } from '../lib/api'
import { Bars } from '../components'

const METHODS = ['GET', 'PUT', 'DELETE']

export default function Dashboard() {
  const qc = useQueryClient()
  const stats = useQuery({ queryKey: ['stats'], queryFn: getStats, refetchInterval: 1500 })
  const [method, setMethod] = useState('GET')
  const [count, setCount] = useState(20)
  const gen = useMutation({
    mutationFn: () => generate(method, count),
    onSuccess: () => qc.invalidateQueries({ queryKey: ['stats'] }),
  })

  const s = stats.data

  return (
    <div className="grid">
      <section className="card generator">
        <h2>Generate traffic</h2>
        <p className="muted">Fires real requests through the proxy into the book store service.</p>
        <div className="controls">
          <div className="seg">
            {METHODS.map((m) => (
              <button key={m} className={`seg-btn ${m === method ? 'on' : ''}`} onClick={() => setMethod(m)}>
                {m}
              </button>
            ))}
          </div>
          <input
            type="number"
            min={1}
            max={500}
            value={count}
            onChange={(e) => setCount(Math.max(1, Number(e.target.value)))}
          />
          <button className="primary" disabled={gen.isPending} onClick={() => gen.mutate()}>
            {gen.isPending ? 'sending…' : `Send ${count} ${method}`}
          </button>
        </div>
        {gen.data && (
          <div className="gen-result">
            <span className="pill ok">{gen.data.ok} ok</span>
            <span className="pill fail">{gen.data.failed} failed</span>
            <span className="muted">
              {Object.entries(gen.data.byStatus)
                .map(([k, v]) => `${k}: ${v}`)
                .join('   ')}
            </span>
          </div>
        )}
      </section>

      <section className="card panel">
        <div className="panel-head">
          <h2>Proxy</h2>
          <span className="total">{s?.proxy.total ?? 0}</span>
        </div>
        <p className="muted">requests captured at the proxy (:8000)</p>
        <h4>by method</h4>
        <Bars data={s?.proxy.byMethod ?? {}} kind="method" />
        <h4>by status</h4>
        <Bars data={s?.proxy.byStatus ?? {}} kind="status" />
      </section>

      <section className="card panel">
        <div className="panel-head">
          <h2>Backend</h2>
          <span className="total">{s?.backend.total ?? 0}</span>
        </div>
        <p className="muted">responses from the book store (:8080)</p>
        <h4>by method</h4>
        <Bars data={s?.backend.byMethod ?? {}} kind="method" />
        <h4>by status</h4>
        <Bars data={s?.backend.byStatus ?? {}} kind="status" />
      </section>

      <section className="card meta">
        <div className="meta-stat">
          <span className="meta-num">{s?.logEntries ?? 0}</span>
          <span className="muted">entries in traffic.log</span>
        </div>
        <code className="path">{s?.logPath ?? '—'}</code>
      </section>
    </div>
  )
}
