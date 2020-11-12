#!/bin/bash

echo "CREATE KEYSPACE inventory
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
USE inventory;
CREATE TABLE inventory.product(id uuid PRIMARY KEY, description text);
" | /home/diego/bin/apache-cassandra-3.0.20/bin/cqlsh