#!/usr/bin/env bash
set -euo pipefail

APP_PORT="${APP_PORT:-18080}"
BASE_URL="http://localhost:${APP_PORT}"
UNIQUE_ISBN="978032112$(date +%s)"

BOOKS_JSON="$(curl -fsS "${BASE_URL}/api/books?page=0&size=5")"
printf '%s' "${BOOKS_JSON}" | grep -q '"title":"The Pragmatic Programmer"'
printf '%s' "${BOOKS_JSON}" | grep -q '"page":0'
printf '%s' "${BOOKS_JSON}" | grep -q '"size":5'

CREATE_JSON="$(curl -fsS -X POST "${BASE_URL}/api/books" -H 'Content-Type: application/json' -d "{\"title\":\"Patterns of Enterprise Application Architecture\",\"author\":\"Martin Fowler\",\"isbn\":\"${UNIQUE_ISBN}\",\"publishedYear\":2002}")"
printf '%s' "${CREATE_JSON}" | grep -q "\"isbn\":\"${UNIQUE_ISBN}\""

curl -fsS "${BASE_URL}/swagger" | grep -q '"openapi"'
curl -fsSL "${BASE_URL}/swagger-ui" | grep -q 'Swagger UI'
curl -fsS "${BASE_URL}/sql-console" | grep -q 'pgrust SQL Console'
curl -fsS -X POST "${BASE_URL}/sql-console/query" -H 'Content-Type: application/json' -d '{"sql":"select count(*) as total from books"}' | grep -q '"total"'

printf 'All runtime checks passed\n'
