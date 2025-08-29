# MySQL 9.0 Partition Options

This document outlines all available partitioning options in MySQL 9.0.1.

## Verified Environment
- **MySQL Version**: 9.0.1
- **Storage Engines**: InnoDB (Default), MyISAM, MEMORY, CSV, ARCHIVE
- **Partitioning Support**: Enabled

## Partition Types

### 1. RANGE Partitioning
Partitions based on column values falling within given ranges.

```sql
CREATE TABLE sales (
    id INT,
    sale_date DATE,
    amount DECIMAL(10,2)
) PARTITION BY RANGE (YEAR(sale_date)) (
    PARTITION p2020 VALUES LESS THAN (2021),
    PARTITION p2021 VALUES LESS THAN (2022),
    PARTITION p2022 VALUES LESS THAN (2023),
    PARTITION p2023 VALUES LESS THAN (2024),
    PARTITION p_future VALUES LESS THAN MAXVALUE
);
```

### 2. LIST Partitioning
Partitions based on discrete column values.

```sql
CREATE TABLE customers (
    id INT,
    country VARCHAR(20)
) PARTITION BY LIST (country) (
    PARTITION p_north_america VALUES IN ('USA', 'Canada', 'Mexico'),
    PARTITION p_europe VALUES IN ('Germany', 'France', 'UK'),
    PARTITION p_asia VALUES IN ('Japan', 'China', 'India')
);
```

### 3. HASH Partitioning
Automatically distributes data across partitions using hash function.

```sql
CREATE TABLE products (
    id INT,
    name VARCHAR(100),
    price DECIMAL(10,2)
) PARTITION BY HASH(id) PARTITIONS 4;
```

### 4. KEY Partitioning
Similar to HASH but uses MySQL's internal hash function.

```sql
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE
) PARTITION BY KEY(order_id) PARTITIONS 8;
```

### 5. RANGE COLUMNS Partitioning
RANGE partitioning with multiple columns or non-integer types.

```sql
CREATE TABLE events (
    id INT,
    event_date DATE,
    location VARCHAR(50)
) PARTITION BY RANGE COLUMNS(event_date, location) (
    PARTITION p1 VALUES LESS THAN ('2023-01-01', 'M'),
    PARTITION p2 VALUES LESS THAN ('2023-06-01', 'M'),
    PARTITION p3 VALUES LESS THAN ('2024-01-01', 'Z'),
    PARTITION p4 VALUES LESS THAN (MAXVALUE, MAXVALUE)
);
```

### 6. LIST COLUMNS Partitioning
LIST partitioning with multiple columns or non-integer types.

```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    activated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    name_first_char VARCHAR(1) GENERATED ALWAYS AS (LEFT(UPPER(name), 1)) STORED,
    PRIMARY KEY (id, name_first_char),
    UNIQUE KEY unique_email (email, name_first_char),
    KEY idx_name (name)
) ENGINE=InnoDB
PARTITION BY LIST COLUMNS(name_first_char) (
    PARTITION p_a_c VALUES IN ('A','B','C'),
    PARTITION p_d_f VALUES IN ('D','E','F'),
    PARTITION p_g_i VALUES IN ('G','H','I'),
    PARTITION p_j_l VALUES IN ('J','K','L'),
    PARTITION p_m_o VALUES IN ('M','N','O'),
    PARTITION p_p_r VALUES IN ('P','Q','R'),
    PARTITION p_s_u VALUES IN ('S','T','U'),
    PARTITION p_v_z VALUES IN ('V','W','X','Y','Z'),
    PARTITION p_other VALUES IN ('0','1','2','3','4','5','6','7','8','9')
);
```

## Subpartitioning

MySQL 9 supports subpartitioning (composite partitioning) where you can combine RANGE/LIST with HASH/KEY.

```sql
CREATE TABLE sales_data (
    id INT,
    sale_date DATE,
    region VARCHAR(20),
    amount DECIMAL(10,2)
) PARTITION BY RANGE (YEAR(sale_date))
SUBPARTITION BY HASH (region) SUBPARTITIONS 2 (
    PARTITION p2022 VALUES LESS THAN (2023),
    PARTITION p2023 VALUES LESS THAN (2024),
    PARTITION p_future VALUES LESS THAN MAXVALUE
);
```

## Partition Functions (MySQL 9)

### Supported Functions for RANGE and LIST
- `ABS()`
- `CEILING()` and `CEIL()`
- `DATEDIFF()`
- `DAY()`
- `DAYOFMONTH()`
- `DAYOFWEEK()`
- `DAYOFYEAR()`
- `EXTRACT()` (with units: YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, MICROSECOND, QUARTER, WEEK)
- `FLOOR()`
- `HOUR()`
- `MICROSECOND()`
- `MINUTE()`
- `MOD()`
- `MONTH()`
- `QUARTER()`
- `SECOND()`
- `TIME_TO_SEC()`
- `TO_DAYS()`
- `TO_SECONDS()`
- `UNIX_TIMESTAMP()` (with TIMESTAMP columns)
- `WEEKDAY()`
- `YEAR()`
- `YEARWEEK()`

