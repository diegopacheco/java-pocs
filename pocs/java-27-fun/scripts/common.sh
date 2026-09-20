#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
RUN_DIR="$ROOT/.run"
LOG_DIR="$RUN_DIR/logs"
APP_NAME="java-27-fun"
APP_PID_FILE="$RUN_DIR/$APP_NAME.pid"
APP_LOG_FILE="$LOG_DIR/$APP_NAME.log"
JAVA_REQUIRED=27
SDKMAN_JAVA="$HOME/.sdkman/candidates/java"

mkdir -p "$LOG_DIR"

java_is_required_version() {
    [ -x "$1/bin/java" ] || return 1
    "$1/bin/java" -version 2>&1 | head -1 | grep -q "\"${JAVA_REQUIRED}"
}

resolve_java_home() {
    local candidate
    if [ -n "${JAVA_HOME:-}" ] && java_is_required_version "$JAVA_HOME"; then
        printf '%s\n' "$JAVA_HOME"
        return 0
    fi
    for candidate in "$SDKMAN_JAVA/${JAVA_REQUIRED}"*; do
        if java_is_required_version "$candidate"; then
            printf '%s\n' "$candidate"
            return 0
        fi
    done
    return 1
}

require_java() {
    local home
    if ! home="$(resolve_java_home)"; then
        echo "Java $JAVA_REQUIRED not found, run scripts/setup.sh first" >&2
        return 1
    fi
    JAVA_HOME="$home"
    PATH="$JAVA_HOME/bin:$PATH"
    export JAVA_HOME PATH
}

mvn_run() {
    (cd "$ROOT" && ./mvnw "$@")
}

pid_of() {
    local pid_file="$1"
    [ -f "$pid_file" ] || return 1
    local pid
    pid="$(cat "$pid_file")"
    [ -n "$pid" ] || return 1
    kill -0 "$pid" 2>/dev/null || return 1
    printf '%s\n' "$pid"
}

wait_until_stopped() {
    local pid="$1"
    local tries=0
    while [ "$tries" -lt 60 ]; do
        kill -0 "$pid" 2>/dev/null || return 0
        sleep 1
        tries=$((tries + 1))
    done
    return 1
}
