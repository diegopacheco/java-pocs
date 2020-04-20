#!/bin/bash

docker run --rm -d -e MYSQL_ROOT_PASSWORD=pass -p 3325:3306 --name mysql_test mysql:5.7
echo "connect via client: "
echo "mysql -uroot -ppass -h127.0.0.1 -P3325"