### MySQL 9 Enhancements
- **Generated Columns**: Full support for partitioning on generated columns
- **JSON Functions**: Limited support for JSON extract functions in partitioning
- **Improved Performance**: Better partition pruning algorithms
- **Window Functions**: Enhanced compatibility with window functions over partitioned tables

## Storage Engine Support

### InnoDB (Recommended)
- **Full Support**: All partition types supported
- **Transactions**: Full ACID compliance across partitions
- **Foreign Keys**: Limited support (within same partition)
- **Performance**: Excellent with partition pruning

### MyISAM
- **Full Support**: All partition types supported
- **No Transactions**: Non-transactional storage
- **Table Locking**: Less concurrency than InnoDB

### Memory
- **Limited Support**: HASH and KEY partitioning only
- **Volatile**: Data lost on restart
- **Performance**: Very fast for temporary data

### Archive
- **Limited Support**: Basic partitioning support
- **Compression**: High compression ratios
- **Insert Only**: No UPDATE or DELETE operations

## Partitioning Limitations in MySQL 9

### General Limitations
1. **Maximum Partitions**: 8192 partitions per table
2. **Foreign Keys**: Limited cross-partition foreign key support
3. **Fulltext Indexes**: Not supported on partitioned tables
4. **Spatial Columns**: Limited support for spatial data types
5. **Triggers**: Each partition can have separate triggers

### Function Limitations
- **User-Defined Functions**: Not allowed in partition expressions
- **Stored Functions**: Not allowed in partition expressions
- **Complex Expressions**: Limited to supported function list

### Key Requirements
- **Unique Keys**: Must include all partition columns
- **Primary Keys**: Must include all partition columns
- **Auto-Increment**: Special handling required

## Partition Management Commands

### Add Partition
```sql
ALTER TABLE table_name ADD PARTITION (
    PARTITION partition_name VALUES LESS THAN (value)
);
```

### Drop Partition
```sql
ALTER TABLE table_name DROP PARTITION partition_name;
```

### Reorganize Partition
```sql
ALTER TABLE table_name REORGANIZE PARTITION partition_name INTO (
    PARTITION new_partition1 VALUES LESS THAN (value1),
    PARTITION new_partition2 VALUES LESS THAN (value2)
);
```

### Analyze Partition
```sql
ALTER TABLE table_name ANALYZE PARTITION partition_name;
```

### Check Partition
```sql
ALTER TABLE table_name CHECK PARTITION partition_name;
```

### Optimize Partition
```sql
ALTER TABLE table_name OPTIMIZE PARTITION partition_name;
```

### Repair Partition
```sql
ALTER TABLE table_name REPAIR PARTITION partition_name;
```

### Truncate Partition
```sql
ALTER TABLE table_name TRUNCATE PARTITION partition_name;
```

## Information Schema Views

### PARTITIONS Table
```sql
SELECT 
    TABLE_NAME,
    PARTITION_NAME,
    PARTITION_METHOD,
    PARTITION_EXPRESSION,
    PARTITION_DESCRIPTION,
    TABLE_ROWS,
    DATA_LENGTH
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_SCHEMA = 'database_name';
```

### Partition Statistics
```sql
SELECT 
    PARTITION_NAME,
    TABLE_ROWS,
    AVG_ROW_LENGTH,
    DATA_LENGTH,
    INDEX_LENGTH
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_SCHEMA = 'database_name'
  AND TABLE_NAME = 'table_name'
  AND PARTITION_NAME IS NOT NULL;
```

## Performance Considerations

### Partition Pruning
- **Automatic**: MySQL automatically eliminates unnecessary partitions
- **WHERE Clauses**: Use partition key in WHERE clauses for optimal performance
- **EXPLAIN**: Use EXPLAIN to verify partition pruning

### Best Practices
1. **Partition Key Selection**: Choose columns frequently used in WHERE clauses
2. **Partition Size**: Keep partitions reasonably sized (not too small, not too large)
3. **Maintenance**: Regular maintenance of partitions (ANALYZE, OPTIMIZE)
4. **Monitoring**: Monitor partition statistics and query performance

## MySQL 9 New Features

### Enhanced JSON Support
- Better JSON function support in partition expressions
- Improved performance for JSON-heavy workloads

### Improved Partition Pruning
- More sophisticated partition elimination algorithms
- Better performance with complex queries

### Generated Column Integration
- Seamless integration with generated columns
- Virtual columns can be used in partition expressions (stored columns recommended)

### Performance Schema Integration
- Better monitoring of partition-related operations
- Enhanced metrics for partition performance tuning

This document represents the comprehensive partitioning capabilities available in MySQL 9.0.1.