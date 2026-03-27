import { useState, useEffect } from 'react'
import { useQuery, useQueryClient } from '@tanstack/react-query'

interface IndexInfo {
  name: string
  docsCount: string
  storeSize: string
  health: string
  status: string
  date: string
}

interface SlidingWindow {
  retentionDays: number
  windowStart: string
  windowEnd: string
  currentIndex: string
  windowIndexes: string[]
}

interface DashboardData {
  indexes: IndexInfo[]
  slidingWindow: SlidingWindow
  totalIndexes: number
  totalDocs: number
}

interface SearchResult {
  _index: string
  _id: string
  title?: string
  content?: string
  tags?: string[]
  [key: string]: unknown
}

const BASE = 'http://localhost:8080'

function addDays(dateStr: string, days: number): string {
  const d = new Date(dateStr + 'T00:00:00')
  d.setDate(d.getDate() + days)
  return d.toISOString().slice(0, 10)
}

function todayStr(): string {
  return new Date().toISOString().slice(0, 10)
}

function JsonSyntax({ obj }: { obj: unknown }) {
  const json = JSON.stringify(obj, null, 2)
  const colored = json.replace(
    /("(?:\\.|[^"\\])*")\s*:/g,
    '<span style="color:#6366f1">$1</span>:'
  ).replace(
    /:\s*("(?:\\.|[^"\\])*")/g,
    ': <span style="color:#059669">$1</span>'
  ).replace(
    /:\s*(\d+(?:\.\d+)?)/g,
    ': <span style="color:#d97706">$1</span>'
  ).replace(
    /:\s*(true|false|null)/g,
    ': <span style="color:#e11d48">$1</span>'
  )
  return <pre style={styles.jsonPre} dangerouslySetInnerHTML={{ __html: colored }} />
}

