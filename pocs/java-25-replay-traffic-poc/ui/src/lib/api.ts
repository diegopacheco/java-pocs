const BASE = import.meta.env.VITE_API_URL ?? 'http://localhost:8001'

export interface Side {
  total: number
  byMethod: Record<string, number>
  byStatus: Record<string, number>
}

export interface Stats {
  proxy: Side
  backend: Side
  logEntries: number
  logPath: string
}

export interface Entry {
  ts: string
  method: string
  path: string
  status: number
  durationMs: number
  reqBody: string
  respBody: string
}

export interface LogResponse {
  count: number
  entries: Entry[]
}

export interface GenResult {
  method: string
  requested: number
  ok: number
  failed: number
  byStatus: Record<string, number>
}

export interface ReplayResult {
  totalInLog: number
  skippedWrites: number
  replayed: number
  succeeded: number
  failed: number
  byStatus: Record<string, number>
}

async function jsonGet<T>(path: string): Promise<T> {
  const res = await fetch(`${BASE}${path}`)
  if (!res.ok) {
    throw new Error(`GET ${path} -> ${res.status}`)
  }
  return res.json() as Promise<T>
}

async function jsonPost<T>(path: string, body?: unknown): Promise<T> {
  const res = await fetch(`${BASE}${path}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: body ? JSON.stringify(body) : undefined,
  })
  if (!res.ok) {
    throw new Error(`POST ${path} -> ${res.status}`)
  }
  return res.json() as Promise<T>
}

export const getStats = () => jsonGet<Stats>('/api/stats')
export const getLog = (method?: string) =>
  jsonGet<LogResponse>(`/api/log${method ? `?method=${encodeURIComponent(method)}` : ''}`)
export const generate = (method: string, count: number) =>
  jsonPost<GenResult>('/api/generate', { method, count })
export const replay = () => jsonPost<ReplayResult>('/api/replay')
