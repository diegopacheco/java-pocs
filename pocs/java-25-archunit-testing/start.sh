#!/bin/bash
podman-compose up -d
echo "Waiting for MySQL..."
until podman exec archunit-mysql mysqladmin ping -uroot -ppass --silent > /dev/null 2>&1; do
  sleep 1
done
echo "MySQL is ready on 127.0.0.1:3306"
