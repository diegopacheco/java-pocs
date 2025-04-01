#!/bin/bash

docker run --rm -d -e MYSQL_ROOT_PASSWORD=pass -p 3325:3306 --name mysql_test mysql:8.3

echo "Connect to mysql client: "
echo "mysql -uroot -ppass -h127.0.0.1 -P3325"
echo "Note: MySQL 8+ uses a new authentication method. If connecting with older clients, you may need to add --default-auth=mysql_native_password"