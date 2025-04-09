# Liquid Unit
Liquibase + Junit = Liquid Unit

```

  _     _             _     _ _   _       _ _
 | |   (_)           (_)   | | | | |     (_) |
 | |    _  __ _ _   _ _  __| | | | |_ __  _| |_
 | |   | |/ _` | | | | |/ _` | | | | '_ \| | __|
 | |___| | (_| | |_| | | (_| | |_| | | | | | |_
 |_____|_|\__, |\__,_|_|\__,_|\___/|_| |_|_|\__|
             | |
             |_|

LiquidUnit Usage:
  No args     - Run complete test suite: migrations, rollbacks, migrations
  --mt        - Run only migration tests
  --ro        - Run only rollback tests
  --? or --h  - Display this help message
```

### Rationale

The idea of this POC is to create a `blend` between `Liquibase` and `Junit`.
So migrations can be executed as tests (`test.sql`) and they can fail and `rollback.sql` script is executed.
So it's possible to automate schema changes and even migrations and be test-driven.

Basically you have 3 files:
* migration.sql -> Where you perform the migration
* test.sql -> Where you perform the tests, `expect : <number>` is used to assert the result of the query. 
* rollback.sql -> Where you perform the rollback.

### Why this POC is useful?

1. You can test migration scrips locally.
2. It can be used as bases for Integration testes with Migration Scripts.
3. It could be the basis for production automation of migration scripts.
4. It's fun and cool to learn stuff :-) Tests are being generated on the fly.

### Versions

```
Java      : 23
Liquibase : 4.29.0
Mysql     : 9.2.0
Junit     : 5.9.3
```

### Build 

```bash
./mvnw clean install 
```

### Start Mysql

```bash
./run-mysql-9x.sh
```

```
Creating and starting new MySQL 9.2 container...
cea6f8f3702c649f1b7aef5fca48a07c7e63014b0722a324ced8ea4e23f1b16e
Waiting for MySQL to be ready...
Still waiting... (1/30)
Still waiting... (2/30)
Still waiting... (3/30)
Still waiting... (4/30)
Still waiting... (5/30)
Still waiting... (6/30)
MySQL is up and running!
Connection details:
  Host: localhost
  Port: 3306
  User: root
  Password: pass
  Database: profile
````

### Result

Migrations and Tests
<img src="result-idea.png" />

Each SQL is run as an assertion and verified. Example:
```
Executing tests from src/main/resources/migrations/migration_1_create_schema/test.sql
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name = 'profile' -> Expected: 1, Actual: 1
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'profile' AND table_name = 'user' -> Expected: 1, Actual: 1
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'profile' AND table_name = 'user_links' -> Expected: 1, Actual: 1
Found expectation (look-ahead): 4
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.columns WHERE table_schema = 'profile' AND table_name = 'user' AND column_name IN ('id', 'name', 'email', 'address') -> Expected: 4, Actual: 4
Found expectation (look-ahead): 5
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.columns WHERE table_schema = 'profile' AND table_name = 'user_links' AND column_name IN ('id', 'user_id', 'x_link', 'facebook_link', 'youtube_link') -> Expected: 5, Actual: 5
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.key_column_usage WHERE table_schema = 'profile' AND table_name = 'user_links' AND column_name = 'user_id' AND referenced_table_name = 'user' -> Expected: 1, Actual: 1
```

Rollbacks
<img src="result-rollback.png" />

Sample output:
```
Applied migration: migration_4_add_data
Tables to verify dropped: []
Schemas to verify dropped: []
Tables to verify empty after DELETE: [profile.user_links, profile.user]
Executed rollback: src/main/resources/migrations/migration_4_add_data/rollback.sql
✓ Table verified empty after DELETE: profile.user_links
✓ Table verified empty after DELETE: profile.user
```

Schema After all migrations
```
mysql> desc user;
+---------+--------------+------+-----+---------+----------------+
| Field   | Type         | Null | Key | Default | Extra          |
+---------+--------------+------+-----+---------+----------------+
| id      | bigint       | NO   | PRI | NULL    | auto_increment |
| name    | varchar(255) | NO   |     | NULL    |                |
| email   | varchar(255) | NO   | UNI | NULL    |                |
| address | varchar(512) | YES  |     | NULL    |                |
| id_uuid | varchar(36)  | YES  |     | NULL    |                |
+---------+--------------+------+-----+---------+----------------+
5 rows in set (0.01 sec)

