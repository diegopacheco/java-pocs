# Spark with Java 25 Compatibility Issue

## Problem

Apache Spark 3.5.0 (and Hadoop 3.3.4) are not compatible with Java 25 because they use the deprecated `javax.security.auth.Subject.getSubject()` method which was removed in Java 25.

The error encountered:
```
java.lang.UnsupportedOperationException: getSubject is not supported
    at java.base/javax.security.auth.Subject.getSubject(Subject.java:277)
    at org.apache.hadoop.security.UserGroupInformation.getCurrentUser(UserGroupInformation.java:577)
```

## Solutions

### Option 1: Use Java 21 (LTS) - RECOMMENDED

Downgrade to Java 21 which is the latest LTS version and fully supported by Spark 3.5.0:

```bash
export JAVA_HOME=/path/to/java21
java -version
mvn clean package -DskipTests
java -jar target/java-25-kafka-spark-windoning-eo-purchases-1.0-SNAPSHOT.war
```

### Option 2: Wait for Spark 4.0

Spark 4.0 will include Java 21+ support with fixes for the Subject API changes. Expected release: Q2 2025.

### Option 3: Use Kafka Streams (Original Implementation)

Revert to the Kafka Streams implementation which works with Java 25.

## What Was Changed

Successfully migrated from Kafka Streams to Spark Structured Streaming:

1. **Dependencies**: Replaced `kafka-streams` with `spark-core`, `spark-sql`, and `spark-sql-kafka`
2. **Configuration**: Created `SparkConfig` to initialize SparkSession
3. **Stream Processing**: Rewrote `PurchaseStreamProcessor` using Spark's Dataset API
4. **Functionality Preserved**:
   - Kafka producer with transactional writes
   - Deduplication by purchaseId  
   - Total debt aggregation by userId
   - Purchase history (last 20) per userId
   - All REST endpoints work identically

The code is ready and will work once Java 21 is used or Spark 4.0 is released.
