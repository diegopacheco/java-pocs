#!/bin/bash

echo "Starting GlusterFS and Java 21 application..."

docker-compose up -d

echo "Waiting for services to start..."
sleep 60

echo "=== Container Status ==="
docker-compose ps

echo "=== GlusterFS Volume Info ==="
docker exec gluster-server gluster volume info gv0

echo "=== Java App Logs ==="
docker logs java21-glusterfs-app

echo "=== To follow Java app logs in real-time ==="
echo "docker logs -f java21-glusterfs-app"

echo "=== To connect to the Java app container ==="
echo "docker exec -it java21-glusterfs-app /bin/bash"

echo "=== To check GlusterFS mount inside Java app ==="
echo "docker exec java21-glusterfs-app ls -la /mnt/gluster"