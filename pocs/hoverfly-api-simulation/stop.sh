#!/bin/bash

podman compose down
podman system prune -f