function App() {
  const queryClient = useQueryClient()
  const [searchQuery, setSearchQuery] = useState('')
  const [searchResults, setSearchResults] = useState<SearchResult[] | null>(null)
  const [searching, setSearching] = useState(false)
  const [rotateDate, setRotateDate] = useState(addDays(todayStr(), 1))
  const [rotating, setRotating] = useState(false)
  const [rotateResult, setRotateResult] = useState<string | null>(null)
  const [modalDoc, setModalDoc] = useState<SearchResult | null>(null)
  const [searchLabel, setSearchLabel] = useState<string | null>(null)

  useEffect(() => {
    const handler = (e: KeyboardEvent) => { if (e.key === 'Escape') setModalDoc(null) }
    window.addEventListener('keydown', handler)
    return () => window.removeEventListener('keydown', handler)
  }, [])

  const { data, isLoading, error } = useQuery<DashboardData>({
    queryKey: ['dashboard'],
    queryFn: () => fetch(`${BASE}/api/dashboard`).then(r => r.json()),
  })

  const doSearch = async () => {
    if (!data) return
    const q = searchQuery.trim() || '*'
    setSearching(true)
    setSearchResults(null)
    setSearchLabel(null)
    const from = data.slidingWindow.windowStart
    const to = data.slidingWindow.windowEnd
    const res = await fetch(`${BASE}/api/search?q=${encodeURIComponent(q)}&from=${from}&to=${to}`)
    const json = await res.json()
    setSearchResults(json.results || [])
    setSearching(false)
  }

  const doSearchByIndex = async (indexName: string) => {
    if (!data) return
    setSearching(true)
    setSearchResults(null)
    setSearchLabel(indexName)
    setSearchQuery('')
    const idx = data.indexes.find(i => i.name === indexName)
    const idxDate = idx?.date || data.slidingWindow.windowEnd
    const res = await fetch(`${BASE}/api/search?q=*&from=${idxDate}&to=${idxDate}`)
    const json = await res.json()
    setSearchResults(json.results || [])
    setSearching(false)
  }

  const doRotate = async () => {
    if (!rotateDate) return
    setRotating(true)
    setRotateResult(null)
    const res = await fetch(`${BASE}/api/rotate/${rotateDate}`, { method: 'POST' })
    const json = await res.json()
    const created = json.createdIndex || '?'
    const deleted = (json.deletedIndexes || []).join(', ') || 'none'
    const migrated = (json.migratedFrom || []).join(', ') || 'none'
    const migCount = json.totalDocsMigrated || 0
    setRotateResult(`Created: ${created} | Deleted: ${deleted} | Docs fed: ${json.docsFed} | Migrated: ${migrated} (${migCount} docs)`)
    setRotating(false)
    queryClient.invalidateQueries({ queryKey: ['dashboard'] })
  }

  if (isLoading) return <div style={styles.loading}>Loading dashboard...</div>
  if (error) return <div style={styles.error}>Error: {(error as Error).message}</div>
  if (!data) return null

  const windowIndexSet = new Set(data.slidingWindow.windowIndexes)
  const today = data.slidingWindow.windowEnd
  const retention = data.slidingWindow.retentionDays

  const allDates: string[] = []
  for (let c = -(retention - 1); c <= 3; c++) allDates.push(addDays(today, c))

  const ganttRows: { rowLabel: string; isCurrent: boolean; isFuture: boolean; cells: { date: string; active: boolean; isNew: boolean; isDeleted: boolean }[] }[] = []
  for (let rowOffset = 0; rowOffset <= 3; rowOffset++) {
    const rowEnd = addDays(today, rowOffset)
    const rowStart = addDays(today, rowOffset - retention + 1)
    const deletedDate = addDays(today, rowOffset - retention)
    const isCurrent = rowOffset === 0
    const isFuture = rowOffset > 0
    const rowLabel = isCurrent ? 'NOW' : `+${rowOffset}d`
    const cells = allDates.map(date => ({
      date,
      active: date >= rowStart && date <= rowEnd,
      isNew: isFuture && date === rowEnd,
      isDeleted: isFuture && date === deletedDate,
    }))
    ganttRows.push({ rowLabel, isCurrent, isFuture, cells })
  }

  return (
    <div style={styles.container}>
      <div style={styles.headerBar}>
        <h1 style={styles.title}>Elasticsearch Index Dashboard</h1>
      </div>

      <div style={styles.statsRow}>
        <div style={styles.statCard}>
          <div style={styles.statValue}>{data.totalIndexes}</div>
          <div style={styles.statLabel}>Total Indexes</div>
        </div>
        <div style={styles.statCard}>
          <div style={styles.statValue}>{data.totalDocs}</div>
          <div style={styles.statLabel}>Total Documents</div>
        </div>
        <div style={styles.statCard}>
          <div style={styles.statValue}>{data.slidingWindow.retentionDays}</div>
          <div style={styles.statLabel}>Retention Days</div>
        </div>
      </div>

      <div style={styles.twoCol}>
        <div style={styles.colLeft}>
          <div style={styles.section}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 16 }}>
              <h2 style={{ ...styles.sectionTitle, marginBottom: 0 }}>Sliding Window</h2>
              <div style={styles.rotateRow}>
                <input type="date" value={rotateDate} onChange={e => setRotateDate(e.target.value)} style={styles.dateInput} />
                <button onClick={doRotate} disabled={rotating} style={styles.btnGreen}>
                  {rotating ? 'Rotating...' : 'Rotate'}
                </button>
              </div>
            </div>
            {rotateResult && <div style={styles.rotateResultBanner}>{rotateResult}</div>}
            <div style={styles.infoRow}>
              <span style={styles.infoLabel}>Window</span>
              <span style={styles.infoValue}>{data.slidingWindow.windowStart} to {data.slidingWindow.windowEnd}</span>
            </div>
            <div style={styles.infoRow}>
              <span style={styles.infoLabel}>Current</span>
              <span style={styles.infoValue}>{data.slidingWindow.currentIndex}</span>
            </div>

            <div style={styles.projectionContainer}>
              <div style={styles.ganttHeader}>
                <div style={styles.ganttRowLabel}></div>
                {allDates.map((d, i) => (
                  <div key={i} style={styles.ganttColHeader}>{d.slice(5)}</div>
                ))}
              </div>
              {ganttRows.map((row, ri) => (
                <div key={ri} style={{
                  ...styles.ganttRow,
                  borderLeft: row.isCurrent ? '3px solid #6366f1' : row.isFuture ? '3px dashed #a5b4fc' : '3px solid #e2e8f0',
                }}>
                  <div style={{
                    ...styles.ganttRowLabel,
                    color: row.isCurrent ? '#6366f1' : '#94a3b8',
                    fontWeight: row.isCurrent ? 700 : 400,
                  }}>{row.rowLabel}</div>
                  {row.cells.map((cell, ci) => {
                    let bg = '#f8fafc'
                    let border = '1px solid #e9ecf0'
                    let label = ''
                    if (cell.isDeleted) { bg = '#fef2f2'; border = '1px solid #fca5a5'; label = 'DEL' }
                    else if (cell.isNew) { bg = '#ecfdf5'; border = '1px solid #6ee7b7'; label = 'NEW' }
                    else if (cell.active && row.isCurrent) { bg = '#eef2ff'; border = '1px solid #a5b4fc' }
                    else if (cell.active) { bg = '#f1f5f9'; border = '1px solid #cbd5e1' }
                    return (
                      <div key={ci} style={{ ...styles.ganttCell, backgroundColor: bg, border }}>
                        {label && <span style={{ fontSize: 9, fontWeight: 700, color: cell.isDeleted ? '#ef4444' : '#10b981' }}>{label}</span>}
                        {cell.active && !label && <div style={styles.ganttBar}></div>}
                      </div>
                    )
                  })}
                </div>
              ))}
              <div style={{ display: 'flex', gap: 16, marginTop: 12, flexWrap: 'wrap' }}>
                <div style={styles.legendGroup}>
                  <span style={{ ...styles.legendDot, backgroundColor: '#818cf8' }}></span>
                  <span style={styles.legendText}>Current</span>
                </div>
                <div style={styles.legendGroup}>
                  <span style={{ ...styles.legendDot, backgroundColor: '#6ee7b7' }}></span>
                  <span style={styles.legendText}>New</span>
                </div>
                <div style={styles.legendGroup}>
                  <span style={{ ...styles.legendDot, backgroundColor: '#fca5a5' }}></span>
                  <span style={styles.legendText}>Delete</span>
                </div>
                <div style={styles.legendGroup}>
                  <span style={{ ...styles.legendDot, backgroundColor: '#cbd5e1' }}></span>
                  <span style={styles.legendText}>Future</span>
                </div>
              </div>
            </div>
          </div>

          <div style={styles.section}>
            <h2 style={styles.sectionTitle}>Indexes</h2>
            <table style={styles.table}>
              <thead>
                <tr>
                  <th style={styles.th}>Name</th>
                  <th style={styles.th}>Docs</th>
                  <th style={styles.th}>Size</th>
                  <th style={styles.th}>Health</th>
                  <th style={styles.th}>Window</th>
                </tr>
              </thead>
              <tbody>
                {data.indexes.map((idx, i) => (
                  <tr key={i} style={i % 2 === 0 ? styles.trEven : styles.trOdd}>
                    <td style={styles.td}>
                      <span
                        style={styles.indexLink}
                        onClick={() => doSearchByIndex(idx.name)}
                      >{idx.name}</span>
                    </td>
                    <td style={{ ...styles.td, textAlign: 'right' }}>{idx.docsCount}</td>
                    <td style={{ ...styles.td, textAlign: 'right' }}>{idx.storeSize}</td>
                    <td style={styles.td}>
                      <span style={{
                        ...styles.healthBadge,
                        backgroundColor: idx.health === 'green' ? '#ecfdf5' : idx.health === 'yellow' ? '#fefce8' : '#fef2f2',
                        color: idx.health === 'green' ? '#059669' : idx.health === 'yellow' ? '#ca8a04' : '#dc2626',
                        border: idx.health === 'green' ? '1px solid #a7f3d0' : idx.health === 'yellow' ? '1px solid #fde68a' : '1px solid #fecaca',
                      }}>{idx.health}</span>
                    </td>
                    <td style={{ ...styles.td, textAlign: 'center' }}>
                      {windowIndexSet.has(idx.name)
                        ? <span style={{ ...styles.pillBadge, backgroundColor: '#eef2ff', color: '#6366f1', border: '1px solid #c7d2fe' }}>YES</span>
                        : <span style={{ ...styles.pillBadge, backgroundColor: '#f1f5f9', color: '#94a3b8', border: '1px solid #e2e8f0' }}>NO</span>}
                    </td>
                  </tr>
                ))}
                {data.indexes.length === 0 && (
                  <tr><td colSpan={5} style={{ ...styles.td, textAlign: 'center', color: '#94a3b8' }}>No indexes</td></tr>
                )}
              </tbody>
            </table>
          </div>
        </div>

        <div style={styles.colRight}>
          <div style={styles.section}>
            <h2 style={styles.sectionTitle}>Search</h2>
            <div style={styles.searchRow}>
              <input
                type="text"
                value={searchQuery}
                onChange={e => setSearchQuery(e.target.value)}
                onKeyDown={e => e.key === 'Enter' && doSearch()}
                placeholder="Search indexes..."
                style={styles.searchInput}
              />
              <button onClick={doSearch} disabled={searching} style={styles.btnBlue}>
                {searching ? '...' : 'Search'}
              </button>
            </div>
            {searchLabel && (
              <div style={styles.indexFilterBanner}>
                Showing all docs from: <strong>{searchLabel}</strong>
                <span style={styles.clearFilter} onClick={() => { setSearchLabel(null); setSearchResults(null) }}>clear</span>
              </div>
            )}
            {searchResults !== null && (
              <div style={{ marginTop: 12 }}>
                <div style={{ color: '#64748b', fontSize: 13, marginBottom: 8 }}>
                  {searchResults.length} result{searchResults.length !== 1 ? 's' : ''}
                </div>
                <div style={styles.searchResultsScroll}>
                {searchResults.map((r, i) => (
                  <div
                    key={i}
                    style={styles.searchResultCard}
                    onClick={() => setModalDoc(r)}
                    onMouseEnter={e => { (e.currentTarget as HTMLDivElement).style.borderColor = '#818cf8'; (e.currentTarget as HTMLDivElement).style.boxShadow = '0 2px 8px rgba(99,102,241,0.12)'; (e.currentTarget as HTMLDivElement).style.cursor = 'pointer' }}
                    onMouseLeave={e => { (e.currentTarget as HTMLDivElement).style.borderColor = '#e2e8f0'; (e.currentTarget as HTMLDivElement).style.boxShadow = 'none' }}
                  >
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                      <span style={{ fontWeight: 600, color: '#1e293b' }}>{r.title || 'Untitled'}</span>
                      <span style={{ ...styles.pillBadge, backgroundColor: '#eef2ff', color: '#6366f1', border: '1px solid #c7d2fe', fontSize: 10 }}>{r._index}</span>
                    </div>
                    <div style={{ color: '#64748b', fontSize: 13, marginTop: 6 }}>{r.content || ''}</div>
                    {r.tags && r.tags.length > 0 && (
                      <div style={{ marginTop: 6, display: 'flex', gap: 4, flexWrap: 'wrap' }}>
                        {r.tags.map((t, j) => (
                          <span key={j} style={{ ...styles.pillBadge, backgroundColor: '#f1f5f9', color: '#64748b', border: '1px solid #e2e8f0', fontSize: 10 }}>{t}</span>
                        ))}
                      </div>
                    )}
                    <div style={{ color: '#a1a1aa', fontSize: 11, marginTop: 8 }}>Click to view full document</div>
                  </div>
                ))}
                </div>
              </div>
            )}
          </div>
        </div>
      </div>

      {modalDoc && (
        <div style={styles.modalOverlay} onClick={() => setModalDoc(null)}>
          <div style={styles.modalContent} onClick={e => e.stopPropagation()}>
            <div style={styles.modalHeader}>
              <h3 style={{ margin: 0, color: '#1e293b', fontSize: 16, fontWeight: 600 }}>{modalDoc.title || 'Document'}</h3>
              <button onClick={() => setModalDoc(null)} style={styles.modalClose}>X</button>
            </div>
            <div style={styles.modalBody}>
              <JsonSyntax obj={modalDoc} />
            </div>
          </div>
        </div>
      )}

      <div style={styles.footer}>Auto-refreshes every 5 seconds</div>
    </div>
  )
}

