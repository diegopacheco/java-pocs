const BASE = import.meta.env.VITE_API_URL ?? 'http://localhost:8001'
const PROXY = import.meta.env.VITE_PROXY_URL ?? 'http://localhost:8000'

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

export interface Failure {
  path: string
  status: number | string
  detail: string
}

export interface ReplayResult {
  totalInLog: number
  skippedWrites: number
  replayed: number
  succeeded: number
  failed: number
  byStatus: Record<string, number>
  failures: Failure[]
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

function shellQuote(value: string): string {
  return `'${value.replace(/'/g, `'\\''`)}'`
}

export function toCurl(entry: Entry): string {
  const isDelete = entry.method === 'DELETE'
  const flags = isDelete ? '-iX' : '-sX'
  const parts = [`curl ${flags} ${entry.method}`, shellQuote(`${PROXY}${entry.path}`)]
  if (entry.reqBody && entry.reqBody.trim() !== '') {
    parts.push(`-H ${shellQuote('Content-Type: application/json')}`)
    parts.push(`-d ${shellQuote(entry.reqBody)}`)
  }
  const cmd = parts.join(' ')
  return isDelete ? cmd : `${cmd} | jq .`
}

export const getStats = () => jsonGet<Stats>('/api/stats')
export const getLog = (method?: string) =>
  jsonGet<LogResponse>(`/api/log${method ? `?method=${encodeURIComponent(method)}` : ''}`)
export const generate = (method: string, count: number) =>
  jsonPost<GenResult>('/api/generate', { method, count })
export const replay = () => jsonPost<ReplayResult>('/api/replay')
