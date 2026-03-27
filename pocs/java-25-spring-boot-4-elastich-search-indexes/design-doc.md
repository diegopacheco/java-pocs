# Design Doc: Java 25 + Spring Boot 4 + Elasticsearch Sliding Window Indexes

## Overview

A Spring Boot 4.0.4 application running on Java 25 that manages Elasticsearch indexes using a sliding window algorithm. Each day gets its own index following the pattern `index_YYYY_MM_DD`. A configurable retention window (default 3 days) controls how long indexes live before being deleted. Includes a React dashboard for real-time monitoring, search, and manual window rotation with data migration.

## Architecture

```
┌──────────────────────────────────────────────────────────────┐
│                     React Dashboard (:5173)                   │
│                                                               │
│  ┌─────────────────────────┐  ┌────────────────────────────┐ │
│  │  LEFT COLUMN             │  │  RIGHT COLUMN              │ │
│  │                          │  │                             │ │
│  │  Sliding Window Gantt    │  │  Search (wildcard)          │ │
│  │  Rotate (date + migrate) │  │  Results (scrollable)       │ │
│  │  Indexes Table (click)   │  │  Index filter banner        │ │
│  └─────────────────────────┘  │  Document Modal (JSON)      │ │
│                                └────────────────────────────┘ │
└───────────────────────────┬──────────────────────────────────┘
                            │
┌───────────────────────────▼──────────────────────────────────┐
│                   Spring Boot 4 App (:8080)                   │
│                                                               │
│  ┌──────────────────┐    ┌─────────────────────────────────┐ │
│  │  Controllers       │───▶│       Services                  │ │
│  │                    │    │                                 │ │
│  │  IndexCtrl         │    │  IndexService                   │ │
│  │  SearchCtrl        │    │   - getCurrentIndex()           │ │
│  │  DashboardCtrl     │    │   - createIndex(date)           │ │
│  │  RotateCtrl        │    │   - deleteIndex(date)           │ │
│  │                    │    │   - getIndexesForRange()        │ │
│  │                    │    │   - getExistingIndexes()        │ │
│  │                    │    │   - indexExists(name)           │ │
│  │                    │    │   - applyRetentionPolicy()      │ │
│  │                    │    │                                 │ │
│  │                    │    │  SearchService                   │ │
│  │                    │    │   - search(query,from,to)       │ │
│  │                    │    │   - searchCurrentIndex(query)   │ │
│  │                    │    │   - searchByIndex(indexName)    │ │
│  │                    │    │                                 │ │
│  │                    │    │  DashboardService                │ │
│  │                    │    │   - getDashboardData()          │ │
│  │                    │    │                                 │ │
│  │                    │    │  RotateService                   │ │
│  │                    │    │   - rotate(targetDate)          │ │
│  │                    │    │                                 │ │
│  │                    │    │  WindowState                     │ │
│  │                    │    │   - getWindowEnd()              │ │
│  │                    │    │   - setWindowEnd(date)          │ │
│  └──────────────────┘    └─────────────────────────────────┘ │
│                                   │                           │
└───────────────────────────────────│───────────────────────────┘
                                    │
                         ┌──────────▼──────────┐
                         │  Elasticsearch 9     │
                         │  (podman container)  │
                         │                      │
                         │  index_2026_03_24    │
                         │  index_2026_03_25    │
                         │  index_2026_03_26    │
                         └─────────────────────┘
```

## Index Naming Pattern

```
index_YYYY_MM_DD
```

- `index_2026_03_24`
- `index_2026_03_25`
- `index_2026_03_26`

## Sliding Window Algorithm

- **Window Size**: Configurable via `app.index.retention-days` (default: 3)
- **Creation**: On application startup and on schedule, ensure today's index exists
- **Deletion**: Indexes older than the retention window are deleted
- **Idempotent**: Creating an index that already exists is a safe no-op
- **Data Migration**: On rotation, documents from expired indexes are reindexed into the new index before deletion
- **State Persistence**: `WindowState` tracks the current window end date in-memory via `AtomicReference<LocalDate>`. On startup, `WindowStateInitializer` scans existing indexes and restores the latest date so window state survives page refreshes.

### Flow

```
Day 1 (Mar 24): [index_2026_03_24]
Day 2 (Mar 25): [index_2026_03_24, index_2026_03_25]
Day 3 (Mar 26): [index_2026_03_24, index_2026_03_25, index_2026_03_26]
Day 4 (Mar 27): [index_2026_03_25, index_2026_03_26, index_2026_03_27]  ← index_2026_03_24 migrated + deleted
```

### Rotation Rules

When the user triggers a rotation to a target date:

