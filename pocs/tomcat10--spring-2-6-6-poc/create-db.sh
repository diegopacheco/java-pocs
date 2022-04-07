#!/bin/bash

cat src/main/resources/schema.sql | mysql -uroot -ppass -h127.0.0.1 -P3325 
