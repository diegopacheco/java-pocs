#!/bin/bash

echo "🧹 Cleaning up existing containers and volumes..."
docker-compose down -v 2>/dev/null

echo "🗑️  Removing any orphaned volumes..."
docker volume prune -f

echo "🚀 Starting LIGHTNING-FAST S3 storage..."
echo "⏱️  Expected startup time: 5-10 seconds"
docker-compose up --build