1. **Create** all indexes in the new window (from windowStart to targetDate), not just the target date. Idempotent.
2. **Feed** 3 sample documents into each window index
3. **Identify** all indexes older than the retention window (cutoff = target date - retention days)
4. **Refresh** each expired index before migration
5. **Migrate** documents from each expired index into the latest window index using ES `_reindex` API
6. **Delete** the expired indexes after successful migration
7. **Refresh** all indexes to make changes visible
8. **Update** `WindowState` with the new window end date
9. **Return** summary: created indexes, migrated indexes with doc counts, deleted indexes, docs fed

### Gantt-style Visualization

The sliding window is displayed as a Gantt chart with stacked rows:

```
         03-24   03-25   03-26   03-27   03-28   03-29
 NOW   [ ████ ] [ ████ ] [ ████ ]
 +1d   [  DEL ]  [ ████ ] [ ████ ] [ NEW  ]
 +2d             [  DEL ]  [ ████ ] [ ████ ] [ NEW  ]
 +3d                       [  DEL ]  [ ████ ] [ ████ ] [ NEW  ]
```

- Indigo bars = active window indexes
- Green `NEW` = index to be created
- Red `DEL` = index to be deleted (data migrated first)

## Package Structure

```
com.github.diegopacheco.es
├── config/
│   ├── ElasticsearchConfig.java
│   ├── CorsConfig.java
│   └── WindowStateInitializer.java
├── controller/
│   ├── IndexController.java
│   ├── SearchController.java
│   ├── DashboardController.java
│   └── RotateController.java
├── es/
│   ├── IndexService.java
│   ├── SearchService.java
│   ├── DashboardService.java
│   ├── RotateService.java
│   └── WindowState.java
├── model/
│   └── Document.java
└── Application.java
```

## Components

### es/WindowState.java

Thread-safe holder for the current sliding window end date. Uses `AtomicReference<LocalDate>` to support concurrent access. Defaults to `LocalDate.now()` on startup.

| Method | Description |
|--------|-------------|
| `LocalDate getWindowEnd()` | Returns the current window end date |
| `void setWindowEnd(LocalDate date)` | Sets the window end date |

### config/WindowStateInitializer.java

`ApplicationRunner` that runs on startup. Scans all existing indexes matching the prefix, parses dates, and sets `WindowState` to the latest index date found. Ensures window state is restored after app restart.

### es/IndexService.java

| Method | Description |
|--------|-------------|
| `String getCurrentIndex()` | Returns today's index name: `index_YYYY_MM_DD` |
| `String getIndexName(LocalDate date)` | Converts a date to index name |
| `boolean createIndex(LocalDate date)` | Creates index for a given date. Idempotent (catches resource_already_exists). |
| `boolean deleteIndex(LocalDate date)` | Deletes index for a given date. Safe (catches index_not_found). |
| `boolean indexExists(String name)` | Checks if an index exists using cat indices API. |
| `List<String> getIndexesForRange(LocalDate from, LocalDate to)` | Returns all index names in the date range. |
| `Set<String> getExistingIndexes()` | Returns all existing indexes matching the prefix pattern. |
| `void applyRetentionPolicy()` | Deletes indexes older than retention window. |

### es/SearchService.java

Uses `wildcard` queries with `bool/should` across title, content, and tags fields. Supports single-character and partial-word searches (e.g., "a" matches all docs containing "a").

| Method | Description |
|--------|-------------|
| `List<Map> search(String query, LocalDate from, LocalDate to)` | Searches across multiple indexes in date range using wildcard. |
| `List<Map> searchCurrentIndex(String query)` | Searches only today's index using wildcard. |
| `List<Map> searchByIndex(String indexName)` | Searches all documents in a specific index. Refreshes the index first, then uses wildcard `*` query. |

### es/DashboardService.java

Reads window boundaries from `WindowState` (not `LocalDate.now()`), so the dashboard reflects the last rotation state even after page refresh.

| Method | Description |
|--------|-------------|
| `Map<String,Object> getDashboardData()` | Returns indexes (name, docs, size, health, date), sliding window info (from WindowState), totals. |

### controller/IndexController.java

| Endpoint | Method | Description |
|----------|--------|-------------|
| `GET /api/index/current` | GET | Returns current index name |
| `POST /api/index/{date}` | POST | Creates index for date |
| `DELETE /api/index/{date}` | DELETE | Deletes index for date |
| `GET /api/index/range?from=&to=` | GET | Returns indexes in range |
| `POST /api/index/retention` | POST | Triggers retention cleanup |

### controller/SearchController.java

