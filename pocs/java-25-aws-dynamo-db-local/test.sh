#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"

podman machine start >/dev/null 2>&1 || true
if ! curl -s http://localhost:8000 >/dev/null 2>&1; then
  podman rm -f ddb-local >/dev/null 2>&1 || true
  podman run -d --name ddb-local -p 8000:8000 amazon/dynamodb-local >/dev/null
  echo "waiting for dynamodb-local on 8000"
  until curl -s http://localhost:8000 >/dev/null 2>&1; do sleep 1; done
fi

./mvnw test
