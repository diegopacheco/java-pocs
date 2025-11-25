## Related POCS

- [1. Java Pure Memory - Stock Engine](https://github.com/diegopacheco/java-pocs/tree/master/pocs/stock-matcher-engine)
- [2. Java 25, Kafka, Kafka-Streams](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-kafka-streams-windoning-eo-purchases)
- [3. Java 25, Kafka, KsqlDB](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-kafka-ksqldb-windoning-eo-purchases)
- [4. Java 25, RocksDB](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-rocksdb-windoning-eo-purchases)
- [5. Java 25, Redis and Redis Streams](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-redis-windoning-eo-purchases)

## Rationale

This project demonstrates how to implement a purchase 
processing system using RocksDB with exactly-once 
semantics (EOS). It showcases how to handle duplicate 
purchase events gracefully, ensuring that each purchase is 
processed exactly once, even in the presence of retries or 
duplicate messages.

### Build

```bash
mvn clean install
```

### Run

```bash
./run.sh
```

### Endpoints

```
/generate/{count}/{id} -> Generate x purchases for user id
/duplicate/{count}/{id} -> Generate duplicated x purchases for user id
/total/{id} -> Get total purchases for user id
/history/{id} -> Get purchase history for a user if exists
```

### RocksDB Embedded Implementation

This application uses embedded RocksDB with **TransactionDB** for local persistence with true exactly-once semantics for purchase deduplication and aggregation.

#### Architecture

The application uses a single TransactionDB with three column families:

1. **Deduplication Column Family**: Stores unique purchases by purchaseId
2. **Total Debt Column Family**: Maintains running totals per userId
3. **History Column Family**: Keeps the last 20 purchases per userId

#### Purchase Deduplication

Each purchase has a unique `purchaseId` (UUID). RocksDB is used to ensure idempotent processing.

**How it works:**

1. Each Purchase is assigned a unique UUID `purchaseId` when created
2. Begin RocksDB transaction with sync writes enabled
3. Check if `purchaseId` exists in dedup column family
4. If exists, rollback transaction (duplicate detected)
5. If not exists, within the SAME transaction:
   - Write to dedup column family
   - Update total debt in total-debt column family
   - Update history in history column family
6. Commit transaction atomically

This ensures that even if the same purchase is submitted multiple times (due to retries or duplicate API calls), it will only be counted once in the total debt calculation and appear once in the purchase history. All writes happen atomically or not at all.

**Benefits:**

- No duplicate debt accumulation from the same purchase
- Idempotent purchase processing regardless of retries
- Protection against accidental duplicate API calls
- Embedded database with no external dependencies
- Fast local reads and writes
- **True ACID transactions** across all operations
- **No race conditions** - all operations are atomic

#### RocksDB Configuration

```properties
rocksdb.data.path=./rocksdb-data
```

**rocksdb.data.path**: Directory where RocksDB stores its data files. A single transactional database with three column families:
- `dedup`: Purchase deduplication store
- `total-debt`: User total debt aggregation
- `history`: User purchase history (last 20 purchases)

#### Database Operations

**Write Operations (Single ACID Transaction):**
1. Begin transaction with sync writes
2. Check deduplication column family
3. Write to deduplication column family
4. Read-modify-write total debt column family
5. Read-modify-write history column family (with windowing)
6. Commit transaction atomically

**Read Operations:**
- Total debt: Direct key-value lookup by userId from total-debt column family
- Purchase history: Direct key-value lookup by userId from history column family

#### Implementation Details

**PurchaseStorage**: Handles all transactional operations - deduplication, total debt aggregation, and history updates in a single ACID transaction
**PurchaseProcessor**: Delegates to PurchaseStorage for reads
**RocksDBConfig**: Creates and manages TransactionDB with three column families

#### Exactly-Once Guarantees

RocksDB TransactionDB provides true exactly-once semantics through:

1. **ACID Transactions**: All operations (dedup check, total update, history update) happen atomically within a single transaction
2. **Optimistic Concurrency Control**: Transactions use optimistic locking to prevent conflicts
3. **Synchronous Writes**: Transactions commit with sync=true for durability
4. **Rollback on Duplicates**: If duplicate detected, entire transaction rolls back
5. **No Race Conditions**: Check-and-write happens atomically - impossible for two concurrent requests with same purchaseId to both commit
6. **No Network Failures**: Embedded database eliminates network partition issues
7. **Write-Ahead Log (WAL)**: Ensures durability even on crashes

#### Production Considerations

For production environments:

1. **Backup Strategy**: Implement periodic snapshots of RocksDB data directory
2. **Monitoring**: Add metrics for database size and operation latency
3. **Compaction**: Configure RocksDB compaction settings for optimal performance
4. **Persistence**: Mount rocksdb-data directory on persistent storage
