mkdir -p /tmp/redis/data/

docker-compose rm
echo "Cluster will run on 3 ports: [6371 6372 6373 6374 6375 6376]"
docker-compose up