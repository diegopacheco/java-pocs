### Build

```bash
mvn clean package
```

### Run

```bash
./start.sh
./init-ksql.sh
mvn spring-boot:run
```

Or use the combined script:
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

### Technology Stack

This application uses **ksqlDB** instead of Kafka Streams for stream processing. ksqlDB provides:
- SQL-based stream processing
- Built-in state stores
- Exactly-once semantics
- Materialized views via tables

### Exactly-Once Semantics Configuration

This application is configured for exactly-once semantics (EOS) to guarantee that each message is processed exactly once with no duplicates or data loss.

#### Purchase Deduplication

Each purchase has a unique `purchaseId` (UUID). ksqlDB uses a table with primary key to deduplicate purchases.

**How it works:**

1. Each Purchase is assigned a unique UUID `purchaseId` when created
2. `PURCHASES_STREAM` reads from the Kafka topic with `purchaseId` as the key
3. `PURCHASES_DEDUP` table groups by `purchaseId` and uses `LATEST_BY_OFFSET()`
4. The table keeps only the **latest occurrence** of each `purchaseId`
5. `USER_TOTAL_DEBT` and `USER_PURCHASE_HISTORY` tables aggregate from the deduped table
6. ksqlDB maintains materialized views that can be queried via pull queries

This ensures that even if the same purchase message is sent multiple times to Kafka (due to retries, duplicate API calls, etc.), it will only be counted once in the total debt calculation and appear once in the purchase history.

**Benefits:**

- No duplicate debt accumulation from the same purchase
- Idempotent purchase processing regardless of message retries
- Protection against accidental duplicate API calls
- Leverages ksqlDB native deduplication with exactly-once guarantees

#### Producer Configuration

```properties
spring.kafka.producer.acks=all
spring.kafka.producer.properties.enable.idempotence=true
spring.kafka.producer.properties.max.in.flight.requests.per.connection=5
spring.kafka.producer.properties.retries=2147483647
spring.kafka.producer.transaction-id-prefix=purchase-tx-
```

**acks=all**: All in-sync replicas must acknowledge the write before it is considered successful.

**enable.idempotence=true**: Producer will ensure that exactly one copy of each message is written to the stream, even with retries.

**max.in.flight.requests.per.connection=5**: Maximum number of unacknowledged requests per connection. Works with idempotence.

**retries=MAX_VALUE**: Producer will retry indefinitely on transient failures.

**transaction-id-prefix**: Enables transactional writes for atomic multi-partition writes.

#### Consumer Configuration

```properties
spring.kafka.consumer.isolation-level=read_committed
```

**isolation-level=read_committed**: Consumer will only read committed messages, ignoring uncommitted transactional messages.

#### ksqlDB Configuration

ksqlDB is configured in `podman-compose.yml`:

```yaml
KSQL_PROCESSING_GUARANTEE: exactly_once_v2
KSQL_KSQL_STREAMS_REPLICATION_FACTOR: 1
KSQL_KSQL_INTERNAL_TOPIC_REPLICAS: 1
```

**KSQL_PROCESSING_GUARANTEE=exactly_once_v2**: Enables exactly-once semantics v2 for ksqlDB, which uses transactions to guarantee exactly-once processing.

**KSQL_KSQL_STREAMS_REPLICATION_FACTOR=1**: Set to 1 for single broker setup. Use 3+ in production.

**KSQL_KSQL_INTERNAL_TOPIC_REPLICAS=1**: Internal topic replicas for single broker. Use 3+ in production for fault tolerance.

#### How It Works

1. **Idempotent Producer**: Prevents duplicate messages on retry by assigning sequence numbers to each message batch.

2. **Transactional Writes**: Producer commits messages atomically across multiple partitions using transactions.

3. **ksqlDB EOS v2**: Uses transactions to atomically read from input topics, process, update materialized tables, and write to output topics.

4. **Read Committed Consumer**: Only reads messages that have been successfully committed in a transaction.

#### Tradeoffs

**Benefits**: No duplicate processing, no data loss, atomic updates across topics and state stores.

**Costs**: Slightly higher latency, lower throughput, increased disk usage for transaction logs.

#### Production Considerations

For production environments, update ksqlDB settings in `podman-compose.yml`:

```yaml
KSQL_KSQL_STREAMS_REPLICATION_FACTOR: 3
KSQL_KSQL_INTERNAL_TOPIC_REPLICAS: 3
KSQL_KSQL_SINK_REPLICAS: 3
```

And ensure Kafka brokers have:
- `transaction.state.log.replication.factor=3`
- `transaction.state.log.min.isr=2`

### ksqlDB Schema

The application uses the following ksqlDB objects defined in `init-ksqldb.sql`:

```sql
PURCHASES_STREAM        - Source stream from Kafka purchases topic
PURCHASES_DEDUP         - Table that deduplicates by purchaseId
USER_TOTAL_DEBT         - Table with SUM(total) aggregated by userId
USER_PURCHASE_HISTORY   - Table with COLLECT_LIST(purchases) by userId
```

These are created automatically by running `./init-ksql.sh` after starting the containers.