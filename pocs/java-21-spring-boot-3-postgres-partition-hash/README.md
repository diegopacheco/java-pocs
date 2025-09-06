# Postgres Partitioning - Hash

Postgres: 17

## Hash Transparency (ala consistent hashing)

Hash Distribution Algorithm:
Partition = hash(id) % 27
Examples:
- id = 1  → hash(1) % 27 = 17 → users_p17
- id = 5  → hash(5) % 27 = 5  → users_p5
- id = 16 → hash(16) % 27 = 3 → users_p3

Each partition stores records where hash(id) % 27 = remainder

## Impact

Real-World Impact:

With 1 million users:
- Each partition: ~37,000 records (1M ÷ 27)
- Query by ID: Searches only 37K records vs 1M
- Performance gain: 27x faster for ID-based queries

## Benefits

* Scales
* Transparent for application
* Refactoring resistant to some degree
* No penalty for queries by id

## Build

```bash
./mvnw clean install
```
