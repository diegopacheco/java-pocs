## Related POCS

- [1. Java Pure Memory - Stock Engine](https://github.com/diegopacheco/java-pocs/tree/master/pocs/stock-matcher-engine)
- [2. Java 25, Kafka, Kafka-Streams](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-kafka-streams-windoning-eo-purchases)
- [3. Java 25, Kafka, KsqlDB](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-kafka-ksqldb-windoning-eo-purchases)
- [4. Java 25, RocksDB](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-rocksdb-windoning-eo-purchases)
- [5. Java 25, Redis and Redis Streams](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-25-redis-windoning-eo-purchases)
- [6. Java 21, Kafka, Flink](https://github.com/diegopacheco/java-pocs/tree/master/pocs/java-21-kafka-flink-windoning-eo-purchases)

## Rationale

- Build an intentionally naive in-memory matcher in Java 19 to explore baseline costs for stock alerting.
- Keep a quadratic events x rules pass to measure worst-case latency before adding filtering or indexes.
- Use synthetic Nasdaq-like data to benchmark CPU and memory without external dependencies.
- Provide a reference point for future optimizations: rule caps, parallelism, better data structures or languages.
- Serve as a teaching toy for discussing complexity and scaling trade-offs in streaming/trading workloads.

### Build 
```bash
./mvnw clean install 
```

### About it

Stock exchange application written in java 19. 
Imagine you want to be notified when something happens, some GOOGLE(GOOG) stock went up or down.
There are some simple rules(Equal, GreaterThan,LessThan) when the stock price change. Fake Data generation techniques are used to generate a lot of data for benchmarks.
Such solution would be used for Day Trading applications.

### Design
<div align="center" >
<img src="UML.drawio.png" width="800" height="800" ></img><br/>
 **Interfaces was duplicated to make the diagram more clean.
</div>

UML in Colors scheme:
* Green: Interfaces
* Blue: Predicates (a.k.a rules)
* Purple: Fake data generation
* Dark blue: Matching engine
* Yellow: Raw events
* Red: Main class, main orchestration of the program and benchmarks

### Benchmark
```bash
Matching 10 events/predicates resulted in: [4] match in 0 ms
Matching 100 events/predicates resulted in: [242] match in 1 ms
Matching 1000 events/predicates resulted in: [34640] match in 47 ms
Matching 10000 events/predicates resulted in: [3143928] match in 1898 ms
Matching 100000 events/predicates resulted in: [313618905] match in 231192 ms (3.8 minutes)
```

### How can we optimize and scale

1. Start filtering the rules by users(uuid, id, hash, or symbol, whatever).
2. CAP how many rules a user can have lets say 100 is max.
3. Use thread pool, process all in parallel rather a single thread, is all cpu bound (2 threads per core).
4. Simple things, integers instead of strings for symbols, it would speed up things and use less memory. 
5. More machines with some seeding or light coordination(zookeeper like).
6. Instead of processing all at once, make continuous processing, as the events arrive you process.
7. Optimize the JVM with proper flags for GC and pre-alocate memory
8. Optimized languages like Go, Rust or Zig.

### CAP 100 rules

Now we can do:
 * 100k in 155 ms
 * 1M in 1 second
 * 10M in 10 seconds

Again, single machine, still have 7 other optimizations to play.

```bash
>> Benchmarks: CAP 100 rules 
Matching 10 events / 100 predicates resulted in: [33] match in 0 ms
Matching 100 events / 100 predicates resulted in: [253] match in 1 ms
Matching 1000 events / 100 predicates resulted in: [3229] match in 8 ms
Matching 10000 events / 100 predicates resulted in: [27412] match in 55 ms
Matching 100000 events / 100 predicates resulted in: [303540] match in 155 ms
Matching 1000000 events / 100 predicates resulted in: [3273769] match in 1090 ms
Matching 10000000 events / 100 predicates resulted in: [30800135] match in 10483 ms
```