mysql> desc user_links;
+---------------+--------------+------+-----+---------+----------------+
| Field         | Type         | Null | Key | Default | Extra          |
+---------------+--------------+------+-----+---------+----------------+
| id            | bigint       | NO   | PRI | NULL    | auto_increment |
| user_id       | bigint       | NO   | MUL | NULL    |                |
| x_link        | varchar(255) | YES  |     | NULL    |                |
| facebook_link | varchar(255) | YES  |     | NULL    |                |
| youtube_link  | varchar(255) | YES  |     | NULL    |                |
| medium_link   | varchar(255) | YES  |     | NULL    |                |
| id_uuid       | varchar(36)  | YES  |     | NULL    |                |
+---------------+--------------+------+-----+---------+----------------+
7 rows in set (0.00 sec)
```

Data after all Migrations
```
mysql> select * from user;
+----+---------------+---------------------------+---------+--------------------------------------+
| id | name          | email                     | address | id_uuid                              |
+----+---------------+---------------------------+---------+--------------------------------------+
|  1 | John Doe      | john.doe@example.com      | NULL    | 0deac6c1-135a-11f0-907a-ead9ac162c53 |
|  2 | Jane Smith    | jane.smith@example.com    | NULL    | 0deaca03-135a-11f0-907a-ead9ac162c53 |
|  3 | David Johnson | david.johnson@example.com | NULL    | 0deacb0c-135a-11f0-907a-ead9ac162c53 |
|  4 | Emma Williams | emma.williams@example.com | NULL    | 0deacc1f-135a-11f0-907a-ead9ac162c53 |
|  5 | Michael Brown | michael.brown@example.com | NULL    | 0deaccb7-135a-11f0-907a-ead9ac162c53 |
|  6 | Olivia Jones  | olivia.jones@example.com  | NULL    | 0deacd11-135a-11f0-907a-ead9ac162c53 |
|  7 | William Davis | william.davis@example.com | NULL    | 0deacd63-135a-11f0-907a-ead9ac162c53 |
|  8 | Sophia Miller | sophia.miller@example.com | NULL    | 0deacdb6-135a-11f0-907a-ead9ac162c53 |
|  9 | James Wilson  | james.wilson@example.com  | NULL    | 0deace0f-135a-11f0-907a-ead9ac162c53 |
| 10 | Emily Taylor  | emily.taylor@example.com  | NULL    | 0deace62-135a-11f0-907a-ead9ac162c53 |
+----+---------------+---------------------------+---------+--------------------------------------+
10 rows in set (0.00 sec)

mysql> select * from user_links;
+----+---------+----------------------------+-----------------------------+----------------------------+----------------------------+--------------------------------------+
| id | user_id | x_link                     | facebook_link               | youtube_link               | medium_link                | id_uuid                              |
+----+---------+----------------------------+-----------------------------+----------------------------+----------------------------+--------------------------------------+
|  1 |       1 | https://twitter.com/user1  | https://facebook.com/user1  | https://youtube.com/user1  | https://medium.com/@user1  | 0deac6c1-135a-11f0-907a-ead9ac162c53 |
|  2 |       2 | https://twitter.com/user2  | https://facebook.com/user2  | https://youtube.com/user2  | https://medium.com/@user2  | 0deaca03-135a-11f0-907a-ead9ac162c53 |
|  3 |       3 | https://twitter.com/user3  | https://facebook.com/user3  | https://youtube.com/user3  | https://medium.com/@user3  | 0deacb0c-135a-11f0-907a-ead9ac162c53 |
|  4 |       4 | https://twitter.com/user4  | https://facebook.com/user4  | https://youtube.com/user4  | https://medium.com/@user4  | 0deacc1f-135a-11f0-907a-ead9ac162c53 |
|  5 |       5 | https://twitter.com/user5  | https://facebook.com/user5  | https://youtube.com/user5  | https://medium.com/@user5  | 0deaccb7-135a-11f0-907a-ead9ac162c53 |
|  6 |       6 | https://twitter.com/user6  | https://facebook.com/user6  | https://youtube.com/user6  | https://medium.com/@user6  | 0deacd11-135a-11f0-907a-ead9ac162c53 |
|  7 |       7 | https://twitter.com/user7  | https://facebook.com/user7  | https://youtube.com/user7  | https://medium.com/@user7  | 0deacd63-135a-11f0-907a-ead9ac162c53 |
|  8 |       8 | https://twitter.com/user8  | https://facebook.com/user8  | https://youtube.com/user8  | https://medium.com/@user8  | 0deacdb6-135a-11f0-907a-ead9ac162c53 |
|  9 |       9 | https://twitter.com/user9  | https://facebook.com/user9  | https://youtube.com/user9  | https://medium.com/@user9  | 0deace0f-135a-11f0-907a-ead9ac162c53 |
| 10 |      10 | https://twitter.com/user10 | https://facebook.com/user10 | https://youtube.com/user10 | https://medium.com/@user10 | 0deace62-135a-11f0-907a-ead9ac162c53 |
+----+---------+----------------------------+-----------------------------+----------------------------+----------------------------+--------------------------------------+
10 rows in set (0.00 sec)

