#!/bin/bash

export NEO4J_DATA=/tmp/neo4j-docker/
mkdir $NEO4J_DATA

docker run \
    --rm \
    --name neo4j \
    -p7474:7474 -p7687:7687 \
    -d \
    -v $NEO4J_DATA/neo4j/data:/data \
    -v $NEO4J_DATA/neo4j/logs:/logs \
    -v $NEO4J_DATA/neo4j/import:/var/lib/neo4j/import \
    -v $NEO4J_DATA/neo4j/plugins:/plugins \
    --env NEO4J_AUTH=neo4j/test \
    neo4j:latest
