#!/bin/bash

echo "CREATE KEYSPACE CLUSTER_TEST WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }; 
USE CLUSTER_TEST;
CREATE TABLE TEST ( key text PRIMARY KEY, value text);
CREATE TABLE TEST2 ( key text PRIMARY KEY, value text);
INSERT INTO TEST (key,value) VALUES ('k1', 'v1');
INSERT INTO TEST2 (key,value) VALUES ('k1', 'v1');
SELECT * from TEST;
SELECT * from TEST2;" | /home/diego/bin/apache-cassandra-3.0.20/bin/cqlsh