mysql> SELECT u.name, ul.id_uuid, u.email FROM profile.user u  JOIN profile.user_links ul ON u.id = ul.user_id AND u.id_uuid = ul.id_uuid;
+---------------+--------------------------------------+---------------------------+
| name          | id_uuid                              | email                     |
+---------------+--------------------------------------+---------------------------+
| John Doe      | 0deac6c1-135a-11f0-907a-ead9ac162c53 | john.doe@example.com      |
| Jane Smith    | 0deaca03-135a-11f0-907a-ead9ac162c53 | jane.smith@example.com    |
| David Johnson | 0deacb0c-135a-11f0-907a-ead9ac162c53 | david.johnson@example.com |
| Emma Williams | 0deacc1f-135a-11f0-907a-ead9ac162c53 | emma.williams@example.com |
| Michael Brown | 0deaccb7-135a-11f0-907a-ead9ac162c53 | michael.brown@example.com |
| Olivia Jones  | 0deacd11-135a-11f0-907a-ead9ac162c53 | olivia.jones@example.com  |
| William Davis | 0deacd63-135a-11f0-907a-ead9ac162c53 | william.davis@example.com |
| Sophia Miller | 0deacdb6-135a-11f0-907a-ead9ac162c53 | sophia.miller@example.com |
| James Wilson  | 0deace0f-135a-11f0-907a-ead9ac162c53 | james.wilson@example.com  |
| Emily Taylor  | 0deace62-135a-11f0-907a-ead9ac162c53 | emily.taylor@example.com  |
+---------------+--------------------------------------+---------------------------+
10 rows in set (0.00 sec)

