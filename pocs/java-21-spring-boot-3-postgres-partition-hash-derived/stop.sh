#!/bin/bash

echo "Stopping PostgreSQL 17 with Hash Partitioning Demo..."
echo "===================================================="

# Stop and remove containers
docker-compose down

echo ""
echo "✅ All services stopped."
echo ""
echo "To completely clean up (including volumes):"
echo "docker-compose down -v"
echo ""
echo "To remove built images:"
echo "docker-compose down --rmi all"