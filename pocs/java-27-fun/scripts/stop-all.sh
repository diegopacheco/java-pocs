#!/usr/bin/env bash
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/common.sh"

if ! PID="$(pid_of "$APP_PID_FILE" 2>/dev/null)"; then
    rm -f "$APP_PID_FILE"
    echo "$APP_NAME already stopped"
    exit 0
fi

kill "$PID" 2>/dev/null || true
if ! wait_until_stopped "$PID"; then
    kill -9 "$PID" 2>/dev/null || true
fi

rm -f "$APP_PID_FILE"
echo "$APP_NAME stopped"
