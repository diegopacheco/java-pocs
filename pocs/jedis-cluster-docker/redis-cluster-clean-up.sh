#!/bin/bash

docker volume prune

docker volume rm redis-cluster_redis-cluster_data-5 redis-cluster_redis-cluster_data-4 redis-cluster_redis-cluster_data-3 redis-cluster_redis-cluster_data-2 redis-cluster_redis-cluster_data-1 redis-cluster_redis-cluster_data-6

# do for each container appears in this list:
# docker stop $id
# docker rm $id
# docker volume rm redis-cluster_redis-cluster_data-5 redis-cluster_redis-cluster_data-4 redis-cluster_redis-cluster_data-3 redis-cluster_redis-cluster_data-2 redis-cluster_redis-cluster_data-1 redis-cluster_redis-cluster_data-6