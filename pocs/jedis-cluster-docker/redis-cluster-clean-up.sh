#!/bin/bash

docker volume rm redis-cluster_redis-cluster_data-0
docker volume rm redis-cluster_redis-cluster_data-1
docker volume rm redis-cluster_redis-cluster_data-2
docker volume rm redis-cluster_redis-cluster_data-3
docker volume rm redis-cluster_redis-cluster_data-4
docker volume rm redis-cluster_redis-cluster_data-5
docker volume rm redis-cluster_redis-cluster_data-6

docker volume prune
