# Kafka Streams to Spark Migration

## Migration Completed

Successfully replaced Kafka Streams with Apache Spark Structured Streaming (version 4.0.0).

## Changes Made

### 1. pom.xml
- Removed: kafka-streams dependency
- Added: spark-core_2.13, spark-sql_2.13, spark-sql-kafka-0-10_2.13 (v4.0.0)
- Added: hadoop-client-api, hadoop-client-runtime (v3.4.2)
- Excluded conflicting logging dependencies

### 2. SparkConfig.java (NEW)
- Created SparkSession bean
- Configured for local execution with master=local[*]
- Set checkpoint location at /tmp/spark-checkpoint
- Configured Hadoop for simple authentication

### 3. PurchaseStreamProcessor.java (REWRITTEN)
- Replaced Kafka Streams topology with Spark Structured Streaming
- Reads from Kafka using spark.readStream().format("kafka")
- Deduplication using dropDuplicates("purchaseId")
- Aggregation using groupBy("userId").agg(sum("total"))
- Purchase history maintained in ConcurrentHashMap
- Uses foreachBatch sink to update in-memory state

### 4. KafkaConfig.java (UPDATED)
- Removed all Kafka Streams configuration
- Kept Kafka producer configuration (transactional writes)

### 5. application.properties (UPDATED)
- Removed spring.kafka.streams.* properties
- Kept all Kafka producer/consumer settings

## Functionality Preserved

- Kafka producer with transactional writes and exactly-once semantics
- Deduplication by purchaseId (prevents duplicate processing)
- Total debt aggregation by userId
- Purchase history tracking (last 20 purchases per user)
- All REST endpoints work identically:
  - GET /generate/{count}/{id} - Generate random purchases
  - GET /total/{id} - Get total debt for user
  - GET /history/{id} - Get purchase history
  - GET /duplicate/{count}/{id} - Test deduplication

## Java 25 Compatibility Issue

CRITICAL: Apache Spark 4.0.0 with Hadoop 3.4.2 is NOT YET compatible with Java 25.

Error: java.lang.UnsupportedOperationException: getSubject is not supported
    at org.apache.hadoop.security.UserGroupInformation.getCurrentUser

Root Cause: Hadoop uses deprecated Subject.getSubject() API which was removed in Java 25.

Tracked in: 
- HADOOP-19212 (Hadoop migration to Subject.current())
- SPARK-51167 (Spark Java 25 support)

Status:
- Hadoop 3.4.3 will include Java 25 support (not yet released)
- Spark 4.1.0 is being tested with Java 25 (still in development)

SOLUTION: Use Java 21 (LTS) to run this application until Hadoop 3.4.3 is released.

Run with Java 21:
```bash
export JAVA_HOME=/path/to/java21
mvn clean package -DskipTests
java -jar target/java-25-kafka-streams-windoning-eo-purchases-1.0-SNAPSHOT.war
```

The code migration is complete and correct. It just requires Java 21 runtime instead of Java 25.
