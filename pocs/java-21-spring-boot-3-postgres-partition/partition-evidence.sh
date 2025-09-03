#!/bin/bash

echo "PostgreSQL Partition Evidence Script"
echo "===================================="
echo

# Database connection
DB="postgresql://postgres:postgres@localhost:5432/userdb"

echo "1. Show all partition tables"
echo "----------------------------"
echo "SQL: SELECT tablename FROM pg_tables WHERE tablename LIKE 'users%' ORDER BY tablename;"
psql $DB -c "SELECT tablename FROM pg_tables WHERE tablename LIKE 'users%' ORDER BY tablename;"
echo

echo "2. Count records in each partition (only non-empty)"
echo "---------------------------------------------------"
echo "SQL: SELECT 'users_a' as partition, COUNT(*) FROM users_a WHERE COUNT(*) > 0;"
psql $DB -c "
SELECT 'users_others' as partition, COUNT(*) FROM users_others
UNION ALL
SELECT 'users_a', COUNT(*) FROM users_a
UNION ALL
SELECT 'users_m', COUNT(*) FROM users_m
UNION ALL
SELECT 'users_z', COUNT(*) FROM users_z
ORDER BY partition;
"
echo

echo "3. Show partition boundaries"
echo "----------------------------"
echo "SQL: Show partition ranges"
psql $DB -c "
SELECT c.oid::regclass AS table_name, pg_get_expr(c.relpartbound, c.oid) AS partition_range
FROM pg_class c 
JOIN pg_inherits i ON c.oid = i.inhrelid 
JOIN pg_class p ON i.inhparent = p.oid 
WHERE p.relname = 'users' 
ORDER BY c.relname;
"
echo

echo "4. Performance test: Query WITH partition key (fast)"
echo "----------------------------------------------------"
echo "SQL: SELECT * FROM users WHERE username_first_char = 'a' AND username = 'alice';"
psql $DB -c "\timing on" -c "SELECT * FROM users WHERE username_first_char = 'a' AND username = 'alice';"
echo

echo "5. Performance test: Query WITHOUT partition key (slow - scans all partitions)"
echo "-----------------------------------------------------------------------------"
echo "SQL: SELECT * FROM users WHERE username = 'alice';"
psql $DB -c "\timing on" -c "SELECT * FROM users WHERE username = 'alice';"
echo

echo "6. Show query plans - WITH partition key (only 1 partition scanned)"
echo "-------------------------------------------------------------------"
echo "SQL: EXPLAIN SELECT * FROM users WHERE username_first_char = 'a';"
psql $DB -c "EXPLAIN SELECT * FROM users WHERE username_first_char = 'a';"
echo

echo "7. Show query plans - WITHOUT partition key (ALL partitions scanned)"  
echo "--------------------------------------------------------------------"
echo "SQL: EXPLAIN SELECT * FROM users WHERE first_name = 'Alice';"
psql $DB -c "EXPLAIN SELECT * FROM users WHERE first_name = 'Alice';"
echo

echo "Summary:"
echo "- Data is partitioned by first letter of username"
echo "- Queries WITH partition key are much faster (scan 1 partition)"
echo "- Queries WITHOUT partition key are slower (scan all 27 partitions)"
echo "- Application code doesn't need to know about partitions"