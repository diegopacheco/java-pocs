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

Each purchase has a unique `purchaseId` (UUID). Redis Streams consumer groups with optimistic locking are used to deduplicate purchases.

**How it works:**

1. Each Purchase is assigned a unique UUID `purchaseId` when created
2. Redis Streams consumer groups track message processing with XREADGROUP
3. WATCH command provides optimistic locking on deduplication keys
4. MULTI/EXEC transactions ensure atomic deduplication check and state updates
5. Deduplication keys use SETEX with 24-hour TTL to prevent unbounded growth
6. XACK confirms successful message processing
7. Pending message recovery with XCLAIM handles consumer failures

This ensures that even if the same purchase message is sent multiple times to Redis Streams (due to retries, duplicate API calls, etc.), it will only be counted once in the total debt calculation and appear once in the purchase history.

**Benefits:**

- No duplicate debt accumulation from the same purchase
- Idempotent purchase processing regardless of message retries
- Protection against accidental duplicate API calls
- Automatic recovery from consumer failures via pending message processing
- TTL on deduplication keys prevents memory leaks

#### Redis Streams Consumer Group Configuration

**Consumer Group**: `purchase-processor-group`

**Consumer Name**: `processor-1`

**Processing Mode**: XREADGROUP with automatic offset tracking

Redis Streams consumer groups automatically track message offsets and provide exactly-once delivery semantics within the group. Messages are delivered to only one consumer in the group, and the offset is managed by Redis.

#### Atomic Operations

**Deduplication with Optimistic Locking:**
```
WATCH dedup:{purchaseId}
GET dedup:{purchaseId}
MULTI
SETEX dedup:{purchaseId} 86400 "1"
EXEC
```

WATCH ensures that if another consumer processes the same purchaseId concurrently, the transaction will fail and retry, preventing duplicates.

**Atomic Debt Updates:**
```
INCRBYFLOAT total:{userId} {amount}
```

INCRBYFLOAT is an atomic operation that eliminates read-modify-write race conditions. No locks or transactions needed.

**Atomic History Updates:**
```
WATCH history:{userId}
MULTI
LPUSH history:{userId} {purchaseJson}
LTRIM history:{userId} 0 19
EXEC
```

WATCH with MULTI/EXEC ensures atomic list updates even with concurrent consumers.

#### Message Acknowledgment

**XACK**: Messages are acknowledged only after successful processing and state updates.

**Pending Message Recovery**: XPENDING and XCLAIM automatically recover messages from failed consumers.

#### How It Works

1. **Producer**: Uses XADD to append messages to Redis Stream atomically.

2. **Consumer Group**: XREADGROUP reads messages with automatic offset management.

3. **Optimistic Locking**: WATCH detects concurrent modifications and retries transactions.

4. **Atomic Updates**: MULTI/EXEC transactions ensure all-or-nothing state changes.

5. **Deduplication TTL**: SETEX with 24-hour expiration prevents memory bloat.

6. **Message Acknowledgment**: XACK confirms processing, removing from pending list.

7. **Failure Recovery**: XCLAIM reclaims pending messages from dead consumers.

#### Tradeoffs

**Benefits**: No duplicate processing, no data loss, atomic updates, automatic failure recovery, bounded memory usage.

**Costs**: Retry overhead on transaction conflicts, slightly higher latency for WATCH/MULTI/EXEC, pending message processing overhead.

#### Production Considerations

For production environments:

```properties
redis.host=redis-cluster-endpoint
redis.port=6379
```

Deploy multiple consumer instances with different consumer names in the same group for horizontal scaling:
- `processor-1`
- `processor-2`
- `processor-3`

Configure Redis persistence:
- Enable AOF (Append-Only File) for durability
- Use Redis Sentinel or Redis Cluster for high availability
- Set appropriate `maxmemory-policy` (e.g., `noeviction`)

Adjust TTL based on business requirements:
```java
private static final int DEDUP_TTL_SECONDS = 86400;
```

Monitor pending messages:
```
XPENDING purchases purchase-processor-group
```
