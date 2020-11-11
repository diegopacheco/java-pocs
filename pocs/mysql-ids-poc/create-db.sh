#!/bin/bash

echo "create database test_db;" | mysql -uroot -ppass -h127.0.0.1 -P3325
echo "use test_db; CREATE TABLE IF NOT EXISTS Test(
  k VARCHAR(100),
  v VARCHAR(100),
  PRIMARY KEY (k)
) ENGINE=INNODB;" | mysql -uroot -ppass -h127.0.0.1 -P3325
