#!/usr/bin/env bash
set -uo pipefail
cd "$(dirname "$0")"

B=http://localhost:8080

pretty() { python3 -m json.tool 2>/dev/null || cat; }
line() { echo "------------------------------------------------------------"; }
step() { line; echo "$1"; line; }

if ! curl -s "$B/actuator/health" >/dev/null 2>&1; then
  echo "app is not running on 8080, start it first with ./start.sh"
  exit 1
fi

step "POST /api/auth/login"
LOGIN=$(curl -s -X POST "$B/api/auth/login" -H 'Content-Type: application/json' -d '{"username":"admin","password":"admin"}')
echo "$LOGIN" | pretty
TOKEN=$(echo "$LOGIN" | sed -E 's/.*"token":"([^"]+)".*/\1/')
AUTH="Authorization: Bearer $TOKEN"

step "GET /api/books without token (expect 401)"
curl -s -w "\nHTTP %{http_code}\n" "$B/api/books"

step "POST /api/books (create)"
CREATED=$(curl -s -X POST "$B/api/books" -H "$AUTH" -H 'Content-Type: application/json' \
  -d '{"title":"The Art of Computer Programming","author":"Donald Knuth","totalPages":650}')
echo "$CREATED" | pretty
ID=$(echo "$CREATED" | sed -E 's/.*"id":"([^"]+)".*/\1/')

step "GET /api/books/$ID (get by id)"
curl -s "$B/api/books/$ID" -H "$AUTH" | pretty

step "PATCH /api/books/$ID/pages (track pages read = 90)"
curl -s -X PATCH "$B/api/books/$ID/pages" -H "$AUTH" -H 'Content-Type: application/json' \
  -d '{"pagesRead":90}' | pretty

step "GET /api/books?page=0&size=2 (paginated, defaults)"
curl -s "$B/api/books?page=0&size=2" -H "$AUTH" | pretty

step "GET /api/books?page=1&size=2 (next page)"
curl -s "$B/api/books?page=1&size=2" -H "$AUTH" | pretty

step "POST /api/books/batch-pages (atomic transaction, success)"
TWO=$(curl -s "$B/api/books?page=0&size=5" -H "$AUTH" | grep -oE '"id":"[^"]+"' | head -2 | sed -E 's/"id":"([^"]+)"/\1/')
ID1=$(echo "$TWO" | sed -n '1p')
ID2=$(echo "$TWO" | sed -n '2p')
curl -s -X POST "$B/api/books/batch-pages" -H "$AUTH" -H 'Content-Type: application/json' \
  -d "{\"updates\":[{\"id\":\"$ID1\",\"pagesRead\":10},{\"id\":\"$ID2\",\"pagesRead\":20}]}" | pretty

step "POST /api/books/batch-pages (rollback, expect 409)"
curl -s -w "\nHTTP %{http_code}\n" -X POST "$B/api/books/batch-pages" -H "$AUTH" -H 'Content-Type: application/json' \
  -d "{\"updates\":[{\"id\":\"$ID1\",\"pagesRead\":5},{\"id\":\"$ID2\",\"pagesRead\":999999}]}"

step "GET /api/sql/schema (tables and fields, requires token)"
curl -s "$B/api/sql/schema" -H "$AUTH" | pretty

step "POST /api/sql/execute (PartiQL over JDBC, requires token)"
curl -s -X POST "$B/api/sql/execute" -H "$AUTH" -H 'Content-Type: application/json' \
  -d '{"sql":"SELECT id, title, author, totalPages, pagesRead FROM \"Books\""}' | pretty

step "GET /actuator/health"
curl -s "$B/actuator/health" | pretty

line
echo "done"
