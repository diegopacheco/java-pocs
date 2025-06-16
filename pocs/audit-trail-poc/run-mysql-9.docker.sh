#!/bin/bash

CONTAINER_NAME="mysql9"
MYSQL_ROOT_PASSWORD="root"
MYSQL_DATABASE="testdb"
MYSQL_PORT="3306"

function start_mysql() {
    echo "Starting MySQL 9 container..."
    docker run --name $CONTAINER_NAME \
        -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD \
        -e MYSQL_DATABASE=$MYSQL_DATABASE \
        -p $MYSQL_PORT:3306 \
        -d mysql:9

    echo "Waiting for MySQL to initialize..."
    sleep 10
    echo "MySQL container started. Access at localhost:$MYSQL_PORT"
}

function stop_mysql() {
    echo "Stopping MySQL container..."
    docker stop $CONTAINER_NAME
    docker rm $CONTAINER_NAME
    echo "MySQL container stopped and removed."
}

function mysql_client() {
    echo "Connecting to MySQL client..."
    docker exec -it $CONTAINER_NAME mysql -uroot -p$MYSQL_ROOT_PASSWORD
}

case "$1" in
    start)
        start_mysql
        ;;
    stop)
        stop_mysql
        ;;
    client)
        mysql_client
        ;;
    *)
        echo "Usage: $0 {start|stop|client}"
        exit 1
        ;;
esac
exit 0