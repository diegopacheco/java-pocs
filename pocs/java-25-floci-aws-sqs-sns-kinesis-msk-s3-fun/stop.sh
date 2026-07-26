#!/usr/bin/env bash
set -euo pipefail
if [[ "$(uname -s)" == "Darwin" ]]; then
  podman_uid="$(podman machine ssh id -u)"
  export PODMAN_SOCKET_PATH="/run/user/${podman_uid}/podman/podman.sock"
else
  export PODMAN_SOCKET_PATH="${XDG_RUNTIME_DIR:-/run/user/$(id -u)}/podman/podman.sock"
fi
if [[ -f .poc-ports.json ]]; then
  export APP_PORT="$(jq -r '.appPort' .poc-ports.json)"
  export FLOCI_PORT="$(jq -r '.flociPort' .poc-ports.json)"
fi
if [[ -z "$(podman-compose ps -q 2>/dev/null)" ]]; then
  jq -n '{status: "already stopped"}'
  exit 0
fi
podman-compose down --remove-orphans
jq -n '{status: "stopped"}'
