# MySQL Partitioning Evidence

This document provides evidence that the MySQL table partitioning is working correctly.

## Tech Stack

- **Java**: 23
- **Spring Boot**: 3.5.5 
- **MySQL**: 9.0.1
- **Spring Data JDBC**: Latest
- **Docker**: Multi-stage build with Java 23

## Table Structure with Partitioning

The `users` table is partitioned by the first letter of the user's name using a generated column:

```sql
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `activated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `name_first_char` varchar(1) COLLATE utf8mb4_unicode_ci GENERATED ALWAYS AS (left(upper(`name`),1)) STORED NOT NULL,
  PRIMARY KEY (`id`,`name_first_char`),
  UNIQUE KEY `unique_email` (`email`,`name_first_char`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
PARTITION BY LIST  COLUMNS(name_first_char)
(PARTITION p_a_c VALUES IN ('A','B','C') ENGINE = InnoDB,
 PARTITION p_d_f VALUES IN ('D','E','F') ENGINE = InnoDB,
 PARTITION p_g_i VALUES IN ('G','H','I') ENGINE = InnoDB,
 PARTITION p_j_l VALUES IN ('J','K','L') ENGINE = InnoDB,
 PARTITION p_m_o VALUES IN ('M','N','O') ENGINE = InnoDB,
 PARTITION p_p_r VALUES IN ('P','Q','R') ENGINE = InnoDB,
 PARTITION p_s_u VALUES IN ('S','T','U') ENGINE = InnoDB,
 PARTITION p_v_z VALUES IN ('V','W','X','Y','Z') ENGINE = InnoDB,
 PARTITION p_other VALUES IN ('0','1','2','3','4','5','6','7','8','9') ENGINE = InnoDB)
```

## Partition Distribution

The data is distributed across partitions based on the first letter of names:

- **p_a_c**: Contains users with names starting with A, B, C (3 rows)
- **p_d_f**: Contains users with names starting with D, E, F (1 row - Diego)
- Other partitions contain users with names starting with other letters

## Testing Commands

### Check partition information:
```bash
docker exec mysql-partition mysql -uroot -prootpassword -e "USE partitiondb; SELECT TABLE_NAME, PARTITION_NAME, PARTITION_EXPRESSION, PARTITION_DESCRIPTION, TABLE_ROWS FROM information_schema.PARTITIONS WHERE TABLE_SCHEMA='partitiondb' AND TABLE_NAME='users' AND TABLE_ROWS > 0 ORDER BY PARTITION_ORDINAL_POSITION;"
```

### Query users from specific partition:
```bash
docker exec mysql-partition mysql -uroot -prootpassword -e "USE partitiondb; SELECT name, name_first_char FROM users WHERE name_first_char = 'D';"
```

### Show query execution plan (partition pruning):
```bash
docker exec mysql-partition mysql -uroot -prootpassword -e "USE partitiondb; EXPLAIN SELECT * FROM users WHERE name = 'Diego';"
```

## API Endpoints

The Spring Boot application provides these REST endpoints:

- `GET /api/users` - Get all users
- `POST /api/users` - Create new user
- `GET /api/users/{id}` - Get user by ID
- `GET /api/users/email/{email}` - Get user by email
- `GET /api/users/name/{namePrefix}` - Get users by name prefix
- `DELETE /api/users/{id}` - Delete user

## Verification Steps

1. **Start the application**: `docker-compose up -d`
2. **Check table structure**: The table shows partitioning in SHOW CREATE TABLE output
3. **Verify data distribution**: Query partition statistics to see data across partitions
4. **Test API**: Insert/retrieve users via REST API
5. **Confirm partitioning**: Use EXPLAIN to see partition pruning in action