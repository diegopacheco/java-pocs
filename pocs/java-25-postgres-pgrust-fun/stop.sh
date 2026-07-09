#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
CONTAINER_NAME="java-25-pgrust-fun"
APP_PID_FILE="${ROOT_DIR}/.app.pid"

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

printf 'App and pgrust container stopped\n'

