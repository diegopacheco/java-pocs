#!/bin/bash

# Check if MySQL container is running
if ! docker ps | grep -q mysql_test; then
  echo "MySQL container is not running. Starting it now..."
  docker run --rm -d -e MYSQL_ROOT_PASSWORD=pass -p 3325:3306 --name mysql_test mysql:8.3

  # Wait for MySQL to be ready
  echo "Waiting for MySQL to start..."
  sleep 10
fi

echo "Executing schema.sql..."
docker exec -i mysql_test mysql -uroot -ppass <<< "$(cat src/main/resources/schema.sql)"
echo "Database schema created successfully."