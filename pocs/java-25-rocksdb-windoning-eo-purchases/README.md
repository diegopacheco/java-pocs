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

This application uses embedded RocksDB for local persistence with exactly-once semantics for purchase deduplication and aggregation.

#### Architecture

The application uses three separate RocksDB databases:

1. **Deduplication Database**: Stores unique purchases by purchaseId
2. **Total Debt Database**: Maintains running totals per userId
3. **History Database**: Keeps the last 20 purchases per userId

#### Purchase Deduplication

Each purchase has a unique `purchaseId` (UUID). RocksDB is used to ensure idempotent processing.

**How it works:**

1. Each Purchase is assigned a unique UUID `purchaseId` when created
2. Before processing, check if `purchaseId` exists in the dedup database
3. If exists, skip processing (duplicate detected)
4. If not exists, store in dedup database and process
5. Processing updates both total debt and history databases atomically

This ensures that even if the same purchase is submitted multiple times (due to retries or duplicate API calls), it will only be counted once in the total debt calculation and appear once in the purchase history.

**Benefits:**

- No duplicate debt accumulation from the same purchase
- Idempotent purchase processing regardless of retries
- Protection against accidental duplicate API calls
- Embedded database with no external dependencies
- Fast local reads and writes

#### RocksDB Configuration

```properties
rocksdb.data.path=./rocksdb-data
```

**rocksdb.data.path**: Directory where RocksDB stores its data files. Three subdirectories are created:
- `dedup/`: Purchase deduplication store
- `total-debt/`: User total debt aggregation
- `history/`: User purchase history (last 20 purchases)

#### Database Operations

**Write Operations:**
- Atomic write to deduplication store
- Atomic write to total debt store (read-modify-write)
- Atomic write to history store (read-modify-write with windowing)

**Read Operations:**
- Total debt: Direct key-value lookup by userId
- Purchase history: Direct key-value lookup by userId returning JSON array

#### Implementation Details

**PurchaseStorage**: Handles deduplication check and delegates to processor
**PurchaseProcessor**: Updates total debt and history atomically
**RocksDBConfig**: Creates and manages three separate RocksDB instances

#### Exactly-Once Guarantees

RocksDB provides exactly-once semantics through:

1. **Deduplication**: Check-before-write pattern prevents duplicate processing
2. **Atomic Operations**: Each database operation is atomic
3. **Synchronous Writes**: All writes are committed immediately
4. **No Network Failures**: Embedded database eliminates network partition issues

#### Production Considerations

For production environments:

1. **Backup Strategy**: Implement periodic snapshots of RocksDB data directory
2. **Monitoring**: Add metrics for database size and operation latency
3. **Compaction**: Configure RocksDB compaction settings for optimal performance
4. **Persistence**: Mount rocksdb-data directory on persistent storage