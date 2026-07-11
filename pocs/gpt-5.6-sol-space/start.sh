#!/usr/bin/env bash
set -e
PORT="${PORT:-8080}"
python3 -m http.server "$PORT" --bind 127.0.0.1