const styles: Record<string, React.CSSProperties> = {
  container: {
    fontFamily: '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Inter", sans-serif',
    maxWidth: 1400,
    margin: '0 auto',
    padding: '24px 28px',
    backgroundColor: '#f0f2f5',
    minHeight: '100vh',
    color: '#334155',
  },
  headerBar: {
    marginBottom: 24,
  },
  title: {
    fontSize: 26,
    fontWeight: 700,
    color: '#1e293b',
    borderBottom: '3px solid #6366f1',
    paddingBottom: 12,
    letterSpacing: -0.5,
  },
  loading: { padding: 40, textAlign: 'center', color: '#64748b', fontSize: 18 },
  error: { padding: 40, textAlign: 'center', color: '#dc2626', fontSize: 18 },
  statsRow: { display: 'flex', gap: 16, marginBottom: 24 },
  statCard: {
    flex: 1,
    backgroundColor: '#ffffff',
    borderRadius: 12,
    padding: '22px 20px',
    textAlign: 'center',
    border: '1px solid #e5e7eb',
    boxShadow: '0 1px 3px rgba(0,0,0,0.04), 0 1px 2px rgba(0,0,0,0.02)',
  },
  statValue: { fontSize: 34, fontWeight: 700, color: '#6366f1', letterSpacing: -1 },
  statLabel: { fontSize: 13, color: '#94a3b8', marginTop: 4, fontWeight: 500, textTransform: 'uppercase' as const, letterSpacing: 0.5 },
  twoCol: { display: 'flex', gap: 24, alignItems: 'flex-start' },
  colLeft: { flex: 1, minWidth: 0 },
  colRight: { flex: 1, minWidth: 0 },
  section: {
    backgroundColor: '#ffffff',
    borderRadius: 12,
    padding: 22,
    marginBottom: 20,
    border: '1px solid #e5e7eb',
    boxShadow: '0 1px 3px rgba(0,0,0,0.04), 0 1px 2px rgba(0,0,0,0.02)',
  },
  sectionTitle: { fontSize: 18, fontWeight: 600, marginBottom: 16, color: '#1e293b', letterSpacing: -0.3 },
  searchRow: { display: 'flex', gap: 8 },
  searchInput: {
    flex: 1,
    padding: '10px 14px',
    borderRadius: 8,
    border: '1px solid #d1d5db',
    backgroundColor: '#fafafa',
    color: '#334155',
    fontSize: 14,
    outline: 'none',
    transition: 'border-color 0.15s',
  },
  searchResultsScroll: {
    maxHeight: 500,
    overflowY: 'auto' as const,
  },
  searchResultCard: {
    backgroundColor: '#fafafa',
    border: '1px solid #e2e8f0',
    borderRadius: 10,
    padding: 14,
    marginBottom: 8,
    transition: 'border-color 0.15s, box-shadow 0.15s',
  },
  btnBlue: {
    padding: '10px 22px',
    borderRadius: 8,
    border: 'none',
    backgroundColor: '#6366f1',
    color: '#fff',
    fontWeight: 600,
    fontSize: 14,
    cursor: 'pointer',
    transition: 'background-color 0.15s',
  },
  btnGreen: {
    padding: '8px 18px',
    borderRadius: 8,
    border: 'none',
    backgroundColor: '#10b981',
    color: '#fff',
    fontWeight: 600,
    fontSize: 14,
    cursor: 'pointer',
    transition: 'background-color 0.15s',
  },
  rotateRow: { display: 'flex', gap: 8, alignItems: 'center' },
  dateInput: {
    padding: '8px 12px',
    borderRadius: 8,
    border: '1px solid #d1d5db',
    backgroundColor: '#fafafa',
    color: '#334155',
    fontSize: 14,
    outline: 'none',
  },
  rotateResultBanner: {
    backgroundColor: '#f0fdf4',
    border: '1px solid #86efac',
    borderRadius: 8,
    padding: '10px 14px',
    marginBottom: 12,
    fontSize: 13,
    color: '#166534',
  },
  infoRow: { display: 'flex', alignItems: 'center', gap: 8, marginBottom: 6 },
  infoLabel: {
    fontSize: 12,
    fontWeight: 600,
    color: '#94a3b8',
    textTransform: 'uppercase' as const,
    letterSpacing: 0.5,
    minWidth: 60,
  },
  infoValue: { color: '#334155', fontWeight: 500, fontSize: 14 },
  projectionContainer: { marginTop: 16 },
  ganttHeader: { display: 'flex', gap: 4, marginBottom: 4 },
  ganttColHeader: {
    flex: 1,
    textAlign: 'center',
    fontSize: 11,
    color: '#94a3b8',
    fontWeight: 600,
    padding: '4px 0',
  },
  ganttRow: { display: 'flex', gap: 4, marginBottom: 4, alignItems: 'center' },
  ganttRowLabel: {
    width: 44,
    minWidth: 44,
    fontSize: 12,
    fontWeight: 600,
    textAlign: 'center',
    color: '#94a3b8',
  },
  ganttCell: {
    flex: 1,
    height: 34,
    borderRadius: 6,
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  },
  ganttBar: {
    width: '75%',
    height: 8,
    borderRadius: 4,
    backgroundColor: '#818cf8',
  },
  legendGroup: { display: 'flex', alignItems: 'center', gap: 5 },
  legendDot: {
    display: 'inline-block',
    width: 10,
    height: 10,
    borderRadius: '50%',
  },
  legendText: { color: '#64748b', fontSize: 12 },
  table: { width: '100%', borderCollapse: 'collapse' as const },
  th: {
    textAlign: 'left',
    padding: '10px 12px',
    borderBottom: '2px solid #e5e7eb',
    color: '#94a3b8',
    fontSize: 11,
    fontWeight: 600,
    textTransform: 'uppercase' as const,
    letterSpacing: 0.5,
  },
  td: { padding: '10px 12px', borderBottom: '1px solid #f1f5f9', fontSize: 14, color: '#334155' },
  trEven: { backgroundColor: 'transparent' },
  trOdd: { backgroundColor: '#fafbfc' },
  healthBadge: {
    display: 'inline-block',
    padding: '2px 10px',
    borderRadius: 20,
    fontSize: 12,
    fontWeight: 600,
  },
  pillBadge: {
    display: 'inline-block',
    padding: '2px 10px',
    borderRadius: 20,
    fontSize: 12,
    fontWeight: 600,
  },
  indexLink: {
    color: '#6366f1',
    cursor: 'pointer',
    fontWeight: 500,
    transition: 'color 0.15s',
    borderBottom: '1px dashed #c7d2fe',
    paddingBottom: 1,
  },
  indexFilterBanner: {
    marginTop: 10,
    padding: '8px 14px',
    backgroundColor: '#eef2ff',
    border: '1px solid #c7d2fe',
    borderRadius: 8,
    fontSize: 13,
    color: '#4338ca',
  },
  clearFilter: {
    marginLeft: 12,
    color: '#6366f1',
    cursor: 'pointer',
    textDecoration: 'underline',
    fontSize: 12,
    fontWeight: 500,
  },
  modalOverlay: {
    position: 'fixed',
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
    backgroundColor: 'rgba(15,23,42,0.4)',
    backdropFilter: 'blur(4px)',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    zIndex: 1000,
  },
  modalContent: {
    backgroundColor: '#ffffff',
    border: '1px solid #e5e7eb',
    borderRadius: 16,
    width: '80vw',
    maxWidth: 900,
    maxHeight: '85vh',
    display: 'flex',
    flexDirection: 'column',
    boxShadow: '0 25px 50px -12px rgba(0,0,0,0.15)',
  },
  modalHeader: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '16px 22px',
    borderBottom: '1px solid #e5e7eb',
  },
  modalClose: {
    background: 'none',
    border: '1px solid #d1d5db',
    borderRadius: 8,
    color: '#64748b',
    fontSize: 14,
    fontWeight: 700,
    padding: '4px 10px',
    cursor: 'pointer',
    transition: 'background-color 0.15s',
  },
  modalBody: {
    padding: 22,
    overflowY: 'auto' as const,
    flex: 1,
  },
  jsonPre: {
    backgroundColor: '#f8fafc',
    border: '1px solid #e5e7eb',
    borderRadius: 10,
    padding: 18,
    margin: 0,
    fontSize: 13,
    lineHeight: 1.7,
    color: '#334155',
    overflowX: 'auto' as const,
    fontFamily: '"SF Mono", "Fira Code", "JetBrains Mono", "Cascadia Code", monospace',
  },
  footer: {
    textAlign: 'center',
    color: '#94a3b8',
    fontSize: 12,
    marginTop: 12,
  },
}

export default App
