import { useMemo, useState } from 'react'
import { useQuery } from '@tanstack/react-query'
import {
  createColumnHelper,
  flexRender,
  getCoreRowModel,
  useReactTable,
} from '@tanstack/react-table'
import { getLog, type Entry } from '../lib/api'
import { MethodBadge, StatusBadge } from '../components'

const FILTERS = ['ALL', 'GET', 'PUT', 'DELETE']
const col = createColumnHelper<Entry>()

const columns = [
  col.accessor('ts', { header: 'time', cell: (c) => new Date(c.getValue()).toLocaleTimeString() }),
  col.accessor('method', { header: 'method', cell: (c) => <MethodBadge method={c.getValue()} /> }),
  col.accessor('path', { header: 'path', cell: (c) => <code className="cell-path">{c.getValue()}</code> }),
  col.accessor('status', { header: 'status', cell: (c) => <StatusBadge status={c.getValue()} /> }),
  col.accessor('durationMs', { header: 'ms', cell: (c) => <span className="muted">{c.getValue()}</span> }),
  col.accessor('respBody', { header: 'response', cell: (c) => <span className="cell-body">{c.getValue()}</span> }),
]

export default function Logs() {
  const [filter, setFilter] = useState('ALL')
  const q = useQuery({
    queryKey: ['log', filter],
    queryFn: () => getLog(filter === 'ALL' ? undefined : filter),
  })

  const rows = useMemo(() => [...(q.data?.entries ?? [])].reverse().slice(0, 500), [q.data])
  const table = useReactTable({ data: rows, columns, getCoreRowModel: getCoreRowModel() })

  return (
    <div className="logs">
      <div className="logs-head">
        <div className="seg">
          {FILTERS.map((f) => (
            <button key={f} className={`seg-btn ${f === filter ? 'on' : ''}`} onClick={() => setFilter(f)}>
              {f}
            </button>
          ))}
        </div>
        <div className="logs-meta">
          <span className="muted">{q.data?.count ?? 0} entries</span>
          <button onClick={() => q.refetch()}>refresh</button>
        </div>
      </div>
      <div className="table-wrap">
        <table>
          <thead>
            {table.getHeaderGroups().map((hg) => (
              <tr key={hg.id}>
                {hg.headers.map((h) => (
                  <th key={h.id}>{flexRender(h.column.columnDef.header, h.getContext())}</th>
                ))}
              </tr>
            ))}
          </thead>
          <tbody>
            {table.getRowModel().rows.map((r) => (
              <tr key={r.id}>
                {r.getVisibleCells().map((cell) => (
                  <td key={cell.id}>{flexRender(cell.column.columnDef.cell, cell.getContext())}</td>
                ))}
              </tr>
            ))}
            {(q.data?.count ?? 0) === 0 && (
              <tr>
                <td colSpan={columns.length} className="empty">
                  no traffic captured yet — generate some on the Dashboard
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  )
}
