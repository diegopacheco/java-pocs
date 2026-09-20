#!/usr/bin/env bash
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/common.sh"

if pid_of "$APP_PID_FILE" >/dev/null 2>&1; then
    echo "$APP_NAME already running with pid $(pid_of "$APP_PID_FILE")"
    exit 0
fi

require_java
mvn_run -q test-compile

: > "$APP_LOG_FILE"
(cd "$ROOT" && ./mvnw -q exec:exec) >>"$APP_LOG_FILE" 2>&1 &
APP_PID=$!
echo "$APP_PID" > "$APP_PID_FILE"

if ! wait_until_stopped "$APP_PID"; then
    echo "$APP_NAME did not finish in time, see $APP_LOG_FILE" >&2
    exit 1
fi

set +e
wait "$APP_PID"
APP_STATUS=$?
set -e
rm -f "$APP_PID_FILE"

grep -v "^WARNING" "$APP_LOG_FILE" || true

if [ "$APP_STATUS" -ne 0 ]; then
    echo "$APP_NAME failed with exit code $APP_STATUS" >&2
    exit "$APP_STATUS"
fi

echo
echo "$APP_NAME: console application, no network service"
echo "log: .run/logs/$APP_NAME.log"
