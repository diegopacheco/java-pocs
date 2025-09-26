#!/bin/bash

echo "Building Spring Boot application..."
mvn clean package -DskipTests

if [ $? -ne 0 ]; then
    echo "Build failed!"
    exit 1
fi

echo "Starting Docker Compose services..."
docker-compose up --build -d

echo "Waiting for services to be ready..."
sleep 30

echo "Checking service status..."
docker-compose ps

echo "Application should be running at:"
echo "- Spring Boot App: http://localhost:8080"
echo "- Supabase REST API: http://localhost:3000"
echo "- Supabase Auth: http://localhost:9999"
echo "- Supabase Realtime: http://localhost:4000"
echo "- Supabase Storage: http://localhost:5000"
echo "- Kong API Gateway: http://localhost:8000"
echo "- Mail UI: http://localhost:9000"

echo "To view logs: docker-compose logs -f"
echo "To stop: ./stop-all.sh"