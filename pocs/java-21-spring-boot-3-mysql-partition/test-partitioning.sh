#!/bin/bash

echo "### Check partition information:"
docker exec mysql-partition mysql -uroot -prootpassword -e "USE partitiondb; SELECT TABLE_NAME, PARTITION_NAME, PARTITION_EXPRESSION, PARTITION_DESCRIPTION, TABLE_ROWS FROM information_schema.PARTITIONS WHERE TABLE_SCHEMA='partitiondb' AND TABLE_NAME='users' AND TABLE_ROWS > 0 ORDER BY PARTITION_ORDINAL_POSITION;"

echo "### Query users from specific partition:"
docker exec mysql-partition mysql -uroot -prootpassword -e "USE partitiondb; SELECT name, name_first_char FROM users WHERE name_first_char = 'D';"

echo "### Show query execution plan (partition pruning):"
docker exec mysql-partition mysql -uroot -prootpassword -e "USE partitiondb; EXPLAIN SELECT * FROM users WHERE name = 'Diego';"