mysql>
```

### CLI run

```bash
./mvnw clean install package
java -jar target/liquid-unit-poc-1.0-SNAPSHOT.jar --mt
```

```
❯ java -jar target/liquid-unit-poc-1.0-SNAPSHOT.jar --mt

  _     _             _     _ _   _       _ _
 | |   (_)           (_)   | | | | |     (_) |
 | |    _  __ _ _   _ _  __| | | | |_ __  _| |_
 | |   | |/ _` | | | | |/ _` | | | | '_ \| | __|
 | |___| | (_| | |_| | | (_| | |_| | | | | | |_
 |_____|_|\__, |\__,_|_|\__,_|\___/|_| |_|_|\__|
             | |
             |_|

Database reset complete
abr. 06, 2025 9:48:32 PM liquibase.changelog
INFO: Creating database history table with name: profile.DATABASECHANGELOG
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Reading from profile.DATABASECHANGELOG
abr. 06, 2025 9:48:33 PM liquibase.lockservice
INFO: Successfully acquired change log lock
abr. 06, 2025 9:48:33 PM liquibase.command
INFO: Using deploymentId: 4001313427
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Reading from profile.DATABASECHANGELOG
Running Changeset: main/resources/migrations/migration_1_create_schema/migration.sql::diegopacheco:1::author
abr. 06, 2025 9:48:33 PM liquibase.executor
WARNING: Can't create database 'profile'; database exists
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_1_create_schema/migration.sql::diegopacheco:1::author ran successfully in 24ms
Running Changeset: main/resources/migrations/migration_1_create_schema/migration.sql::diegopacheco:2::author
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_1_create_schema/migration.sql::diegopacheco:2::author ran successfully in 35ms
Running Changeset: main/resources/migrations/migration_1_create_schema/migration.sql::diegopacheco:3::author
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_1_create_schema/migration.sql::diegopacheco:3::author ran successfully in 38ms

UPDATE SUMMARY
Run:                          3
Previously run:               0
Filtered out:                 0
-------------------------------
Total change sets:            3

abr. 06, 2025 9:48:33 PM liquibase.util
INFO: UPDATE SUMMARY
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Run:                          3
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Previously run:               0
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Filtered out:                 0
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: -------------------------------
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Total change sets:            3
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Update summary generated
abr. 06, 2025 9:48:33 PM liquibase.command
INFO: Update command completed successfully.
Liquibase: Update has been successful. Rows affected: 4
abr. 06, 2025 9:48:33 PM liquibase.lockservice
INFO: Successfully released change log lock
abr. 06, 2025 9:48:33 PM liquibase.command
INFO: Command execution complete
Executing tests from src/main/resources/migrations/migration_1_create_schema/test.sql
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name = 'profile' -> Expected: 1, Actual: 1
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'profile' AND table_name = 'user' -> Expected: 1, Actual: 1
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'profile' AND table_name = 'user_links' -> Expected: 1, Actual: 1
Found expectation (look-ahead): 4
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.columns WHERE table_schema = 'profile' AND table_name = 'user' AND column_name IN ('id', 'name', 'email', 'address') -> Expected: 4, Actual: 4
Found expectation (look-ahead): 5
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.columns WHERE table_schema = 'profile' AND table_name = 'user_links' AND column_name IN ('id', 'user_id', 'x_link', 'facebook_link', 'youtube_link') -> Expected: 5, Actual: 5
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.key_column_usage WHERE table_schema = 'profile' AND table_name = 'user_links' AND column_name = 'user_id' AND referenced_table_name = 'user' -> Expected: 1, Actual: 1
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Reading from profile.DATABASECHANGELOG
abr. 06, 2025 9:48:33 PM liquibase.lockservice
INFO: Successfully acquired change log lock
abr. 06, 2025 9:48:33 PM liquibase.command
INFO: Using deploymentId: 4001313693
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Reading from profile.DATABASECHANGELOG
Running Changeset: main/resources/migrations/migration_2_update_schema/migration.sql::diegopacheco:4::author
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_2_update_schema/migration.sql::diegopacheco:4::author ran successfully in 57ms

UPDATE SUMMARY
Run:                          1
Previously run:               0
Filtered out:                 0
-------------------------------
Total change sets:            1

abr. 06, 2025 9:48:33 PM liquibase.util
INFO: UPDATE SUMMARY
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Run:                          1
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Previously run:               0
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Filtered out:                 0
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: -------------------------------
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Total change sets:            1
abr. 06, 2025 9:48:33 PM liquibase.util
INFO: Update summary generated
abr. 06, 2025 9:48:33 PM liquibase.command
INFO: Update command completed successfully.
Liquibase: Update has been successful. Rows affected: 1
abr. 06, 2025 9:48:33 PM liquibase.lockservice
INFO: Successfully released change log lock
abr. 06, 2025 9:48:33 PM liquibase.command
INFO: Command execution complete
Executing tests from src/main/resources/migrations/migration_2_update_schema/test.sql
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.columns WHERE table_schema = 'profile' AND table_name = 'user_links' AND column_name = 'medium_link' -> Expected: 1, Actual: 1
Found expectation (look-ahead): 0
✓ Assertion passed: SELECT COUNT(*) FROM profile.user_links WHERE medium_link IS NULL -> Expected: 0, Actual: 0
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Reading from profile.DATABASECHANGELOG
abr. 06, 2025 9:48:33 PM liquibase.lockservice
INFO: Successfully acquired change log lock
abr. 06, 2025 9:48:33 PM liquibase.command
INFO: Using deploymentId: 4001313841
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Reading from profile.DATABASECHANGELOG
Running Changeset: main/resources/migrations/migration_3_update_id/migration.sql::diegopacheco:5::author
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_3_update_id/migration.sql::diegopacheco:5::author ran successfully in 54ms
Running Changeset: main/resources/migrations/migration_3_update_id/migration.sql::diegopacheco:6::author
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_3_update_id/migration.sql::diegopacheco:6::author ran successfully in 5ms
Running Changeset: main/resources/migrations/migration_3_update_id/migration.sql::diegopacheco:7::author
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_3_update_id/migration.sql::diegopacheco:7::author ran successfully in 53ms
Running Changeset: main/resources/migrations/migration_3_update_id/migration.sql::diegopacheco:8::author
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:33 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_3_update_id/migration.sql::diegopacheco:8::author ran successfully in 5ms

UPDATE SUMMARY
Run:                          4
Previously run:               0
Filtered out:                 0
-------------------------------
Total change sets:            4

abr. 06, 2025 9:48:34 PM liquibase.util
INFO: UPDATE SUMMARY
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Run:                          4
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Previously run:               0
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Filtered out:                 0
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: -------------------------------
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Total change sets:            4
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Update summary generated
abr. 06, 2025 9:48:34 PM liquibase.command
INFO: Update command completed successfully.
Liquibase: Update has been successful. Rows affected: 4
abr. 06, 2025 9:48:34 PM liquibase.lockservice
INFO: Successfully released change log lock
abr. 06, 2025 9:48:34 PM liquibase.command
INFO: Command execution complete
Executing tests from src/main/resources/migrations/migration_3_update_id/test.sql
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.columns WHERE table_schema = 'profile' AND table_name = 'user' AND column_name = 'id_uuid' -> Expected: 1, Actual: 1
Found expectation (look-ahead): 1
✓ Assertion passed: SELECT COUNT(*) FROM information_schema.columns WHERE table_schema = 'profile' AND table_name = 'user_links' AND column_name = 'id_uuid' -> Expected: 1, Actual: 1
Found expectation (look-ahead): 0
✓ Assertion passed: SELECT COUNT(*) FROM profile.user WHERE id_uuid IS NULL -> Expected: 0, Actual: 0
Found expectation (look-ahead): 0
✓ Assertion passed: SELECT COUNT(*) FROM profile.user_links WHERE id_uuid IS NULL -> Expected: 0, Actual: 0
abr. 06, 2025 9:48:34 PM liquibase.changelog
INFO: Reading from profile.DATABASECHANGELOG
abr. 06, 2025 9:48:34 PM liquibase.lockservice
INFO: Successfully acquired change log lock
abr. 06, 2025 9:48:34 PM liquibase.command
INFO: Using deploymentId: 4001314089
abr. 06, 2025 9:48:34 PM liquibase.changelog
INFO: Reading from profile.DATABASECHANGELOG
Running Changeset: main/resources/migrations/migration_4_add_data/migration.sql::diegopacheco:9::author
abr. 06, 2025 9:48:34 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:34 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_4_add_data/migration.sql::diegopacheco:9::author ran successfully in 11ms
Running Changeset: main/resources/migrations/migration_4_add_data/migration.sql::diegopacheco:10::author
abr. 06, 2025 9:48:34 PM liquibase.changelog
INFO: Custom SQL executed
abr. 06, 2025 9:48:34 PM liquibase.changelog
INFO: ChangeSet main/resources/migrations/migration_4_add_data/migration.sql::diegopacheco:10::author ran successfully in 9ms

UPDATE SUMMARY
Run:                          2
Previously run:               0
Filtered out:                 0
-------------------------------
Total change sets:            2

abr. 06, 2025 9:48:34 PM liquibase.util
INFO: UPDATE SUMMARY
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Run:                          2
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Previously run:               0
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Filtered out:                 0
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: -------------------------------
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Total change sets:            2
abr. 06, 2025 9:48:34 PM liquibase.util
INFO: Update summary generated
abr. 06, 2025 9:48:34 PM liquibase.command
INFO: Update command completed successfully.
Liquibase: Update has been successful. Rows affected: 22
abr. 06, 2025 9:48:34 PM liquibase.lockservice
INFO: Successfully released change log lock
abr. 06, 2025 9:48:34 PM liquibase.command
INFO: Command execution complete
Executing tests from src/main/resources/migrations/migration_4_add_data/test.sql
Found expectation (look-ahead): 10
✓ Assertion passed: SELECT COUNT(*) FROM profile.user -> Expected: 10, Actual: 10
Found expectation (look-ahead): 10
✓ Assertion passed: SELECT COUNT(*) FROM profile.user_links -> Expected: 10, Actual: 10
Found expectation (look-ahead): 0
✓ Assertion passed: SELECT COUNT(*) FROM profile.user WHERE id_uuid IS NULL -> Expected: 0, Actual: 0
Found expectation (look-ahead): 0
✓ Assertion passed: SELECT COUNT(*) FROM profile.user_links WHERE id_uuid IS NULL -> Expected: 0, Actual: 0
Found expectation (look-ahead): 10
✓ Assertion passed: SELECT COUNT(DISTINCT u.id) FROM profile.user u JOIN profile.user_links x ON u.id = x.user_id AND x.x_link IS NOT NULL JOIN profile.user_links fb ON u.id = fb.user_id AND fb.facebook_link IS NOT NULL JOIN profile.user_links yt ON u.id = yt.user_id AND yt.youtube_link IS NOT NULL JOIN profile.user_links md ON u.id = md.user_id AND md.medium_link IS NOT NULL -> Expected: 10, Actual: 10
Tests run: 4
Tests succeeded: 4
Tests failed: 0
✓ LiquidUnitTests completed successfully!
```

### TODO

1. Add more Patterns
2. Add more tests
3. Remove Duplicated Code

### AI Refactoring

Prompt 
```
could you refactor this file and create proper structure, proper architecture and desing,
make sure you do your best and make sure the structure is scalable and proper for decent
software engineering to mantain it over time. Do it for: LiquidUnitTests and LiquidUnitRollbackTests
```

Diego Pacheco Architecture/Design Review - Feedback on AI Refactor:

0. Great AI did all that in `15min`, the slow part of me copying the code.
1. At a "Glance" looks good, there is structure, multiple classes, but just in the surface, the design and architecture is pretty bad.
2. Good news the build pass when I run `mvn clean install`
3. I see AI created a class to extend the Tests and remove duplication between code/tests 
however just for 1 file `LiquidUnitTests`  - AI completely miss the other file which is `LiquidUnitRollbackTests`.
4. The most naive thing is that I had a main class and ai did not even touch it, so is my code that still running
AI did all this refactoring but ai code is not being called because is my old main class still (face plan)
5.The names of packages suck. `core` has nothing that is core, it has configs and database access code.
5. There is a package named `junit` which sucks because this is not junit this is an execution engine that uses junit, AI got this wrong.
6. There is a folder called `migrations` that one is not that bad, as name make sense.
7. There is another one called `cli` which has the main method there and that's not obvious. Maven will not read from there, AI did not told me to change my pom.xml
in Fact like I said, AI completely ignore the Main class I had and that still active. 
8. DatabaseConnector does very little, that class is very weak. AI never mentioned anything about connection pool or proper connection management in fact AI original code still uses DriverManager which sucks. 
9. LiquidUnitConfig has security anti-patterns, it has the `password` in clear text hardcoded in `2 places`.
10. LiquidUnitRollbackTests is not bad. This one good job.
11. LiquidUnitTests is not bad as well. This one good job.
12. MigrationExecutor AI is doing imports that are never use, this is wrong.
13. MigrationExecutor has database access code, AI is not doing proper SOC(Separation of Concerns) here. Wrong and BAD!
14. MigrationExecutor uses `FileSystemResourceAccessor` which is deprecated, wrong, AI did not even botter to update it.
15. MigrationExecutor AI did not get rid of all duplicated code, and methods pass parameters that are not necessary.
16. MigrationExecutor AI is doing `currentQuery.length() > 0` where it should be `!currentQuery.isEmpty()`
17. MigrationExecutor AI is doing lots of necessary else statements, code should be simplified AI did not simplify the code.
18. MigrationExecutor has SQL and DAO code here, and it should not be here again SOC.
19. LiquidUnitConfig is completely wrong, this class is not necessary, only DAO need this information.
20. DatabaseConnector is not even a proper Singleton, does not even properly prevent multiple connections to be opened.
21. CLI class has a `initilize` method that is not necessary, this should be removed. This is CORBA? Come on AI this is not even proper OOP. Objects have this little thing called constructors. 
22. NO Unit Tests - Where is Tests fot the Code AI?
22. No Integration Tests - Where is Tests fot the Code AI?
23. Overall is pretty bad - I would need spend hours again to fix this and make it decent. 