#!/usr/bin/env bash
set -euo pipefail
if ! podman info >/dev/null 2>&1; then
  podman machine start
fi
if [[ "$(uname -s)" == "Darwin" ]]; then
  podman_uid="$(podman machine ssh id -u)"
  export PODMAN_SOCKET_PATH="/run/user/${podman_uid}/podman/podman.sock"
else
  export PODMAN_SOCKET_PATH="${XDG_RUNTIME_DIR:-/run/user/$(id -u)}/podman/podman.sock"
fi
if [[ -n "$(podman-compose ps -q 2>/dev/null)" ]]; then
  podman-compose down --remove-orphans >/dev/null
fi
port_in_use() {
  (exec 3<>"/dev/tcp/127.0.0.1/$1") >/dev/null 2>&1
}
find_port() {
  port="$1"
  limit="$((port + 100))"
  while ((port <= limit)); do
    if ! port_in_use "${port}"; then
      echo "${port}"
      return 0
    fi
    port="$((port + 1))"
  done
  return 1
}
if [[ -n "${APP_PORT:-}" ]] && port_in_use "${APP_PORT}"; then
  jq -n --arg port "${APP_PORT}" '{status: "failed", error: "APP_PORT is already in use", port: $port}'
  exit 1
fi
if [[ -n "${FLOCI_PORT:-}" ]] && port_in_use "${FLOCI_PORT}"; then
  jq -n --arg port "${FLOCI_PORT}" '{status: "failed", error: "FLOCI_PORT is already in use", port: $port}'
  exit 1
fi
export APP_PORT="${APP_PORT:-$(find_port 8080)}"
export FLOCI_PORT="${FLOCI_PORT:-$(find_port 4566)}"
jq -n --argjson appPort "${APP_PORT}" --argjson flociPort "${FLOCI_PORT}" '{appPort: $appPort, flociPort: $flociPort}' > .poc-ports.json
podman-compose up --build -d
for attempt in {1..60}; do
  if response="$(curl --max-time 1 -fsS "http://localhost:${APP_PORT}/v3/api-docs" 2>/dev/null)"; then
    jq --arg application "http://localhost:${APP_PORT}" --arg floci "http://localhost:${FLOCI_PORT}" --arg swagger "http://localhost:${APP_PORT}/swagger-ui.html" '{status: "ready", title: .info.title, application: $application, floci: $floci, swagger: $swagger}' <<<"${response}"
    exit 0
  fi
  sleep 1
done
podman-compose logs app
exit 1
