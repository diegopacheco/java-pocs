#!/bin/bash

docker run --rm -d -v /var/lib/mysql:/var/lib/mysql \
  --user=root \
  -e MYSQL_ROOT_PASSWORD=pass -p 3325:3306 --name mysql_test diegopacheco/mysql57binlog:v1 
echo "connect via client: "
echo "mysql -uroot -ppass -h127.0.0.1 -P3325"
