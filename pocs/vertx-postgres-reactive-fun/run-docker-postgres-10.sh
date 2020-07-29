#!/bin/bash

echo "client connection: "
echo "psql -h 172.17.0.3 -d pqdb -U root -W"

docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 \
           --name postgres10 -e POSTGRES_USER=root \
           -e POSTGRES_PASSWORD=root -e POSTGRES_DB=pqdb \
           -p 5432:5432 postgres:10.5