| Endpoint | Method | Description |
|----------|--------|-------------|
| `GET /api/search?q=&from=&to=` | GET | Wildcard search across date range |
| `GET /api/search/by-index?name=` | GET | Returns all documents from a specific index |
| `GET /api/search/today?q=` | GET | Wildcard search today's index |

### controller/DashboardController.java

| Endpoint | Method | Description |
|----------|--------|-------------|
| `GET /api/dashboard` | GET | Returns all dashboard data |

### es/RotateService.java

Handles all rotation logic: finding expired indexes, creating window indexes, feeding documents, migrating data, and deleting expired indexes.

| Method | Description |
|--------|-------------|
| `Map<String,Object> rotate(LocalDate targetDate)` | Full rotation: create window indexes, feed 3 docs per index, migrate expired, delete expired, update WindowState. Returns summary map. |

### controller/RotateController.java

Thin controller that delegates to `RotateService`.

| Endpoint | Method | Description |
|----------|--------|-------------|
| `POST /api/rotate/{date}` | POST | Parses date and delegates to RotateService.rotate() |

## Configuration

```properties
spring.elasticsearch.uris=http://localhost:9200
app.index.retention-days=3
app.index.prefix=index
```

### config/CorsConfig.java

Allows requests from `http://localhost:5173`, `5174`, `5175` on `/api/**` endpoints.

## Infrastructure

### Elasticsearch Container (podman)

- Image: `docker.elastic.co/elasticsearch/elasticsearch:9.0.2`
- Port: 9200
- Security disabled for local dev
- Single node discovery

### Scripts

| Script | Purpose |
|--------|---------|
| `run.sh` | Starts ES container + dashboard (Vite) + Spring Boot app |
| `stop.sh` | Stops ES container via podman-compose |
| `start.sh` | Starts ES container, waits for readiness, installs dashboard deps |
| `feed.sh` | Creates 3 indexes and feeds 9 sample documents (3 per index) |
| `test.sh` | Calls all API endpoints to verify all features work |

## Document Schema

```json
{
  "id": "uuid",
  "title": "string",
  "content": "string",
  "timestamp": "2026-03-26T10:30:00",
  "tags": ["string"]
}
```

## Dashboard (React)

### Theme

Light modern theme with indigo (`#6366f1`) accent color. Soft gray background (`#f0f2f5`), white cards with subtle shadows, rounded corners, pill-shaped badges. Modal uses backdrop blur overlay.

### Layout

Two-column symmetric layout:

| Left Column | Right Column |
|-------------|--------------|
| Sliding Window Gantt chart | Search textbox with wildcard |
| Rotate button + date picker | Index filter banner (when clicking index) |
| Indexes table (clickable names, docs, size, health, window) | Scrollable search results |
| | Clickable results open JSON modal |

### Features

- **Stats Cards**: Total indexes, total documents, retention days (indigo numbers, uppercase labels)
- **Gantt-style Sliding Window**: Stacked rows showing current window (indigo), new indexes (green), deleted indexes (red), projected next 3 days. Dot-style legend.
- **Rotate**: Date picker + button that creates all window indexes, feeds 3 docs per index, migrates data from expired indexes, deletes old indexes, updates WindowState, refreshes dashboard
- **Search**: Wildcard search across all window indexes, supports single characters. Blank search defaults to `*`.
- **Clickable Index Names**: Clicking an index name in the table loads all documents from that index into the search area. Shows a filter banner with the index name and a "clear" link to reset.
- **Scrollable Results**: Search results area with max-height 500px scroll
- **Document Modal**: Click any result to see full JSON with syntax coloring (indigo keys, green strings, yellow numbers, pink booleans). ESC or click overlay to close. Backdrop blur effect. 80vw wide, max 900px.
- **Auto-refresh**: Dashboard data refreshes every 5 seconds via TanStack Query

### Dashboard Tech Stack

- React 19
- TanStack Query 5 (auto-refresh every 5s)
- Vite 8
- Bun
- TypeScript

## Integration Tests

Uses Testcontainers with `docker.elastic.co/elasticsearch/elasticsearch:9.0.2`.

1. **Multi-index query**: Create indexes for 3 days, insert data into each, search across all 3 simultaneously, verify results come from all 3 indexes
2. **Idempotent index creation**: 10 concurrent threads create the same index, zero errors, index exists
3. **Index deletion**: Create, verify exists, delete, verify gone, double-delete returns false

## Tech Stack

| Component | Version |
|-----------|---------|
| Java | 25 |
| Spring Boot | 4.0.4 |
| Elasticsearch | 9.0.2 |
| Gradle | 9.0 |
| React | 19 |
| TanStack Query | 5 |
| Vite | 8 |
| Bun | 1.x |
| Podman | latest |
| Testcontainers | 1.20.4 |
