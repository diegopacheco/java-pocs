#!/bin/bash

echo "Starting PostgreSQL 17 with Hash Partitioning Demo..."
echo "=================================================="

echo "Stopping any existing containers..."
docker-compose down 2>/dev/null || true

echo "Cleaning up any conflicting containers..."
docker rm -f postgres-partition spring-boot-partition-app 2>/dev/null || true

echo "Building and starting containers..."
docker-compose up --build -d

echo ""
echo "Waiting for services to be ready..."
sleep 10

echo ""
echo "Container Status:"
docker-compose ps

echo ""
echo "Waiting for Spring Boot application to start..."
echo "This may take a few minutes on first run..."
sleep 30

echo ""
echo "Checking application health..."
curl -f http://localhost:8080/ > /dev/null 2>&1
if [ $? -eq 0 ]; then
    echo "✅ Application is running successfully!"
    echo ""
    echo "Services available:"
    echo "- Spring Boot API: http://localhost:8080"
    echo "- PostgreSQL: localhost:5432"
    echo ""
    echo "API Endpoints:"
    echo "- GET    /api/users          - List all users"
    echo "- POST   /api/users          - Create user"
    echo "- GET    /api/users/{id}     - Get user by ID"
    echo "- GET    /api/users/email/{email} - Get user by email"
    echo "- GET    /api/users/search?name={name} - Search users by name"
    echo "- PUT    /api/users/{id}     - Update user"
    echo "- DELETE /api/users/{id}     - Delete user"
    echo "- GET    /api/users/query/{id} - Custom query for user"
    echo ""
    echo "Run './partition-evidence.sh' to see partitioning evidence"
else
    echo "⚠️  Application might still be starting. Check logs with:"
    echo "docker-compose logs app"
fi