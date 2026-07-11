#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"

if [ -f app.pid ]; then
  kill "$(cat app.pid)" >/dev/null 2>&1 || true
  rm -f app.pid
  echo "app stopped"
fi

podman rm -f ddb-local >/dev/null 2>&1 || true
echo "dynamodb-local stopped"
