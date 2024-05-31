#!/bin/bash

export DOCKER_HOST=unix:///run/user/`id -u`/podman/podman.sock
export TESTCONTAINERS_RYUK_DISABLED=true
./mvnw test