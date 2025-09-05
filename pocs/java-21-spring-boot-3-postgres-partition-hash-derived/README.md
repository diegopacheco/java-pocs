# Postgres Partitioning - Hash Derived

Postgres: 17

## Hash / Derived Partitioning - Expression-Based (with consistent hashing)

1. The Master Table Declaration
```sql
  CREATE TABLE IF NOT EXISTS users (
      id BIGSERIAL,
      name VARCHAR(100) NOT NULL,
      email VARCHAR(150) NOT NULL,
      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ) PARTITION BY HASH (hashtext(left(name, 1)));
```

Breaking down the partitioning expression:
- left(name, 1) - Extracts the first character from the name field
- hashtext(...) - PostgreSQL's built-in function that converts the character to a hash value
- PARTITION BY HASH (...) - Tells PostgreSQL to use hash partitioning on this expression

2. The Partition Logic Flow

When you insert INSERT INTO users (name, email) VALUES ('Alice Johnson', 'alice@example.com'):

1. Extract first letter: left('Alice Johnson', 1) → 'A'
2. Hash the letter: hashtext('A') → some integer (e.g., 1234567890)
3. Apply modulus: 1234567890 % 27 → remainder (e.g., 15)
4. Route to partition: PostgreSQL automatically routes to users_p15

3. The Physical Partitions
```sql
CREATE TABLE IF NOT EXISTS users_p0 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 0);
CREATE TABLE IF NOT EXISTS users_p1 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 1);
-- ... up to users_p26
```
What this means:
- MODULUS 27 - The hash space is divided by 27
- REMAINDER 0 - This partition holds all rows where hashtext(left(name, 1)) % 27 = 0
- REMAINDER 1 - This partition holds all rows where hashtext(left(name, 1)) % 27 = 1
- And so on...

This approach:
- **Zero application code changes** needed for partitioning logic
- **Completely transparent** to JPA/Hibernate and application layers
- **No dedicated partition columns** cluttering your entity models
- **Database-level automatic routing** for all INSERT/UPDATE/SELECT operations
- **Maintains 27 partitions** as requested
- **Consistent distribution** based on first letter of names

## Limitations

- **No UNIQUE constraints** can be used with expression-based partitioning
- **Queries filtering by first letter** of name will be most efficient
- **Cross-partition queries** may be slower for some operations

## Impact

Real-World Impact:

With 1 million users:
- Each partition: ~37,000 records (1M ÷ 27, assuming even distribution)
- **Query by first letter of name**: PostgreSQL automatically searches only 1 partition instead of all 27
- **Query by full name**: Still benefits from partition pruning if PostgreSQL can determine the first letter
- **Performance gain**: Up to 27x faster for name-based queries that can leverage partition pruning
- **Distribution quality**: Depends on first-letter distribution in your dataset (English names favor A, B, C, J, M, S)

## Benefits

* **Scales horizontally**: Each partition can be on different tablespaces/disks
* **Completely transparent**: Zero application code changes needed
* **Maintenance friendly**: Indexes, vacuuming, and statistics per partition
* **Query optimization**: PostgreSQL automatically prunes irrelevant partitions
* **No application coupling**: Database schema changes don't affect application logic

## Key Findings

```sql
EXPLAIN ANALYZE SELECT * FROM users WHERE name = 'Alice Johnson';
```
(cost=0.14..220.52 rows=27 width=552) (actual time=0.238..0.428 rows=1 loops=1)

The query plan shows PostgreSQL is checking ALL partitions, not just one. This indicates that PostgreSQL's planner couldn't determine which partition to use for the literal string 'Alice Johnson' at planning time.

The results reveal an important nuance about PostgreSQL's partition pruning with expression-based partitioning:

1. Partition Pruning Limitations

PostgreSQL's planner is conservative with expression-based partitioning. It can only prune partitions when:
- The WHERE clause matches exactly the partition expression
- The values are known at planning time

-- ✅ GOOD: Matches partition expression exactly
```sql
WHERE hashtext(left(name, 1)) = hashtext('A')  -- Only searches users_p12
```

-- ❌ SUBOPTIMAL: Doesn't match partition expression
```sql
WHERE name = 'Alice Johnson'                    -- Searches all 27 partitions
WHERE left(name, 1) = 'A'                      -- Searches all 27 partitions
```

2. Performance Penalty Analysis

Based on the actual measurements:

Best Case (Perfect Pruning):
- Planning: 0.494ms
- Execution: 0.022ms
- Total: 0.516ms (searches 1 partition)

Worst Case (No Pruning):
- Planning: 4.433ms
- Execution: 0.703ms
- Total: 5.136ms (searches all 27 partitions)


## Build

```bash
./mvnw clean install
```
