#!/bin/bash

echo "Stopping all Docker Compose services..."
docker-compose down

echo "Removing containers, networks, and volumes..."
docker-compose down -v

echo "Cleaning up unused Podman resources..."
podman system prune -f

echo "All services stopped and cleaned up."