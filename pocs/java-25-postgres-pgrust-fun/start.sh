#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
CONTAINER_NAME="java-25-pgrust-fun"
APP_PID_FILE="${ROOT_DIR}/.app.pid"
APP_LOG_FILE="${ROOT_DIR}/.app.log"
APP_PORT="${APP_PORT:-18080}"

cd "${ROOT_DIR}"

if [ -f "${APP_PID_FILE}" ]; then
  APP_PID="$(cat "${APP_PID_FILE}")"
  if kill -0 "${APP_PID}" >/dev/null 2>&1; then
    kill "${APP_PID}"
    while kill -0 "${APP_PID}" >/dev/null 2>&1; do
      sleep 1
    done
  fi
  rm -f "${APP_PID_FILE}"
fi

if podman ps -a --format '{{.Names}}' | grep -qx "${CONTAINER_NAME}"; then
  podman rm -f "${CONTAINER_NAME}" >/dev/null
fi

podman run -d --name "${CONTAINER_NAME}" -p 6543:5432 -e POSTGRES_PASSWORD=books malisper/pgrust:v0.1 >/dev/null

for _ in $(seq 1 60); do
  if podman exec -e PGPASSWORD=books "${CONTAINER_NAME}" psql -h 127.0.0.1 -U postgres -d postgres -c '\q' >/dev/null 2>&1; then
    break
  fi
  sleep 1
done

podman exec -e PGPASSWORD=books "${CONTAINER_NAME}" psql -h 127.0.0.1 -U postgres -d postgres -c '\q' >/dev/null
podman exec -e PGPASSWORD=books "${CONTAINER_NAME}" psql -h 127.0.0.1 -U postgres -d postgres -v ON_ERROR_STOP=1 -c "do \$\$ begin if not exists (select 1 from pg_roles where rolname = 'books') then create role books login password 'books'; end if; end \$\$;" >/dev/null

if [ "$(podman exec -e PGPASSWORD=books "${CONTAINER_NAME}" psql -h 127.0.0.1 -U postgres -d postgres -At -c "select count(*) from pg_database where datname = 'booksdb'")" = "0" ]; then
  podman exec -e PGPASSWORD=books "${CONTAINER_NAME}" psql -h 127.0.0.1 -U postgres -d postgres -v ON_ERROR_STOP=1 -c "create database booksdb owner books" >/dev/null
fi

podman exec -e PGPASSWORD=books "${CONTAINER_NAME}" psql -h 127.0.0.1 -U postgres -d booksdb -v ON_ERROR_STOP=1 -c "grant all on schema public to books" >/dev/null
podman exec -e PGPASSWORD=books "${CONTAINER_NAME}" psql -h 127.0.0.1 -U postgres -d booksdb -v ON_ERROR_STOP=1 -c "alter schema public owner to books" >/dev/null

APP_PORT="${APP_PORT}" mvn -q -DskipTests spring-boot:run > "${APP_LOG_FILE}" 2>&1 &
echo $! > "${APP_PID_FILE}"

for _ in $(seq 1 60); do
  if curl -fsS "http://localhost:${APP_PORT}/api/books" >/dev/null 2>&1; then
    break
  fi
  sleep 1
done

curl -fsS "http://localhost:${APP_PORT}/api/books" >/dev/null
printf 'App started on http://localhost:%s\nSwagger UI: http://localhost:%s/swagger-ui\nSQL Console: http://localhost:%s/sql-console\n' "${APP_PORT}" "${APP_PORT}" "${APP_PORT}"
