#!/usr/bin/env bash
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/common.sh"

if PID="$(pid_of "$APP_PID_FILE" 2>/dev/null)"; then
    echo "$APP_NAME UP pid=$PID"
else
    echo "$APP_NAME DOWN pid=-"
fi

if JAVA_DIR="$(resolve_java_home 2>/dev/null)"; then
    echo "java$JAVA_REQUIRED UP $("$JAVA_DIR/bin/java" -version 2>&1 | head -1)"
else
    echo "java$JAVA_REQUIRED DOWN not installed"
fi

if [ -d "$ROOT/target/classes" ]; then
    echo "build UP target/classes"
else
    echo "build DOWN not compiled"
fi
