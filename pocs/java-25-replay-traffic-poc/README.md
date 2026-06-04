# Traffic Record & Replay

Capture real HTTP traffic at a proxy, write it to a flat log, then replay the
read-only part of it against the service. A small book store API stands in for
"production", a Java proxy records everything that passes through, and a React
UI drives and visualizes it.

## Components

- **traffic-proxy** — plain Java 25, no frameworks. Sits in front of the book
  store on `:8000`, forwards every request, and appends each request/response
  pair to `traffic.log`. A second port `:8001` serves a small control API
  (stats, log, generate, replay) for the UI.
- **bookstore-service** — Spring Boot 4.0.6 on Java 25. REST over `GET`, `PUT`,
  `DELETE`. Persistence is Spring Data JDBC (no Hibernate) on MySQL through a
  HikariCP pool. `PUT /books/{id}` is an upsert: it inserts when the id is new,
  updates when it already exists.
- **ui** — Bun + Vite + React 19, wired with TanStack Router, Query and Table.

## The three tabs

- **Dashboard** — live counters for traffic seen at the proxy and at the
  backend, broken down by method and status. A button generates real traffic;
  pick `GET`, `PUT` or `DELETE` and a count.
- **Traffic Log** — the contents of `traffic.log` in a table, filterable by
  `GET` / `PUT` / `DELETE`.
- **Replay** — replays the captured log against the backend. Only `GET` is
  replayed; `PUT` and `DELETE` are skipped so replaying never changes data.
  Shows counters and a status breakdown of the replayed responses.

## Requirements

- Java 25, Bun, podman + podman-compose (MySQL runs in a container).
- The Maven wrapper (`mvnw`) is bundled, so no system Maven is needed.

## Run

```
./start.sh    # MySQL, both Java services, and the UI dev server
./test.sh     # generates traffic, prints stats, then replays
./stop.sh     # stops everything and tears down MySQL
```

Then open http://localhost:5173.

## Ports

| What            | Port |
|-----------------|------|
| UI (Vite)       | 5173 |
| Proxy           | 8000 |
| Control API     | 8001 |
| Book store      | 8080 |
| MySQL           | 3309 |

## How it flows

```
UI ──generate──▶ control API ──▶ proxy :8000 ──▶ book store :8080 ──▶ MySQL
                                   │
                                   └─ appends every call to traffic.log
UI ──replay──▶ control API ──reads traffic.log, GET only──▶ book store :8080
```

The proxy is in the request path and records both directions; the backend never
knows it is there. Replay reads the same file back and only re-issues the safe
verb.

## Config

Everything is read from the environment with working defaults — nothing is
hard-coded into the binaries:

- proxy: `PROXY_PORT`, `CONTROL_PORT`, `BACKEND_URL`, `TRAFFIC_LOG`, `MAX_BODY`
- book store: `SERVER_PORT`, `DB_URL`, `DB_USER`, `DB_PASS`
- ui: `VITE_API_URL` (defaults to `http://localhost:8001`)

## Layout

```
bookstore-service/   Spring Boot 4 + Spring Data JDBC + MySQL
traffic-proxy/       JDK-only recording proxy + control API
ui/                  React 19 + TanStack dashboard
infra/compose.yaml   MySQL 9
start.sh stop.sh test.sh
```
