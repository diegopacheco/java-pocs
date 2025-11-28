## Related POCS

- [1. Java Pure Memory - Stock Engine](https://github.com/diegopacheco/java-pocs/tree/master/pocs/stock-matcher-engine)
- [2. Java 25, Kafka, Kafka-Streams](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-kafka-streams-windoning-eo-purchases)
- [3. Java 25, Kafka, KsqlDB](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-kafka-ksqldb-windoning-eo-purchases)
- [4. Java 25, RocksDB](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-rocksdb-windoning-eo-purchases)
- [5. Java 25, Redis and Redis Streams](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-redis-windoning-eo-purchases)
- [6. Java 21, Kafka, Flink](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-21-kafka-flink-windoning-eo-purchases)
- [7. Java 21, Kafka, Spark](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-21-kafka-spark-windoning-eo-purchases)
- [8. Rust 2024, Pure Memory - Stock Engine](https://github.com/diegopacheco/rust-playground/tree/master/in-memory-stock-engine)
- [9. Zig 0.15.1, Pure Memory - Stock Engine](https://github.com/diegopacheco/zig-playground/tree/master/in-memory-stock-engine)

## Rationale

This project demonstrates how to implement a purchase 
processing system using Spark with exactly-once 
semantics (EOS). It showcases how to handle duplicate 
purchase events gracefully, ensuring that each purchase is 
processed exactly once, even in the presence of retries or 
duplicate messages.

### Build

```bash
./mvnw clean install
```

### Run

```bash
./start.sh
./run.sh
```

### Endpoints

```
/generate/{count}/{id} -> Generate x purchases for user id
/duplicate/{count}/{id} -> Generate duplicated x purchases for user id
/total/{id} -> Get total purchases for user id
/history/{id} -> Get purchase history for a user if exists
```

### Exactly-Once Semantics Configuration

This application is configured for exactly-once semantics (EOS) to guarantee that each message is processed exactly once with no duplicates or data loss.

#### Purchase Deduplication

Each purchase has a unique `purchaseId` (UUID). Kafka Streams uses a stateful aggregation to deduplicate purchases.

**How it works:**

1. Each Purchase is assigned a unique UUID `purchaseId` when created
2. The stream is re-keyed by `purchaseId` (instead of `userId`)
3. Kafka Streams groups by `purchaseId` and uses `reduce((oldValue, newValue) -> oldValue)`
4. The reduce operation keeps only the **first occurrence** of each `purchaseId`
5. The stream is re-keyed back to `userId` for downstream processing (total debt, history)
6. The `purchase-dedup-store` maintains the materialized view of unique purchases

This ensures that even if the same purchase message is sent multiple times to Kafka (due to retries, duplicate API calls, etc.), it will only be counted once in the total debt calculation and appear once in the purchase history.

**Benefits:**

- No duplicate debt accumulation from the same purchase
- Idempotent purchase processing regardless of message retries
- Protection against accidental duplicate API calls
- Leverages Kafka Streams native deduplication with exactly-once guarantees

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

#### Kafka Streams Configuration

```properties
spring.kafka.streams.properties.processing.guarantee=exactly_once_v2
spring.kafka.streams.properties.replication.factor=1
spring.kafka.streams.properties.num.standby.replicas=0
```

**processing.guarantee=exactly_once_v2**: Enables exactly-once semantics v2 for Kafka Streams, which uses transactions to guarantee exactly-once processing.

**replication.factor=1**: Set to 1 for single broker setup. Use 3+ in production.

**num.standby.replicas=0**: No standby replicas for single broker. Use 1+ in production for fault tolerance.

#### How It Works

1. **Idempotent Producer**: Prevents duplicate messages on retry by assigning sequence numbers to each message batch.

2. **Transactional Writes**: Producer commits messages atomically across multiple partitions using transactions.

3. **Kafka Streams EOS v2**: Uses transactions to atomically read from input topics, process, update state stores, and write to output topics.

4. **Read Committed Consumer**: Only reads messages that have been successfully committed in a transaction.

#### Tradeoffs

**Benefits**: No duplicate processing, no data loss, atomic updates across topics and state stores.

**Costs**: Slightly higher latency, lower throughput, increased disk usage for transaction logs.

#### Production Considerations

For production environments, update these settings:

```properties
spring.kafka.streams.properties.replication.factor=3
spring.kafka.streams.properties.num.standby.replicas=1
```

And ensure Kafka brokers have:
- `transaction.state.log.replication.factor=3`
- `transaction.state.log.min.isr=2`
