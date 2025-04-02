#!/bin/bash

if [ "$(docker ps -q -f name=elasticsearch)" ]; then
  echo "Elasticsearch is running"
else
  echo "Elasticsearch is not running, starting es..."
  docker run -d \
    --rm --name elasticsearch \
    -p 9200:9200 \
    -e "discovery.type=single-node" \
    -e "xpack.security.enabled=true" \
    -e "ELASTIC_PASSWORD=changeme" \
    -e "ES_JAVA_OPTS=-Xms512m -Xmx512m" \
    docker.elastic.co/elasticsearch/elasticsearch:8.10.2
fi