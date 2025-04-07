#!/bin/bash

CONTAINER_NAME="mysql9x"
MYSQL_ROOT_PASSWORD="pass"
MYSQL_DATABASE="profile"
HOST_PORT=3306

# Check if MySQL container is already running
if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
    echo "MySQL container is already running."
else
    if [ "$(docker ps -aq -f status=exited -f name=$CONTAINER_NAME)" ]; then
        echo "Starting existing MySQL container..."
        docker start $CONTAINER_NAME
    else
        echo "Creating and starting new MySQL 9.2 container..."
        docker run --rm --name $CONTAINER_NAME \
            -p $HOST_PORT:3306 \
            -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD \
            -e MYSQL_DATABASE=$MYSQL_DATABASE \
            -d mysql:9.2
    fi
fi

echo "Waiting for MySQL to be ready..."
for i in {1..30}; do
    if docker exec $CONTAINER_NAME mysqladmin ping -h localhost -u root -p$MYSQL_ROOT_PASSWORD --silent &> /dev/null; then
        echo "MySQL is up and running!"
        echo "Connection details:"
        echo "  Host: localhost"
        echo "  Port: $HOST_PORT"
        echo "  User: root"
        echo "  Password: $MYSQL_ROOT_PASSWORD"
        echo "  Database: $MYSQL_DATABASE"
        exit 0
    fi
    echo "Still waiting... ($i/30)"
    sleep 1
done

echo "MySQL did not become ready in time. Check container logs:"
echo "docker logs $CONTAINER_NAME"
exit 1