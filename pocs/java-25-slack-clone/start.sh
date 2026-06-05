#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"

"$ROOT/backend/gradlew" -p "$ROOT/backend" bootJar -x test
npm --prefix "$ROOT/frontend" ci
npm --prefix "$ROOT/frontend" run build

podman-compose -f "$ROOT/podman-compose.yml" up -d --build

attempts=0
until curl -sf http://localhost:8080/health >/dev/null 2>&1; do
  attempts=$((attempts + 1))
  if [ "$attempts" -ge 180 ]; then
    echo "backend did not become healthy"
    exit 1
  fi
  sleep 1
done

attempts=0
until curl -sf http://localhost:3000/ >/dev/null 2>&1; do
  attempts=$((attempts + 1))
  if [ "$attempts" -ge 60 ]; then
    echo "frontend did not become healthy"
    exit 1
  fi
  sleep 1
done

echo "ready: http://localhost:3000"
