# Java 25 + Spring Boot 4 + pgrust

This project is a Java 25 Maven application built with Spring Boot 4.0.6, Spring Data JDBC, HikariCP, PostgreSQL JDBC, and pgrust.
It exposes a classical Spring modular structure with controller, service, repository, SQL bootstrap scripts, and a browser SQL console.
The app starts with at least 10 books and stores them in pgrust through Spring Boot endpoints.
OpenAPI is published at `/swagger` and Swagger UI is published at `/swagger-ui`.
The browser SQL page is published at `/sql-console` and sends one SQL statement at a time to pgrust.
The runtime flow is Podman for pgrust plus Maven for the Spring Boot app.
The project includes `start.sh`, `stop.sh`, and `test.sh`.
The screenshots in `docs/screenshots` were created with `npx playwright`.

## Stack

- Java 25
- Maven
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JDBC
- HikariCP
- PostgreSQL JDBC driver
- pgrust in Podman
- springdoc OpenAPI

## Project layout

```text
src/main/java/com/diegopacheco/pgrustfun
├── PgrustFunApplication.java
├── book
│   ├── domain
│   ├── repository
│   ├── service
│   └── web
├── config
├── error
└── sql
```

## Endpoints

| Method | Path | Purpose |
| --- | --- | --- |
| GET | `/api/books?page=0&size=10` | Lists paginated books from pgrust |
| POST | `/api/books` | Inserts a new book into pgrust |
| GET | `/swagger` | OpenAPI JSON |
| GET | `/swagger-ui` | Swagger UI |
| GET | `/sql-console` | Browser SQL console |
| POST | `/sql-console/query` | Runs one SQL statement against pgrust |

## Book payload

```json
{
  "title": "Patterns of Enterprise Application Architecture",
  "author": "Martin Fowler",
  "isbn": "9780321127426",
  "publishedYear": 2002
}
```

## Pagination

`GET /api/books` accepts `page` and `size`.
`page` starts at `0`.
`size` must be greater than `0`.
The response returns `content`, `page`, `size`, `totalElements`, and `totalPages`.

```json
{
  "content": [
    {
      "id": 1,
      "title": "The Pragmatic Programmer",
      "author": "Andrew Hunt",
      "isbn": "9780201616224",
      "publishedYear": 1999
    }
  ],
  "page": 0,
  "size": 5,
  "totalElements": 10,
  "totalPages": 2
}
```

Curl commands:

```bash
curl -s "http://localhost:18080/api/books?page=0&size=5"
curl -s "http://localhost:18080/api/books?page=1&size=5"
curl -s -X POST "http://localhost:18080/api/books" -H "Content-Type: application/json" -d '{"title":"Patterns of Enterprise Application Architecture","author":"Martin Fowler","isbn":"9780321127426","publishedYear":2002}'
```

## Build

```bash
mvn clean test package
```

## Run

```bash
chmod +x start.sh stop.sh test.sh
./start.sh
```

This starts pgrust in Podman on port `6543`, creates the `books` role and `booksdb` database, and starts Spring Boot on `18080`.
You can override the HTTP port with `APP_PORT=19090 ./start.sh`.

## Stop

```bash
./stop.sh
```

## Runtime checks

```bash
./test.sh
```

## SQL console

Open `http://localhost:18080/sql-console`.
The page loads a starter query against the `books` table.
The UI shows line numbers, SQL syntax highlighting, a right-side table catalog, a result grid, and the raw JSON payload.
Query errors are rendered directly in the page so invalid SQL is visible without opening the browser console.
Only one SQL statement is accepted per request.
You can use it for reads, inserts, updates, and DDL.

## Swagger

Open `http://localhost:18080/swagger-ui`.
The UI shows the Books API and the SQL Console API.
The JSON contract is available at `http://localhost:18080/swagger`.

## Startup data

The app creates the `books` table on boot from `schema.sql`.
The app loads 10 records from `data.sql`.
The SQL uses `on conflict (isbn) do nothing`, so repeated startups keep the seed set stable.

## pgrust notes

pgrust is a PostgreSQL rewrite in Rust.
The project targets PostgreSQL 18.3 compatibility.
The upstream README says it matches expected PostgreSQL output across more than 46,000 regression queries.
The upstream README also says it is disk compatible with PostgreSQL and can boot from an existing PostgreSQL 18.3 data directory.
The maintainers describe the main goal as keeping PostgreSQL behavior while making deep internal changes easier in Rust.
The current status from upstream is not production-ready and not performance optimized yet.
The upstream notes that many existing extensions and procedural language integrations are not generally compatible yet.
The published roadmap mentions multithreaded internals.
The roadmap also mentions built-in connection pooling.
The roadmap includes better support for JSON-heavy workloads.
The roadmap includes fast branching workflows, storage changes, runtime guardrails for bad queries, and fewer sudden query-plan switches.
This app uses the published image `malisper/pgrust:v0.1` and talks to it through the regular PostgreSQL wire protocol with the standard JDBC driver.

Source used for these notes: https://github.com/malisper/pgrust

## Screenshots

The files below were captured with Playwright after starting the app:

- `docs/screenshots/books-api.png`
- `docs/screenshots/swagger-ui.png`
- `docs/screenshots/sql-console.png`

Commands used:

```bash
npx playwright screenshot http://localhost:18080/api/books docs/screenshots/books-api.png
npx playwright screenshot http://localhost:18080/swagger-ui docs/screenshots/swagger-ui.png
npx playwright screenshot http://localhost:18080/sql-console docs/screenshots/sql-console.png
```
