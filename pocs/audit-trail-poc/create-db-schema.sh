#!/bin/bash

CONTAINER_NAME="mysql9"
MYSQL_ROOT_PASSWORD="root"
DB_DIRECTORY="db"
DB_SCRIPT="$DB_DIRECTORY/db.sql"
SCHEMA_SCRIPT="$DB_DIRECTORY/schema.sql"

if ! docker ps | grep -q $CONTAINER_NAME; then
    echo "Error: MySQL container '$CONTAINER_NAME' is not running."
    echo "Please start the container using ./run-mysql-9.docker.sh start"
    exit 1
fi

if [ ! -f "$DB_SCRIPT" ]; then
    echo "Error: Database script '$DB_SCRIPT' not found!"
    exit 1
fi

if [ ! -f "$SCHEMA_SCRIPT" ]; then
    echo "Error: Schema script '$SCHEMA_SCRIPT' not found!"
    exit 1
fi

echo "Creating database using $DB_SCRIPT..."
cat $DB_SCRIPT | docker exec -i $CONTAINER_NAME mysql -uroot --password=$MYSQL_ROOT_PASSWORD
if [ $? -eq 0 ]; then
    echo "Database created successfully."
else
    echo "Failed to create database."
    exit 1
fi

echo "Creating schema using $SCHEMA_SCRIPT..."
cat $SCHEMA_SCRIPT | docker exec -i $CONTAINER_NAME mysql -uroot --password=$MYSQL_ROOT_PASSWORD audit_db
if [ $? -eq 0 ]; then
    echo "Schema created successfully."
else
    echo "Failed to create schema."
    exit 1
fi

echo "Database initialization completed successfully."