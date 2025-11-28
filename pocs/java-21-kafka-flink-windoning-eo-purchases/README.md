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
processing system using Apache Flink with exactly-once
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

Each purchase has a unique `purchaseId` (UUID). Apache Flink uses stateful processing with keyed state to deduplicate purchases.

**How it works:**

1. Each Purchase is assigned a unique UUID `purchaseId` when created
2. The stream is keyed by `purchaseId`
3. Flink uses MapState to track seen purchase IDs
4. The DeduplicationFunction keeps only the **first occurrence** of each `purchaseId`
5. The stream is then re-keyed by `userId` for downstream processing (total debt, history)
6. Flink state backends maintain the materialized view of unique purchases

This ensures that even if the same purchase message is sent multiple times to Kafka (due to retries, duplicate API calls, etc.), it will only be counted once in the total debt calculation and appear once in the purchase history.

**Benefits:**

- No duplicate debt accumulation from the same purchase
- Idempotent purchase processing regardless of message retries
- Protection against accidental duplicate API calls
- Leverages Flink checkpointing with exactly-once guarantees

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

#### Flink Configuration

Flink provides exactly-once semantics through checkpointing and state management:

**Checkpointing**: Enabled with 5 second intervals to periodically save the state of the stream processing.

**State Backend**: Flink uses managed keyed state (MapState, ValueState) to maintain deduplication and aggregation state.

**Kafka Source**: Configured to start from earliest offset for complete data processing.

**Fault Tolerance**: Flink can restore from the last successful checkpoint in case of failures.

**State Sharing**: This implementation uses static ConcurrentHashMap to share state between Flink operators and Spring REST endpoints. In production, use Flink Queryable State or external state store (Redis, database) for distributed deployments.

#### How It Works

1. **Idempotent Producer**: Prevents duplicate messages on retry by assigning sequence numbers to each message batch.

2. **Transactional Writes**: Producer commits messages atomically across multiple partitions using transactions.

3. **Flink Stateful Processing**: Uses keyed state to deduplicate purchases and maintain aggregations with exactly-once guarantees.

4. **Flink Checkpointing**: Periodically saves operator state and positions in Kafka topics for fault tolerance.

#### Tradeoffs

**Benefits**: No duplicate processing, no data loss, atomic state updates with checkpoint-based recovery.

**Costs**: Slightly higher latency, checkpoint overhead, increased storage for state backends.

#### Production Considerations

For production environments:

- Configure RocksDB state backend for large state
- Enable incremental checkpointing
- Set appropriate checkpoint interval based on throughput
- Configure parallelism based on workload
- Use distributed state backend storage (HDFS, S3)
- Replace static ConcurrentHashMap with:
  - Flink Queryable State for direct state queries
  - External state store (Redis, database) for multi-instance deployments
  - REST API from Flink TaskManager for state access
- Ensure Kafka brokers have proper replication:
  - `transaction.state.log.replication.factor=3`
  - `transaction.state.log.min.isr=2`

#### Implementation Notes

**Embedded Flink**: This implementation runs Flink embedded within the Spring Boot application using `StreamExecutionEnvironment.getExecutionEnvironment()`. The Flink job runs in a separate thread started by `@PostConstruct`.

**State Management**: State is maintained in two places:
1. Flink keyed state (MapState, ValueState) for fault tolerance and recovery
2. Static ConcurrentHashMap for REST endpoint queries (single-instance deployment only)

**Limitations**:
- Single instance deployment only (static maps are not distributed)
- Not suitable for horizontal scaling without external state store
- State queries are eventually consistent (small delay between Flink processing and map updates)
