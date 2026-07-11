#!/usr/bin/env bash
set -e
PORT="${PORT:-8080}"
PIDS="$(lsof -ti tcp:"$PORT" || true)"
if [ -n "$PIDS" ]; then
  kill $PIDS
fi
